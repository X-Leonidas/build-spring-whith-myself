package cn.xy.springframework.aop.framework;

/**
 *
 * Delegate interface for a configured AOP proxy, allowing for the creation
 * of actual proxy objects.
 *
 * <p>Out-of-the-box implementations are available for JDK dynamic proxies
 * and for CGLIB proxies, as applied by DefaultAopProxyFactory
 *
 * AOP 代理的抽象
 * @author xiangyu
 * @date 2022-04-18 23:09
 */
public interface AopProxy {

    Object getProxy();
}
