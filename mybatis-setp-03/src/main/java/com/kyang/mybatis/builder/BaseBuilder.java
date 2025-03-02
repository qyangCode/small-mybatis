package com.kyang.mybatis.builder;

import com.kyang.mybatis.session.Configuration;

/**
 * @Author：wqy
 * @Description：
 * @create：2025-03-02
 */

public abstract class BaseBuilder {
    protected Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
