package nz.co.yellow.autotest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Created by weixy on 5/07/14.
 */
public enum WebDriverType {

    firefox {
        @Override
        public WebDriver getWebDriver() {
            return new FirefoxDriver();
        }
    },
    chrome {
        @Override
        public WebDriver getWebDriver() {
            return new ChromeDriver();
        }
    },
    ie {
        @Override
        public WebDriver getWebDriver() {
            return new InternetExplorerDriver();
        }
    },
    safari {
        @Override
        public WebDriver getWebDriver() {
            return new SafariDriver();
        }
    },
    htmlunit {
        @Override
        public WebDriver getWebDriver() {
            return new HtmlUnitDriver();
        }
    },
    phantomjs {
        @Override
        public WebDriver getWebDriver() {
            return new PhantomJSDriver();
        }
    };

    public abstract WebDriver getWebDriver();

}
