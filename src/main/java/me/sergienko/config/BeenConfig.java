package me.sergienko.config;

import me.sergienko.dao.*;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@PropertySource("src/main/resources/db.properties")
public class BeenConfig {

    @Bean(name = "studentJdbcDAO")
    StudentDAO studentDAO() {
        return new StudentJdbcDAOImpl();
    }

    @Bean
    public DataSource dataSource()
    {
        BasicDataSource dataSource = new BasicDataSource();

        return dataSource;
    }
}
