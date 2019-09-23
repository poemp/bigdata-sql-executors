package com.zgph.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author sangfor
 */
@Configuration
public class DataSourceConfig {


    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);


    /**
     * 初始化数据库查询
     *
     * @return 数据库实例
     */
    @Bean(name = "prodDatabases")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDefaultDataSource() {
        logger.info("---------------- prodDatabases init -----------------");
        DruidDataSource druidDataSource = DataSourceBuilder.create().type(DruidDataSource.class).build();
        logger.info("---------------- prodDatabases init ok -----------------");
        return druidDataSource;
    }
}
