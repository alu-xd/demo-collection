package com.lulu.mybatis.ext;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

@Intercepts({@Signature(
        type= Executor.class,
        method = "update",
        args = {MappedStatement.class,Object.class})})
public class MyUpdatePlugin implements Interceptor {
    private Properties properties = new Properties();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("before update: " + properties.getProperty("before"));
        Object returnObject = invocation.proceed();
        System.out.println("after update: " + properties.getProperty("after"));
        return returnObject;
    }

    @Override
    public Object plugin(Object o) {
         return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
