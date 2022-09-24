package com.atguigu.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: liubaojun
 * Date: 2022/9/13
 * Time: 20:28
 * Description: No Description
 */
@Data
//指定实体类对应的数据库表
@TableName(value = "user")
public class User {
    //value指定字段对应数据库的主键，type指定逐渐的生成策略
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    //指定数据库字段与实体类字段的映射关系
    @TableField(value = "name")
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    private Integer isDeleted;
}
