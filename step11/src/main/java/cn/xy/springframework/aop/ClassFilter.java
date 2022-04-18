package cn.xy.springframework.aop;

/**
 * Filter that restricts matching of a pointcut or introduction to
 * a given set of target classes.
 *
 * @author xiangyu
 * @date 2022-04-18 22:48
 */
public interface ClassFilter {
    /**
     * Should the pointcut apply to the given interface or target class?
     *
     * @param clazz the candidate target class
     * @return whether the advice should apply to the given target class
     */
    boolean matcher(Class<?> clazz);
}
