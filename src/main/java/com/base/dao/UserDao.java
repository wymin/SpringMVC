package com.base.dao;

import com.base.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
     * 查询所有用户
     * @return list
     */
    List<User> findAllUser();


    /**
     * 查询所有用户使用Select注解
     * @return list
     */
    @Select("select * from t_user t;")
    List<User> findAllUserNoMaping();
}
