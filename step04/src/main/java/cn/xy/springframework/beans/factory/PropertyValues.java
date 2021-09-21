package cn.xy.springframework.beans.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XiangYu
 * @create2021-09-19-22:34
 */
public class PropertyValues {
    private List<PropertyValue> propertyValueList = new ArrayList<>();


    /**
     * 缓存
     */
    private Map<String, PropertyValue> cache = new HashMap<>();

    public void addPropertyValue(PropertyValue value) {
        propertyValueList.add(value);
        cache.put(value.getName(), value);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String beanName) {
        return cache.getOrDefault(beanName, null);
    }

    public void setPropertyValueList(List<PropertyValue> propertyValueList) {
        this.propertyValueList = propertyValueList;
    }
}
