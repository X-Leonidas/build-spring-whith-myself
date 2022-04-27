package cn.xy.springframework.aop;

import lombok.Getter;
import lombok.Setter;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author xiangyu
 * @date 2022-04-18 23:07
 */
@Getter
@Setter
public class AdvisedSupport {

    /**
     * ProxyConfig  使用啥代理的配置
     */
    private boolean proxyTargetClass = false;

    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;

    private MethodMatcher methodMatcher;
}
