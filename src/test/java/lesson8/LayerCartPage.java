package lesson8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LayerCartPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    WebElement proceedToCheckotButton;

    public LayerCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    OrderPage proceedToCheckout(){
        LOG.info("Proceed to checkout click");
        assertThat(elementToBeClickable(proceedToCheckotButton));
        proceedToCheckotButton.click();
        return new OrderPage(webDriver);
    }

}
