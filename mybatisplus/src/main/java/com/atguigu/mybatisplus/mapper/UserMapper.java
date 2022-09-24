package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liubaojun
 * Date: 2022/9/13
 * Time: 20:32
 * Description: No Description
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据id查询用户信息，并返回map集合
     */
    Map<String,Object> selectByIdForMap(Long id);
}
