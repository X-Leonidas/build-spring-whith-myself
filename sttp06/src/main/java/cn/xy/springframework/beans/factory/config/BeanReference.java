package cn.xy.springframework.beans.factory.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiangyu
 * @date 2022-02-22 22:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeanReference {
    private String referenceBeanName;
}
