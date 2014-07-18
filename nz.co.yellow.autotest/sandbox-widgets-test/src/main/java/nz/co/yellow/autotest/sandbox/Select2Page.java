package nz.co.yellow.autotest.sandbox;

import nz.co.yellow.autotest.utils.Select2Basic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by weixy on 18/07/2014.
 */
@Component
public class Select2Page {

    @Inject
    WebDriver driver;

    public void openSelectPage() throws Throwable {
        driver.get("http://ivaynberg.github.io/select2/");
        driver.switchTo();

        Select2Basic select = new Select2Basic(driver.findElement(By.id("s2id_autogen1")));
        select.selectOption("Hawaii");

        Select2MultiValue selectMultiValue = new Select2MultiValue(driver.findElement(By.id("s2id_autogen7")));
        selectMultiValue.selectOption("California");
        selectMultiValue.selectOption("Washington");

        selectMultiValue.selectOptions(new String[] {"New Mexico", "Texas"});

        Thread.sleep(5000);

        selectMultiValue.removeChoice("Washington");

        Thread.sleep(10000);
    }

}
