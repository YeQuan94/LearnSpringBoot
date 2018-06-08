package com.cave.example3.dao.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

// 查看Mapper和MySqlMapper就可以直接两个接口分别什么作用
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
