package jpademo.sqlserver;

import jpademo.AbstractTest;
import org.junit.jupiter.api.Disabled;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@Disabled // Github doesn't have a SQL Server instance
@SpringJUnitConfig(SqlServerConfiguration.class)
class TestWithSqlServer extends AbstractTest {

}
