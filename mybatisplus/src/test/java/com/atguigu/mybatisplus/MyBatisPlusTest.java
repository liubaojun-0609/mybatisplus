package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liubaojun
 * Date: 2022/9/13
 * Time: 20:34
 * Description: No Description
 */
@SpringBootTest
public class MyBatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectAll(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
