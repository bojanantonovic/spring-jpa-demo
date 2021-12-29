package jpademo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan
@EnableJpaRepositories(basePackages = "jpademo")
@EnableTransactionManagement
public abstract class AbstractConfiguration {

	@Value("${db.dialect}")
	private String dialect;
	@Value("${db.hbm2ddl}")
	private String hbm2ddl;

	@Bean
	public Properties hibernateProperties() {
		final var hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect", dialect);
		hibernateProp.put("hibernate.hbm2ddl.auto", hbm2ddl);

		hibernateProp.put("hibernate.format_sql", true);
		hibernateProp.put("hibernate.use_sql_comments", true);
		hibernateProp.put("hibernate.show_sql", true);
		return hibernateProp;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource, final Properties hibernateProperties) {
		final var factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan("jpademo");
		final var vendorAdapter = new HibernateJpaVendorAdapter();
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setJpaProperties(hibernateProperties);
		return factoryBean;
	}

	@Value("${driver.class.name}")
	private String driverClassName;
	@Value("${url}")
	private String url;
	@Value("${jdbc.user.name}")
	private String userName;
	@Value("${password}")
	private String password;

	@Bean
	DriverManagerDataSource createDriverManagerDataSource() {
		var dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);

		return dataSource;
	}

	@Bean
	public JpaTransactionManager transactionManager(final DataSource dataSource) {
		final var transactionManager = new JpaTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}
}
