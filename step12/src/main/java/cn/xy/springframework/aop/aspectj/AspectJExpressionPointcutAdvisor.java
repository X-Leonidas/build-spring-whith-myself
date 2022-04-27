package cn.xy.springframework.aop.aspectj;

import cn.xy.springframework.aop.PointCut;
import cn.xy.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

import java.util.Objects;


/**
 * @author xiangyu
 * @date 2022-04-27 20:44
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
    /**
     * 切面
     */
    private AspectJExpressionPointcut pointcut;
    /**
     * 具体的拦截方法
     */
    private Advice advice;
    /**
     * 拦截表达式
     */
    private String expression;

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public PointCut getPointcut() {
        if (Objects.isNull(pointcut)) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
