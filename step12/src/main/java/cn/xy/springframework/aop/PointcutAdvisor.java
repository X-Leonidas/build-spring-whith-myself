package cn.xy.springframework.aop;

/**
 * superinterface for all advisors that are driven by a pointcut.
 * this covers nearly all advisors except introduction advisors,
 * for which method-level matching doesn't apply.
 *
 * @author xiangyu
 * @date 2022-04-27 20:42
 */
public interface PointcutAdvisor extends Advisor {

    /**
     * Get the Pointcut that drives this advisor.
     */
    PointCut getPointcut();
}
