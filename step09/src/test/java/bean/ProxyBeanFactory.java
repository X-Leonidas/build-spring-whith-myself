package bean;

import cn.xy.springframework.beans.factory.FactoryBean;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2022-03-22 22:38
 */
@Log4j2
public class ProxyBeanFactory implements FactoryBean<IUserDao> {
    private Object object = new Object();

    @Override
    public IUserDao getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            // 添加排除方法
            if ("toString".equals(method.getName())) return this.toString();

            if ("queryUserName".equals(method.getName())) {
                log.info("开始模拟代理类");
                Map<String, String> hashMap = new HashMap<>();
                hashMap.put("10001", "XXXXXX");
                hashMap.put("10002", "八杯水");
                hashMap.put("10003", "阿毛");
                return "你被代理了 " + method.getName() + "：" + hashMap.get(args[0].toString());
            }

            return method.invoke(object, args);
        };
        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
