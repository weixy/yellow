package nz.co.yellow.autotest.sandbox;

import cucumber.api.java.en.Given;
import nz.co.yellow.autotest.spring.YellowAutoTestContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import javax.inject.Inject;

/**
 * Created by weixy on 18/07/2014.
 */
@ContextConfiguration(classes = {YellowAutoTestContext.class})
@Component
public class TestSelect2Steps {

    @Inject
    Select2Page sel2page;

    @Given("^I open the web site for Select2 control$")
    public void I_open_the_web_site_for_Select2_control() throws Throwable {
        sel2page.openSelectPage();
    }
}
