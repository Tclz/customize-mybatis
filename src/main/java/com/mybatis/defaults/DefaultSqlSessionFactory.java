package com.mybatis.defaults;

import com.mybatis.cfg.Configuration;
import com.mybatis.sqlsession.SqlSession;
import com.mybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    /**
     * 用于创建一个新的操作数据库对象
     * @return
     *
     */
    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
