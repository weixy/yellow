package nz.co.yellow.emerge.axle.regression.tests;

import cucumber.api.java.en.Then;

/**
 * Created by weixy on 30/06/14.
 */
public class MyHelloworld {
    @cucumber.api.java.en.Given("^I'm here$")
    public void I_m_here() throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println("===========");
    }

    @Then("^Say hello words \"([^\"]*)\"$")
    public void Say_hello_words(String words) throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println(words);
    }
}
