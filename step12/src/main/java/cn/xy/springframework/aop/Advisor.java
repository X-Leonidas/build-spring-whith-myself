package cn.xy.springframework.aop;


import org.aopalliance.aop.Advice;

/**
 * base interface holding aop <b>advice</b> (action to take at a joinpoint)
 * and a filter determining the applicability of the advice (such as
 * a pointcut). <i>this interface is not for use by spring users, but to
 * allow for commonality in support for different types of advice.</i>
 *
 * @author xiangyu
 * @date 2022-04-27 20:40
 */
public interface Advisor {

    /**
     * Return the advice part of this aspect. An advice may be an
     * interceptor, a before advice, a throws advice, etc.
     * @return the advice that should apply if the pointcut matches
     * @see org.aopalliance.intercept.MethodInterceptor
     * @see BeforeAdvice
     */
    Advice getAdvice();
}
