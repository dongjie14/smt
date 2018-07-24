package com.dj.common.MybatisPlugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by dongjie on 2018/6/21.
 */
@Intercepts({
    @Signature(
        /**
         * type：标记需要拦截的类
         * method: 标记是拦截类的那个方法
         * args: 标记拦截类方法的具体那个引用（尤其是重载时）
        */
        type = Executor.class,  // 只能是: StatementHandler | ParameterHandler | ResultSetHandler | Executor 类或者子类
        method = "query",       // 表示：拦截Executor的query方法
        args = {                // query 有很多的重载方法，需要通过方法签名来指定具体拦截的是那个方法
            MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class
        }
    )}
)
public class PaginationInterceptor implements Interceptor {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("============= mybatis intercept =============");
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
