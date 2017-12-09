package lesson7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchPage extends BasePage{


    @FindBy(id = "search_query_top")
    WebElement searchField;

    @FindBy(xpath = "//*[@id=\"searchbox\"]/button")
    WebElement searchButton;



    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    SearchPage searchWithResult(String query) {
        searchField.clear();
        searchField.sendKeys(query);
        searchButton.click();
        return new SearchPage(webDriver);
    }

}
