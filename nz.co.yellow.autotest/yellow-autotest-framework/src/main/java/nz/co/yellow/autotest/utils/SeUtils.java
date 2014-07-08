package nz.co.yellow.autotest.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
        System.out.println("WaitForLoading started ...");
        WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
        ExpectedCondition<Boolean> expectedCondition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete");
            }
        };
        driverWait.until(expectedCondition);
    }
}
