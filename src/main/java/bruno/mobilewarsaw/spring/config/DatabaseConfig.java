package bruno.mobilewarsaw.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DatabaseConfig {

    @Autowired
    Environment environment;

    @Autowired
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource,
                                                  Properties hibernateProperties) {

        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan("bruno.mobilewarsaw.spring");
        sessionFactoryBean.setHibernateProperties(hibernateProperties);
        return sessionFactoryBean;
    }

    @Bean
    public DataSource dataSource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(environment.getRequiredProperty("rds.driverClass"));
            dataSource.setJdbcUrl(environment.getRequiredProperty("rds.url"));
            dataSource.setUser(environment.getRequiredProperty("rds.username"));
            dataSource.setPassword(environment.getRequiredProperty("rds.password"));

            dataSource.setIdleConnectionTestPeriod(30);
            dataSource.setMaxIdleTimeExcessConnections(60);
            dataSource.setAcquireIncrement(5);
            dataSource.setMaxPoolSize(25);
            dataSource.setMinPoolSize(5);
            dataSource.setTestConnectionOnCheckin(true);
            dataSource.setMaxIdleTime(300);
            dataSource.setPreferredTestQuery("select 1");

            return dataSource;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("rds.hibernate.hbm2ddl.auto"));
        hibernateProperties.put("hibernate.dialect", environment.getRequiredProperty("rds.hibernate.dialect"));
        hibernateProperties.put("hibernate.show_sql", environment.getRequiredProperty("rds.hibernate.show_sql"));
        hibernateProperties.put("hibernate.format_sql", environment.getRequiredProperty("rds.hibernate.format_sql"));
        return hibernateProperties;
    }

    @Autowired
    @Bean
    public HibernateTransactionManager transactionManager(DataSource dataSource,
                                                          Properties hibernateProperties) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory(dataSource, hibernateProperties).getObject());
        return transactionManager;
    }
}
