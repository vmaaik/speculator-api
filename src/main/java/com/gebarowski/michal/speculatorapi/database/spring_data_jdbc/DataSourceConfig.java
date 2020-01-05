package com.gebarowski.michal.speculatorapi.database.spring_data_jdbc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db/connection.properties")
public class DataSourceConfig {

    @Value("${db.driverClassName}")
    private String driverClassName;

    @Value("${db.url}")
    private String url;

    @Value("${db.userName}")
    private String userName;

    @Value("${db.password}")
    private String passwaord;

    @Value("classpath:db/schema.sql")
    private Resource schemaScipt;

    @Value("classpath:db/data.sql")
    private Resource dataScript;

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(userName);
        dataSourceBuilder.password(passwaord);
        DatabasePopulatorUtils.execute(databasePopulator(), getDataSource());
        return dataSourceBuilder.build();
    }

    private DatabasePopulator databasePopulator() {
        final ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();

        resourceDatabasePopulator.addScript(schemaScipt);
        resourceDatabasePopulator.addScript(dataScript);

        return resourceDatabasePopulator;
    }
}
