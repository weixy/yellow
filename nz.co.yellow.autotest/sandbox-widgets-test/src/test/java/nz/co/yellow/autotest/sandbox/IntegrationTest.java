package nz.co.yellow.autotest.sandbox;

import cucumber.api.junit.Cucumber;
import nz.co.yellow.autotest.spring.YellowAutoTestContext;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by weixy on 19/07/14.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(
        features = "classpath:nz/co/yellow",
        glue = "nz.co.yellow",
        tags = {"~@deprecated"},
        format = "json:target/cucumber-json-report.json")
@ContextConfiguration(classes = {YellowAutoTestContext.class})
public class IntegrationTest {
}
