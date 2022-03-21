package cn.xy.springframework.beans.factory;

/**
 * @author xiangyu
 * @date 2022-03-20 22:40
 *
 * Interface to be implemented by beans that want to be aware of their
 * bean name in a bean factory. Note that it is not usually recommended
 * that an object depend on its bean name, as this represents a potentially
 * brittle dependence on external configuration, as well as a possibly
 * unnecessary dependence on a Spring API.
 *
 *
 * 由希望在 bean 工厂中通过bean name 感知到bean的实现的接口
 * 请注意，通常不建议对象依赖其 bean 名称，因为这表示对外部配置的潜在脆弱依赖，以及对 Spring API 的可能不必要的依赖。
 *
 *
 */
public interface BeanNameAware extends Aware{
    void setBeanName(String name);
}
