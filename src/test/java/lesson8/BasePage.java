package lesson8;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends SimpleAPI{

     protected WebDriver webDriver;

    @FindBy(id = "search_query_top")
    WebElement searchField;

    @FindBy(xpath = "//*[@id=\"searchbox\"]/button")
    WebElement searchButton;

     @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }

    static final Logger LOG = LogManager.getLogger(MainPage.class);

     public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    SearchPage searchWithResult(String query) {
        LOG.info("Search " + query);
        LOG.debug("Clear search field");
        searchField.clear();
        LOG.debug("Type " + query);
        searchField.sendKeys(query);
        LOG.debug("Click search button");
        searchButton.click();
        return new SearchPage(webDriver);
    }


}
