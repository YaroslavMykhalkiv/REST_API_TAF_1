package cucumber.config;

import cucumber.MainApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = MainApplication.class)
public class SpringContextConfiguration {
}