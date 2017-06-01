package io.egen;

import com.sun.tracing.dtrace.ProviderAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Ajith on 5/30/2017.
 */
@Configuration
public class JPAConfig {


    @Bean
    public LocalContainerEntityManagerFactoryBean enf() {
        LocalContainerEntityManagerFactoryBean enf = new LocalContainerEntityManagerFactoryBean();
        enf.setDataSource(dataSource());
        enf.setPackagesToScan("io.egen.entity");
        enf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        enf.setJpaProperties(jpaProperties());

        return enf;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/car_tracker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        ds.setPassword("root");
        ds.setUsername("root");
        return ds;
    }

    private Properties jpaProperties() {
        Properties props = new Properties();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create");
        return props;
    }
}
