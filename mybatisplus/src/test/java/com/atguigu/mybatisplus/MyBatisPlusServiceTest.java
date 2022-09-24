package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class MyBatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void selectAllCount(){
        //SELECT COUNT( * ) FROM user
        long count = userService.count();
        log.info("当前表总记录数为：" + count);
    }

    @Test
    public void batchInset(){
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setAge(20 + i);
            user.setName("lbj" + i);
            users.add(user);
        }

        boolean b = userService.saveBatch(users);
        log.info("批量添加结果：" + b);
    }

    @Test
    public void testLogicDel(){
        userService.removeById(1);
    }
}
