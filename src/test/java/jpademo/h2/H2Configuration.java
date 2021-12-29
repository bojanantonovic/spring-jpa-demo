package jpademo.h2;

import jpademo.AbstractConfiguration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:h2-properties.properties")
public class H2Configuration extends AbstractConfiguration {

}
