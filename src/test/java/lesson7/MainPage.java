package lesson7;

import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    static final String BASE_URL = "http://automationpractice.com/index.php";

    @FindBy(id = "search_query_top")
     WebElement searchField;
     @FindBy(xpath = "//*[@id='index']/div[2]/ul/li[1]")
     WebElement advice;

    @FindBy(xpath = "//*[@id=\"searchbox\"]/button")
    WebElement searchButton;



    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    void visit(){
        open(BASE_URL);
    }

    void enterQuery(String query) {
        searchField.clear();
        searchField.sendKeys(query);
    }

    SearchPage searchWithResult(String query) {
        searchField.clear();
        searchField.sendKeys(query);
        searchButton.click();
        return new SearchPage(webDriver);
    }

 }
