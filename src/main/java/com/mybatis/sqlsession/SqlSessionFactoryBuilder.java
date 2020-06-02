package com.mybatis.sqlsession;

import com.mybatis.cfg.Configuration;
import com.mybatis.defaults.DefaultSqlSessionFactory;
import com.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节流来构建一个SqlSessionFactory对象
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return  new DefaultSqlSessionFactory(cfg);
    }

}
