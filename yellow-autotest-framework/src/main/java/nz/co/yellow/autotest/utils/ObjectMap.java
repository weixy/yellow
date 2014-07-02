package nz.co.yellow.autotest.utils;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by weixy on 29/06/14.
 */
public class ObjectMap {
    Properties properties;

    public ObjectMap(String mapFile) {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream(mapFile);
            properties.load(file);
            file.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public By getLocator(String elName) {
        String locator = properties.getProperty(elName);
        int index = locator.indexOf(":");
        String locatorType = locator.substring(0, index);
        String locatorValue = locator.substring(index + 1);

        By by = SeLocatorType.valueOf(locatorType).getLocator(locatorValue);
        return by;
    }

}
