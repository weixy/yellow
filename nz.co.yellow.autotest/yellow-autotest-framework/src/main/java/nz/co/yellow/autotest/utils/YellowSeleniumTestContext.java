package nz.co.yellow.autotest.utils;

import com.sun.javafx.runtime.SystemProperties;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by weixy on 5/07/14.
 */
@Configuration
@Import(YellowAutoTestContext.class)
public class YellowSeleniumTestContext {
    @Bean(destroyMethod = "quit")
    public WebDriver loadWebDriver(@Value("${webdriver:chrome}")String webDriver) {
        return WebDriverType.valueOf(webDriver).getWebDriver();
    }
}
