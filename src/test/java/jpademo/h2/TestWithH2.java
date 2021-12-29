package jpademo.h2;

import jpademo.AbstractTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(H2Configuration.class)
class TestWithH2 extends AbstractTest {

}
