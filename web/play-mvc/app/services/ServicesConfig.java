package services;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("services")
@EnableTransactionManagement
@ImportResource("classpath:spring-config.xml")  //a quick way of linking xml-based configuration with java config.
public class ServicesConfig {

    //in a similar way, the other existing beans in the xml file could be moved here.
    @Bean(destroyMethod = "close", name = "dataSource")
    public ComboPooledDataSource getDataSource(@Value("${db.jdbc.url}") String url,
                                               @Value("${db.driver.class}") String driver,
                                               @Value("${db.user}") String user,
                                               @Value("${db.pass}") String pass) throws PropertyVetoException {

        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass(driver);
        ds.setJdbcUrl(url);
        ds.setUser(user);
        ds.setPassword(pass);

        return ds;
    }


}
