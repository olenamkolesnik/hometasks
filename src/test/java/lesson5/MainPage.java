package lesson5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MainPage extends Utils{
    @FindBy(id = "search_query_top")
    WebElement searchField;
    @FindBy(xpath = "//*[@id=\"searchbox\"]/button")
    WebElement submitSearchButton;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/*")
    List<WebElement> searchResultSet;

    protected static  final String BASE_URL = "http://automationpractice.com/index.php";

    MainPage() {
        PageFactory.initElements(webDriver, this);
    }



}
