package lesson5;

import lesson5.LoginPage;
import lesson5.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends Utils {
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")
    WebElement orderHisoryAndDetailsButton;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[2]/a/span")
    WebElement myCreditSlipsButton;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span")
    WebElement myAddressesButton;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span")
    WebElement myPersonalInformationButton;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span")
    WebElement myWishlistsButton;
    @FindBy(xpath = "//*[@id=\"mywishlist\"]/h1")
    WebElement myWishlistLabel;
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
    WebElement accountButton;
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    WebElement signOutButton;


    AccountPage() {
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage signOut(){
        click(signOutButton);
        return new LoginPage();
    }
}
