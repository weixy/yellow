package nz.co.yellow.autotest.utils;

import org.openqa.selenium.By;

/**
 * Created by weixy on 29/06/14.
 */
public enum SeLocatorType {

        id {
            @Override
            public By getLocator(String value) {
                return By.id(value);
            }
        },
        name {
            @Override
            public By getLocator(String value) {
                return By.name(value);
            }
        },
        classname {
            @Override
            public By getLocator(String value) {
                return By.className(value);
            }
        },
        tagname {
            @Override
            public By getLocator(String value) {
                return By.tagName(value);
            }
        },
        linktext {
            @Override
            public By getLocator(String value) {
                return By.linkText(value);
            }
        },
        partiallinktext {
            @Override
            public By getLocator(String value) {
                return By.partialLinkText(value);
            }
        },
        cssselector {
            @Override
            public By getLocator(String value) {
                return By.cssSelector(value);
            }
        },
        xpath {
            @Override
            public By getLocator(String value) {
                return By.xpath(value);
            }
        };

        public abstract By getLocator(String value);
}
