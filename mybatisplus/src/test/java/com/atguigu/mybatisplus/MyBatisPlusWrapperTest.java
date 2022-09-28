package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

@SpringBootTest
public class MyBatisPlusWrapperTest {

    @Resource
    public UserMapper userMapper;

    @Test
    public void test1(){
        //查询姓名带字母e  年龄大于20  邮箱不为空
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.like("name","e")
                        .eq("age",24)
                                .isNotNull("email");
        List<User> list = userMapper.selectList(userWrapper);

        list.forEach(System.out::println);
    }

    @Test
    public void test2(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.gt("age",21);
        int delete = userMapper.delete(userQueryWrapper);
        System.out.println(delete);
    }

    @Test
    public void test3(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // UPDATE user SET name=? WHERE is_deleted=0 AND (age > ? AND name LIKE ? OR email IS NULL)
        queryWrapper.gt("age",20)
                .like("name","a")
                .or()
                .isNull("email");

        User user = new User();
        user.setName("Sandy_Test");
        int update = userMapper.update(user, queryWrapper);
        System.out.println(update);

    }

    @Test
    public void test4(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //UPDATE user SET name=? WHERE is_deleted=0 AND (name LIKE ? AND (age > ? OR email IS NOT NULL))
        queryWrapper.like("name","a")
                .and(wrapper -> wrapper.gt("age",50).or().isNotNull("email"));
        User user = new User();
        user.setName("MyBatisPlus_Test");
        int update = userMapper.update(user, queryWrapper);
        System.out.println(update);
    }

    @Test
    public void test5(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test6(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("name","m")
                .and(wrapper -> wrapper.gt("age",20).or().isNotNull("email"));
        updateWrapper.set("email","plus@email.com");
        int update = userMapper.update(null, updateWrapper);
        System.out.println(update);
    }
    @Test
    public void test7(){
        String name = "";
        Integer sAge = 10;
        Integer eAge = 50;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotColumnName(name),"name",name)
                .ge(sAge != null,"age",sAge)
                .le(eAge != null,"age",eAge);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
        users.stream().map(User::getName).forEach(System.out::println);
    }

    @Test
    public void test8(){
        String name = "";
        Integer sAge = 10;
        Integer eAge = 50;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(name),User::getName,name);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

}







