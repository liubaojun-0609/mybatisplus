package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class MybatisPlusPageTest {
    @Resource
    private UserMapper userMapper;


    @Test
    public void test1(){
        IPage<User> page = new Page<>(1,2);
        IPage<User> page1 = userMapper.selectPage(page, null);
        System.out.println(page1);
        List<User> records = page1.getRecords();
        System.out.println("查询结果：" + records.toString());
        long pages = page1.getPages();
        System.out.println("条数：" + pages);
        long current = page1.getCurrent();
        System.out.println("页码：" + current);
        long total = page1.getTotal();
        System.out.println("总条数：" + total);

    }

    @Test
    public void test2(){
        Page<User> page = new Page<>(1,2);
        userMapper.selectListVo(page,"20");
        List<User> records = page.getRecords();
        System.out.println(records.toString());
    }
}
