package lesson8;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    WebElement signInButton;
    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailInput;
    @FindBy(xpath = "//*[@id=\"passwd\"]")
    WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    WebElement submitSignInButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AccountPage logIn(String username, String password){
        LOG.info("Login");
        enterUsername(username);
        enterPassword(password);
        clickSignInBtn();
        return new AccountPage(webDriver);
    }

    public LoginPage enterUsername(String username){
        LOG.debug("Enter username " + username);
        emailInput.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password){
        LOG.debug("Enter password " + password);
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage clickSignInBtn(){
        LOG.debug("Click SignIn button");
        submitSignInButton.click();
        return this;
    }

}
