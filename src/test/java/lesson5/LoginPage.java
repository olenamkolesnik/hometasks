package lesson5;

import lesson5.AccountPage;
import lesson5.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utils {
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    WebElement signInButton;
    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailInput;
    @FindBy(xpath = "//*[@id=\"passwd\"]")
    WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    WebElement submitSignInButton;

    LoginPage() {
        PageFactory.initElements(webDriver, this);
    }

    public AccountPage logIn(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickSignInBtn();
        return new AccountPage();
    }

    public LoginPage enterUsername(String username){
        click(signInButton);
        enterText(emailInput, username);
        return this;
    }

    public LoginPage enterPassword(String password){
        enterText(passwordInput, password);
        return this;
    }

    public LoginPage clickSignInBtn(){
        click(submitSignInButton);
        return this;
    }

}
