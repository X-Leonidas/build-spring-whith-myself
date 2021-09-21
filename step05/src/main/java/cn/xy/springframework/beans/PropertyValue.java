package cn.xy.springframework.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author XiangYu
 * @create2021-09-19-22:30
 */
@Data
@AllArgsConstructor
public class PropertyValue {
    /**
     * 加 final 是为了解决包访问的问题
     */
    private final String name;
    private final Object value;
}
