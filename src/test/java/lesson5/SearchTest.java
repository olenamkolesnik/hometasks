package lesson5;

import lesson6.AccountPage;
import lesson6.LoginPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SearchTest extends Utils {
    protected static  final String BASE_URL = "http://automationpractice.com/index.php";
    public MainPage mainPagePage = new MainPage();

    @BeforeClass
    public  static void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
    }

    @AfterClass
    public static void tearDown(){
        webDriver.quit();
        webDriver = null;
    }

    @Test
    public  void verifySearchResult(){
        enterText(mainPagePage.searchField,"Printed Summer Dress");
        click(mainPagePage.submitSearchButton);
        assertThat(and(textToBePresentInElement(mainPagePage.searchResultSet.get(0), "Printed Summer Dress"), numberOfElementsToBe(By.xpath("//*[@id=\"center_column\"]/ul/li"), 3)));
    }
}
