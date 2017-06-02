package me.sergienko.config;

import me.sergienko.dao.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BeenConfig {

    @Bean(name = "studentJdbcDAO")
    StudentDAO studentDAO() {
        return new StudentJdbcDAOImpl();
    }
}
