package nz.co.yellow.autotest.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

/**
 * Created by jim.wei@yellow.co.nz on 29/06/14.
 */
@Component
public class SeUtils {
    public static boolean isLoaded(WebDriver driver) {

        return false;
    }

    public static void waitForLoading(WebDriver driver, Long timeOutInSeconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
        ExpectedCondition<Boolean> expectedCondition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                System.out.println("--- wait for loading ---");
                return ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete");
            }
        };
        driverWait.until(expectedCondition);
    }

    public static void initBrowsers() {
        //TODO Clean cookies
    }

    public static void scrollElement(WebElement element) {
        Coordinates coordinate = ((Locatable)element).getCoordinates();
        coordinate.onPage();
        coordinate.inViewPort();
    }
}
