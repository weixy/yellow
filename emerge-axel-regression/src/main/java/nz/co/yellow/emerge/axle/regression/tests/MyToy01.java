package nz.co.yellow.emerge.axle.regression.tests;

import cucumber.api.java.en.And;
import nz.co.yellow.autotest.utils.ObjectMap;
import nz.co.yellow.emerge.axle.regression.maps.Maps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by weixy on 29/06/14.
 */
public class MyToy01 {

    WebDriver driver = new FirefoxDriver();

    @And("^Open Yellow Page$")
    public void Open_Yellow_Page() throws Throwable {
        // Express the Regexp above with the code you wish you had

        driver.navigate().to("http://yellow.co.nz");
    }

    @And("^Input What$")
    public void Input_What() throws Throwable {
        // Express the Regexp above with the code you wish you had
        String workingDir=System.getProperty("user.dir");
        System.out.println(workingDir);
        //ObjectMap objectMap = new ObjectMap(workingDir + "/src/main/resources/nz.co.yellow.autotest.nz.co.yellow.emerge.axle.regression.beryllium/yol.startpage.map");
        ObjectMap objectMap = new ObjectMap(Maps.getPath("yol.startpage.map"));
        By by = objectMap.getLocator("yol.search.what.input");
        WebElement element = driver.findElement(by);
        element.sendKeys("pizza");
    }
}
