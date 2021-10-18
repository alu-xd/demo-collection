package com.lulu.mybatis.ext;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

@Intercepts({@Signature(
        type= Executor.class,
        method = "update",
        args = {MappedStatement.class,Object.class})})
public class DemoPlugin implements Interceptor {
    private Properties properties = new Properties();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("##############before update: " + invocation.getMethod());
        Object returnObject = invocation.proceed();
        System.out.println("##############after update: " + invocation.getMethod());
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
