package jpademo.sqlserver;

import jpademo.AbstractConfiguration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:sql-server-properties.properties")
public class SqlServerConfiguration extends AbstractConfiguration {

}
