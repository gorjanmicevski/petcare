package support;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.springframework.test.context.TestConstructor.AutowireMode.ALL;

@Retention(RUNTIME)
@SpringBootTest
@EnableAutoConfiguration
@ContextConfiguration(classes = ModuleTest.class)
@TestConstructor(autowireMode = ALL)
@Testcontainers
@ActiveProfiles("test")
@ComponentScan(basePackages = {"petcarehotel.webapplication"})
@AutoConfigureDataJpa
public @interface
ModuleTest {
}
