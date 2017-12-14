package lesson8;


import org.junit.FixMethodOrder;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.junit.runners.JUnit4;
 import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests extends BaseTest{
    MainPage mainPage = new MainPage(webDriver);
    BasePage basePage = new BasePage(webDriver);
    String desiredItem = "Faded Short Sleeve T-shirts";


    @Test
    public void test_customCondition_listNthElementHasText() {
        mainPage.visit();
        LoginPage loginPage = mainPage.openLoginPage();
        loginPage.logIn("olenamkolesnik@gmail.com", "olenamkolesnik");
        SearchPage searchPage = basePage.searchWithResult(desiredItem);
        LayerCartPage layerCartPage = searchPage.addItemToCart();
        OrderPage orderPage = layerCartPage.proceedToCheckout();
        orderPage.proceedToCheckout();
        orderPage.proceedToCheckoutAddress();
        orderPage.setTermsOfService();
        orderPage.proceedToCheckoutShipping();
        BankWirePaymentPage bankWirePaymentPage = orderPage.payByBankWire();
        OrderConfirmationPage orderConfirmationPage = bankWirePaymentPage.confirmOrder();
        String orderReference = orderConfirmationPage.getOrderReference();
        AccountPage accountPage = orderConfirmationPage.renameAccountPage();
        OrderHistoryPage orderHistoryPage = accountPage.openOrderHistory();
        orderHistoryPage.openOrder(orderReference);
        assertTrue(orderHistoryPage.getProductFromOrder().contains(desiredItem));

    }
}
