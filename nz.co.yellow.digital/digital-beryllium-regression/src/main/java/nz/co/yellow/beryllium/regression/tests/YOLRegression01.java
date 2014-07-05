package nz.co.yellow.beryllium.regression.tests;

import cucumber.api.java.en.And;
import nz.co.yellow.autotest.utils.ObjectMap;
import nz.co.yellow.autotest.utils.YellowAutoTestContext;
import nz.co.yellow.autotest.utils.YellowSeleniumTestContext;
import nz.co.yellow.beryllium.regression.maps.Maps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import javax.inject.Inject;

/**
 * Created by weixy on 29/06/14.
 */
@ContextConfiguration(classes = {YellowSeleniumTestContext.class})
@Component
public class YOLRegression01 {


    //WebDriver driver = new FirefoxDriver();
    @Inject
    WebDriver driver;// = new ChromeDriver();

    ObjectMap objectMap = new ObjectMap(Maps.getPath("yol.startpage.map"));

    @And("^Open Yellow Page$")
    public void Open_Yellow_Page() throws Throwable {
        // Express the Regexp above with the code you wish you had
        //if (driver instanceof ChromeDriver) {
        //System.setProperty("webdriver.chrome.driver", "/Users/weixy/Documents/Dev/libs/selenium/chromedriver");
        //driver = new ChromeDriver();
        //}
        driver.navigate().to("http://yellow.co.nz");
    }

    @And("^Input What$")
    public void Input_What() throws Throwable {
        // Express the Regexp above with the code you wish you had
        String workingDir=System.getProperty("user.dir");
        System.out.println(workingDir);

        By by = objectMap.getLocator("yol.search.what.input");
        WebElement element = driver.findElement(by);
        element.sendKeys("pizza");
    }

    @And("^Click White$")
    public void Click_White() throws Throwable {
        // Express the Regexp above with the code you wish you had
        By by = objectMap.getLocator("yol.nav.white");
        WebElement element = driver.findElement(by);
        element.click();

        Thread.sleep(3000);
        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTabs = new ArrayList<String>(driver.getWindowHandles());
        newTabs.remove(oldTab);
        driver.switchTo().window(newTabs.get(0));
        System.out.println("Focus on White page.");
        WebElement inputWhat = driver.findElement(By.id("searchWhatField"));
        inputWhat.sendKeys("Jim");
        Thread.sleep(5000);
        driver.close();
        driver.switchTo().window(oldTab);
        System.out.println("Back to Yellow page.");
        WebElement inputWhere = driver.findElement(objectMap.getLocator("yol.search.where.input"));
        inputWhere.sendKeys("New Zealand");
        Thread.sleep(3000);
        driver.close();

    }
}
