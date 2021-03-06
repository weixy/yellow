package nz.co.yellow.beryllium.regression;

import cucumber.api.java.en.And;
import nz.co.yellow.autotest.spring.YellowAutoTestContext;
import nz.co.yellow.autotest.utils.*;
import nz.co.yellow.beryllium.maps.Maps;
import nz.co.yellow.beryllium.pages.BerylliumHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import javax.inject.Inject;

/**
 * Created by weixy on 29/06/14.
 */
@ContextConfiguration(classes = {YellowAutoTestContext.class})
@Component
public class YOLRegression01 {


    @Inject
    WebDriver driver;

    @Inject
    BerylliumHomePage berylliumHomePage;

    ObjectMap objectMap = new ObjectMap(Maps.getPath("yol.startpage.map"));

    @And("^Open Yellow Page$")
    public void Open_Yellow_Page() throws Throwable {
        driver.navigate().to("http://yellow.co.nz");
    }

    @And("^Input What$")
    public void Input_What() throws Throwable {
        //String workingDir=System.getProperty("user.dir");
        //System.out.println(workingDir);

        By by = objectMap.getLocator("yol.search.what.input");
        WebElement element = driver.findElement(by);
        element.sendKeys("pizza");
    }

    @And("^Click White$")
    public void Click_White() throws Throwable {
        berylliumHomePage.switchToWhite();
    }

    @And("^Input Who$")
    public void Input_Who() throws Throwable {

        System.out.println("Focus on White pages.");
        berylliumHomePage.checkWhite();
    }

    @And("^Back to Yellow$")
    public void Back_to_Yellow() throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println("Back to Yellow pages.");
        WebElement inputWhere = driver.findElement(objectMap.getLocator("yol.search.where.input"));
        inputWhere.sendKeys("New Zealand");
        //Thread.sleep(3000);
        driver.close();
    }
}
