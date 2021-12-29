package jpademo;

import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:sql-server-properties.properties")
public class SqlServerConfiguration extends AbstractConfiguration {

}
