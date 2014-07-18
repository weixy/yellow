package nz.co.yellow.autotest.sandbox;

import nz.co.yellow.autotest.utils.SeUtils;
import nz.co.yellow.autotest.utils.Select2Basic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

/**
 * Created by weixy on 18/07/14.
 */
public class Select2MultiValue extends Select2Basic {

    protected WebElement choices;

    public Select2MultiValue(WebElement input) {
        SeUtils.scrollElement(input);
        String id = input.getAttribute("id");
        inputBox = input;
        choices = input.findElement(By.xpath(".//ancestor::ul[contains(@class, 'select2-choices')]"));

        drop = null;
        drop_search_input = null;
        drop_option_list = null;
    }

    @Override
    public void expandOptions() {
        inputBox.click();

        drop = inputBox.findElement(By.xpath(".//ancestor::body/div[@id='select2-drop']"));
        System.out.println(this.getClass().getSimpleName() +
                ": found Select2 drop" + drop.getTagName() +
                " : " + drop.getAttribute("id"));


        WebElement drop_options = drop.findElement(By.xpath(".//ul[contains(@class,'select2-results')]"));
        System.out.println(this.getClass().getSimpleName() +
                ": found Select2 drop" + drop_options.getTagName() +
                " : " + drop_options.getAttribute("id"));

        drop_option_list = getAvailableOptions(drop_options);
    }

    @Override
    public void selectOption(String optionText) {
        expandOptions();
        for (Iterator<WebElement> i = drop_option_list.iterator(); i.hasNext();) {
            WebElement option = i.next();
            WebElement span = option.findElement(By.xpath(".//span"));
            if (option.getText().equalsIgnoreCase(optionText)) {
                option.click();
                break;
            }
        }
    }

    public void selectOptions(String[] options) {
        for (String opt : options) {
            selectOption(opt);
        }
    }

    public List<WebElement> getChoices() {
        return choices.findElements(By.xpath("./li[contains(@class, 'select2-search-choice')]"));
    }

    public void removeChoice(String choice) {
        List<WebElement> choices = getChoices();
        for (Iterator<WebElement> i = choices.iterator(); i.hasNext();) {
            WebElement ch = i.next();
            String txt = ch.findElement(By.xpath(".//div")).getText();
            if (txt.equalsIgnoreCase(choice)) {
                WebElement delIcon = ch.findElement(By.xpath(".//a"));
                delIcon.click();
                break;
            }
        }
    }

}
