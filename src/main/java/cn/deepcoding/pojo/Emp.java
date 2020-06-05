package cn.deepcoding.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Created by admin on 2020-06-05 03:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emp {
    private String id;
    private String name;
    private Double salary;
    private Integer age;
    private Date bir;
}
