package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class MyBatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectAll() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(20);
        user.setEmail("jack@email.com");
        user.setName("jack");
        int insert = userMapper.insert(user);
        log.info("插入条数：" + insert);
        log.info("自动生成的id：" + user.getId());
    }
}
