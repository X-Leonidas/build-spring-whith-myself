package cn.xy.springframework.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiangyu
 * @date 2022-02-22 22:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyValue {
    private String name;
    private Object value;
}
