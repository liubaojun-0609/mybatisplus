package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MybatisPlusPageTest {
    @Resource
    private UserMapper userMapper;


    @Test
    public void test1(){
        IPage<User> page = new Page<>(1,2);
        IPage<User> page1 = userMapper.selectPage(page, null);
        System.out.println(page1);
    }
}
