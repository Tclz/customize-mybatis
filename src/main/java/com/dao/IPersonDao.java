package com.dao;

import com.domain.Person;
import com.mybatis.annotations.Select;

import java.util.List;

public interface IPersonDao {

    // 注解的方式
    @Select("select * from person")
    List<Person> findAll();
}
