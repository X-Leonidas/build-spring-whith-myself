import beans.IUserService;
import beans.UserService;
import beans.UserServiceInterceptor;
import cn.xy.springframework.aop.AdvisedSupport;
import cn.xy.springframework.aop.TargetSource;
import cn.xy.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.xy.springframework.aop.framework.Cglib2AopProxy;
import cn.xy.springframework.aop.framework.JdkDynamicAopProxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;
import org.junit.Test;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xiangyu
 * @date 2022-03-28 23:34
 */
public class ApiTest {
    @Test
    public void test_proxy_method() {
        UserService userService = new UserService();
        IUserService proxy = (IUserService) Proxy.newProxyInstance(
                // classLoader
                Thread.currentThread().getContextClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Set<PointcutPrimitive> hashSet = new HashSet<>();
                        // 设置切点基础动作
                        hashSet.add(PointcutPrimitive.EXECUTION);
                        final PointcutParser pointcutParser =
                                PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingSpecifiedClassLoaderForResolution(hashSet, this.getClass().getClassLoader());
                        final PointcutExpression pointcutExpression = pointcutParser.parsePointcutExpression("execution(* beans.IUserService.*(..))");

                        if (pointcutExpression.matchesMethodExecution(method).alwaysMatches()) {
                            // 方法拦截器
                            MethodInterceptor methodInterceptor = invocation -> {
                                long start = System.currentTimeMillis();
                                try {
                                    return invocation.proceed();
                                } finally {
                                    System.out.println("监控 - Begin By AOP");
                                    System.out.println("方法名称：" + invocation.getMethod().getName());
                                    System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                                    System.out.println("监控 - End\r\n");
                                }
                            };
                            // 反射调用
                            return methodInterceptor.invoke(new MethodInvocation() {
                                @Override
                                public Object proceed() throws Throwable {
                                    return method.invoke(userService, args);
                                }

                                @Override
                                public Object getThis() {
                                    return userService;
                                }

                                @Override
                                public AccessibleObject getStaticPart() {
                                    return method;
                                }

                                @Override
                                public Object[] getArguments() {
                                    return args;
                                }

                                @Override
                                public Method getMethod() {
                                    return method;
                                }
                            });
                        }
                        return method.invoke(userService, args);
                    }
                });
        String result = proxy.queryUserInfo();
        System.out.println("测试结果：" + result);
    }


    @Test
    public void test_dynamic() {
        // 目标对象
        IUserService userService = new UserService();
        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution( * beans.IUserService.*(..))"));

        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }
}
