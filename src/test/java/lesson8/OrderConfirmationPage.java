package lesson8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
    WebElement goToAccountPageButton;
    @FindBy(id = "center_column" )
    WebElement orderConfirmationText;


    public OrderConfirmationPage(WebDriver webDriver) {
        super(webDriver);
    }

    String getOrderReference() {
        LOG.info("Get order reference");
        return orderConfirmationText.getText().substring(296, 305);
    }

    AccountPage renameAccountPage(){
        LOG.info("Go to account page");
        goToAccountPageButton.click();
        return new AccountPage(webDriver);
    }

}

