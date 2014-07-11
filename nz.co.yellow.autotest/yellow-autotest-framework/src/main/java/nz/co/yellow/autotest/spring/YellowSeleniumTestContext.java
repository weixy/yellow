package nz.co.yellow.autotest.spring;

import nz.co.yellow.autotest.utils.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by weixy on 5/07/14.
 */

@Configuration
public class YellowSeleniumTestContext {
    @Bean(destroyMethod = "quit")
    public WebDriver loadWebDriver(@Value("${web.driver:chrome}")String webDriver) {
        return WebDriverType.valueOf(webDriver).getWebDriver();
    }
}
