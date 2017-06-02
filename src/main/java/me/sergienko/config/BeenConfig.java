package me.sergienko.config;

import me.sergienko.dao.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeenConfig {

    @Bean(name = "studentJdbcDAO")
    StudentDAO studentDAO() {
        return new StudentJdbcDAOImpl();
    }
}
