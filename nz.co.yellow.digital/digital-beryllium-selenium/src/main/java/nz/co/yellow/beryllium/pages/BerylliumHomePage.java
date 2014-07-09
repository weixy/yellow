package nz.co.yellow.beryllium.pages;

import nz.co.yellow.autotest.utils.ObjectMap;
import nz.co.yellow.autotest.utils.WaitForLoading;
import nz.co.yellow.beryllium.maps.Maps;
import nz.co.yellow.sandbox.TryAgain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by weixy on 9/07/14.
 */
@Component
public class BerylliumHomePage {

    @Inject
    WebDriver driver;

    ObjectMap objectMap = new ObjectMap(Maps.getPath("yol.startpage.map"));

    private String currentWindow = null;
    private String previousWindow = null;

    @WaitForLoading
    public void func11() {
        System.out.println("Axle function 11 -------");
    }

    @TryAgain
    public void func22() {
        System.out.println("Axle function 22 -------");
    }

    public void switchToWhite() throws Throwable{
        By by = objectMap.getLocator("yol.nav.white");
        WebElement element = driver.findElement(by);
        element.click();
        Thread.sleep(3000);
        previousWindow = driver.getWindowHandle();
        ArrayList<String> newTabs = new ArrayList<String>(driver.getWindowHandles());
        newTabs.remove(previousWindow);
        currentWindow = newTabs.get(0);
        driver.switchTo().window(currentWindow);
    }

    @WaitForLoading
    public void checkWhite() {
        System.out.println("Focus on White pages.");
        WebElement inputWhat = driver.findElement(By.id("searchWhatField"));
        inputWhat.sendKeys("Jim");
        driver.close();
        currentWindow = previousWindow;
        previousWindow = null;
        driver.switchTo().window(currentWindow);
    }

}
