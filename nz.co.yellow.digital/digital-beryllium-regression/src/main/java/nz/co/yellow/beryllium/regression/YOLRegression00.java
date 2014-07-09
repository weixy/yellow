package nz.co.yellow.beryllium.regression;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import nz.co.yellow.autotest.spring.YellowAutoTestContext;
import nz.co.yellow.autotest.utils.WaitForLoading;
import nz.co.yellow.sandbox.TryAgain;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Y981821 on 9/07/2014.
 */
@ContextConfiguration(classes = {YellowAutoTestContext.class})
@Component
public class YOLRegression00 {
    @Given("^Start testing$")
    public void Start_testing() throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println("Scenario 00 started ... ...");
    }

    @WaitForLoading
    @And("^Start step (\\d+)$")
    public void Start_step(int arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println("Step " + arg1 + " started ... ...");
    }

    @Then("^Open product page with urls:$")
    public void Open_product_page_with_urls(DataTable dataTable) throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println(dataTable.asMaps().toString());
        System.out.println(dataTable.toString());
    }

    @Then("^Open product page \"([^\"]*)\" with urls: \"([^\"]*)\"$")
    public void Open_product_page_with_urls(String arg1, String arg2) throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println("Open page: " + arg1 + "with url:" + arg2);
    }
}
