package kz.iitu.edu.payroll.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@Configuration
@ComponentScan(basePackages = "kz.iitu.edu.payroll")
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = "kz.iitu.edu.payroll.repository")
public class SpringConfiguration {

}
