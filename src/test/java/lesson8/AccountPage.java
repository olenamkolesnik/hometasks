package lesson8;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")
    WebElement orderHistoryAndDetailsButton;

    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public OrderHistoryPage openOrderHistory(){
        LOG.info("Open order history");
        orderHistoryAndDetailsButton.click();
        return new OrderHistoryPage(webDriver);
    }
}

