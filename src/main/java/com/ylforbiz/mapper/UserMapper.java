package com.ylforbiz.mapper;

import com.ylforbiz.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    /**
     * 註解方式只適合簡單sql語句
     */
    @Select("select * from tb_user where id = #{id}")
    User selectById(int id);
}
