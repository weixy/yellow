package nz.co.yellow.beryllium.regression;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import nz.co.yellow.autotest.spring.YellowAutoTestContext;
import nz.co.yellow.autotest.utils.CucmTable;
import nz.co.yellow.beryllium.pages.BerylliumHomePage;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import javax.inject.Inject;

/**
 * Created by Y981821 on 9/07/2014.
 */
@ContextConfiguration(classes = {YellowAutoTestContext.class})
@Component
public class YOLRegression00 {

    @Inject
    BerylliumHomePage berylliumHomePage;

    @Given("^Start testing$")
    public void Start_testing() throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println("Scenario 00 started ... ...");
    }

    @And("^Start step (\\d+)$")
    public void Start_step(int arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println("Step " + arg1 + " started ... ...");
        berylliumHomePage.func11();
    }

    @Then("^Open product page with urls:$")
    public void Open_product_page_with_urls(DataTable dataTable) throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println(dataTable.asMaps().toString());
        System.out.println(dataTable.toString());
        System.out.println(dataTable.topCells().toString());
        System.out.println("--------------------");
        System.out.println(new CucmTable(dataTable).getCell("products", 2));
        berylliumHomePage.func22();
    }
}
