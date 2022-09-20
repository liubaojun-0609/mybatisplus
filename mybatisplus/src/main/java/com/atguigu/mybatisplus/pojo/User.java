package com.atguigu.mybatisplus.pojo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: liubaojun
 * Date: 2022/9/13
 * Time: 20:28
 * Description: No Description
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
