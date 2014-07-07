package nz.co.yellow.autotest.utils;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by jim.wei@yellow.co.nz on 29/06/14.
 */

@Component
@Aspect
public class WaitForLoadingAspect {
    @Inject
    private WebDriver webDriver;

    @Before("@annotation(waitForLoading)")
    public void waitFor(WaitForLoading waitForLoading) {
        System.out.println("Start to wait for page loaded ...");
        Page.waitForLoading(webDriver, waitForLoading.timeOutInSeconds());
    }
}