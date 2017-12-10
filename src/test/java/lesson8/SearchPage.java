package lesson8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class SearchPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")
    WebElement itemTitle;
    @FindBy(id = "add_to_cart")
    WebElement addToCartButton;

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    LayerCartPage addItemToCart(){
        LOG.info("Add first item to cart");
        itemTitle.click();
        addToCartButton.click();
        return new LayerCartPage(webDriver);
    }
}
