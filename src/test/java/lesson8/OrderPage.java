package lesson8;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class OrderPage extends BasePage {


    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    WebElement proceedToCheckoutShippingButton;
    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
    WebElement proceedToCheckoutAddressButton;
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    WebElement proceedToCheckoutButton;
    @FindBy(id = "cgv")
    WebElement termsOfServiceCheckbox;
    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    WebElement payByBankWireButton;

    public OrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    void proceedToCheckout(){
        assertThat(elementToBeClickable(proceedToCheckoutButton));
        LOG.info("Proceed to checkout click");
        proceedToCheckoutButton.click();
    }

    void proceedToCheckoutAddress(){
        LOG.info("Proceed to checkout address page click");
        proceedToCheckoutAddressButton.click();
    }

    BankWirePaymentPage proceedToCheckoutShipping(){
        LOG.info("Proceed to checkout shipping page click");
        proceedToCheckoutShippingButton.click();
        return new BankWirePaymentPage(webDriver);
    }

     void setTermsOfService(){
        LOG.info("Set terms of service checkbox");
        termsOfServiceCheckbox.click();
    }

    BankWirePaymentPage payByBankWire(){
        LOG.info("Pay by bank wire click");
        payByBankWireButton.click();
        return new BankWirePaymentPage(webDriver);
    }

}
