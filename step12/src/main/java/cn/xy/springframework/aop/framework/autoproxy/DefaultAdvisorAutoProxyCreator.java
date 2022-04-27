package cn.xy.springframework.aop.framework.autoproxy;

import cn.xy.springframework.aop.*;
import cn.xy.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import cn.xy.springframework.aop.framework.ProxyFactory;
import cn.xy.springframework.beans.BeansException;
import cn.xy.springframework.beans.factory.BeanFactory;
import cn.xy.springframework.beans.factory.BeanFactoryAware;
import cn.xy.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.xy.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

/**
 * BeanPostProcessor implementation that creates AOP proxies based on all candidate
 * Advisors in the current BeanFactory. This class is completely generic; it contains
 * no special code to handle any particular aspects, such as pooling aspects.
 *
 * @author xiangyu
 * @date 2022-04-27 20:54
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory defaultListableBeanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (isInfrastructureClass(beanClass)) {
            return null;
        }

        Collection<AspectJExpressionPointcutAdvisor> advisors = defaultListableBeanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();

        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            // TODO:只能代理一次？
            if (classFilter.matcher(beanClass)) {
                AdvisedSupport advisedSupport = new AdvisedSupport();
                TargetSource targetSource = null;
                try {
                    targetSource = new TargetSource(beanClass.getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                advisedSupport.setTargetSource(targetSource);
                advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
                advisedSupport.setProxyTargetClass(false);

                return new ProxyFactory(advisedSupport).getProxy();
            }
        }
        return null;
    }


    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advisor.class.isAssignableFrom(beanClass) || Advice.class.isAssignableFrom(beanClass) || PointCut.class.isAssignableFrom(beanClass);
    }

}
