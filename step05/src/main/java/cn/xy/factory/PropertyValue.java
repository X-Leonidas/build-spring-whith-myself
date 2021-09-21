package cn.xy.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XiangYu
 * @create2021-09-19-22:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyValue {
    private String name;
    private Object value;
}
