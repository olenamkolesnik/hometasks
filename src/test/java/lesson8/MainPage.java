package lesson8;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    static final String BASE_URL = "http://automationpractice.com/index.php";

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    WebElement signInButton;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    void visit(){
        LOG.info("Open main page");
        open(BASE_URL);
    }

    LoginPage openLoginPage(){
        LOG.info("Open Login page");
        signInButton.click();
        return new LoginPage(webDriver);
    }

 }
