package cn.xy.springframework.aop;

import java.lang.reflect.Method;

/**
 * Part of a {@link PointCut}: Checks whether the target method is eligible for advice.
 *
 * @author xiangyu
 * @date 2022-04-18 22:49
 */
public interface MethodMatcher {
    /**
     * Perform static checking whether the given method matches. If this
     *
     * @return whether or not this method matches statically
     */
    boolean matchers(Method method, Class<?> targetClass);
}
