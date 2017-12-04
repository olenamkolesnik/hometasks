package lesson6;

import lesson6.Utils;
import lesson6.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends Utils {
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
