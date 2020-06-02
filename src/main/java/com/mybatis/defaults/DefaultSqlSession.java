package com.mybatis.defaults;

import com.mybatis.cfg.Configuration;
import com.mybatis.proxy.MapperProxy;
import com.mybatis.sqlsession.SqlSession;
import com.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SqlSession接口的实现类
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection connection;
    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }
    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));


    }

    /**
     * 释放资源
     */
    public void close(){
        if(connection!=null){
            try {
                connection.close();
            }catch (Exception e){
                throw new RuntimeException(e);
            }

        }

    }
}
