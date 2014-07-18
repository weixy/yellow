package nz.co.yellow.autotest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;

import java.util.Iterator;
import java.util.List;

/**
 * Created by weixy on 18/07/2014.
 */
public class Select2Basic {

    protected WebElement inputBox;
    protected WebElement anchor;
    protected WebElement anchor_arrow;
    protected WebElement anchor_chosen;

    protected WebElement drop;
    protected WebElement drop_search_input;
    protected List<WebElement> drop_option_list;

    boolean isExpanded;

    public Select2Basic() {

    }

    public Select2Basic(WebElement input) {
        SeUtils.scrollElement(input);
        String id = input.getAttribute("id");
        inputBox = input;
        anchor = input.findElement(By.xpath("//input[@id='" + id +"']/parent::div/child::a"));
        anchor_chosen = anchor.findElement(By.xpath(".//span[contains(@class, 'select2-chosen')]"));
        anchor_arrow = anchor.findElement(By.xpath(".//span[contains(@class, 'select2-arrow')]"));

        drop = null;
        drop_search_input = null;
        drop_option_list = null;
    }

    public void expandOptions() {
        anchor_arrow.click();
        drop = inputBox.findElement(By.xpath(".//ancestor::body/div[@id='select2-drop']"));
        System.out.println(this.getClass().getSimpleName() +
                ": found Select2 drop" + drop.getTagName() +
                " : " + drop.getAttribute("id"));

        drop_search_input = drop.findElement(By.xpath(".//input[contains(@class,'select2-input')]"));
        System.out.println(this.getClass().getSimpleName() +
                ": found Select2 drop" + drop_search_input.getTagName() +
                " : " + drop_search_input.getAttribute("id"));

        WebElement drop_options = drop.findElement(By.xpath(".//ul[contains(@class,'select2-results')]"));
        System.out.println(this.getClass().getSimpleName() +
                ": found Select2 drop" + drop_options.getTagName() +
                " : " + drop_options.getAttribute("id"));

        drop_option_list = getAvailableOptions(drop_options);

        List<WebElement> drop_option_all = getAllOptions(drop_options);

        /*for (Iterator<WebElement> i = drop_option_list.iterator(); i.hasNext();) {
            System.out.println(i.next().getText());
        }
        System.out.println("==================");
        for (Iterator<WebElement> i = drop_option_all.iterator(); i.hasNext();) {
            System.out.println(i.next().findElement(By.xpath("./div")).getText());
        }*/
    }

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

    protected List<WebElement> getAllOptions(WebElement dropOptions) {
        return dropOptions.findElements(By.xpath("./descendant::li[contains(@class, 'select2-result')]"));
    }

    protected List<WebElement> getAvailableOptions(WebElement dropOptions) {
        return dropOptions.findElements(By.xpath("./descendant::li[contains(@class, 'select2-result-selectable')]"));
    }

}
