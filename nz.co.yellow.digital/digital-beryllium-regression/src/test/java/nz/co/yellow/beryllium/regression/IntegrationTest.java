package nz.co.yellow.beryllium.regression;

import cucumber.api.junit.Cucumber;
import nz.co.yellow.autotest.spring.YellowAutoTestContext;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by jim.wei@yellow.co.nz on 06/07/14.
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
