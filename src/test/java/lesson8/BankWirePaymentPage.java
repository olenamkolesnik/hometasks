package lesson8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class BankWirePaymentPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    WebElement confirmOrderButton;


    public BankWirePaymentPage(WebDriver webDriver) {
        super(webDriver);
    }

    OrderConfirmationPage confirmOrder(){
        assertThat(elementToBeClickable(confirmOrderButton));
        LOG.info("Confirm order");
        confirmOrderButton.click();
        return new OrderConfirmationPage(webDriver);
    }

}
