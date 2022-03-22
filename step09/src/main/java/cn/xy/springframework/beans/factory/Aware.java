package cn.xy.springframework.beans.factory;

/**
 * @author xiangyu
 * @date 2022-03-20 22:34
 * marker superinterface indicating that a bean is eligible to be
 * notified by the spring container of a particular framework object
 * through a callback-style method.  actual method signature is
 * determined by individual subinterfaces, but should typically
 * consist of just one void-returning method that accepts a single
 * argument.
 *
 *  标记超接口，指示 bean 有资格通过回调方法由特定框架对象的 spring 容器通知。
 *  实际的方法签名由各个子接口确定，但通常应仅包含一个接受单个参数的返回 void 的方法。
 *
 *
 */
public interface Aware {
}
