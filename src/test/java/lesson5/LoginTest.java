package lesson5;

import lesson5.AccountPage;
import lesson5.LoginPage;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends Utils {
    protected static  final String BASE_URL = "http://automationpractice.com/index.php";
    public AccountPage accountPage = new AccountPage();
    public LoginPage loginPage = new LoginPage();

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

    @After
    public  void afterTest(){
        click(accountPage.accountButton);
    }

    @Test
    public  void a_verifyLogin(){
        loginPage.logIn("olenamkolesnik@gmail.com", "olenamkolesnik");
        assertThat(titleContains("My account - My Store"));
    }

    @Test
    public  void b_verifyOrderHistory(){
        click(accountPage.orderHisoryAndDetailsButton);
        assertThat(titleContains("Order history - My Store"));
    }

    @Test
    public  void c_verifyOrderSlip(){
        click(accountPage.myCreditSlipsButton);
        assertThat(titleContains("Order slip - My Store"));
    }

    @Test
    public  void d_verifyAddresses(){
        click(accountPage.myAddressesButton);
        assertThat(titleContains("Addresses - My Store"));
    }

    @Test
    public  void e_verifyIdentity(){
        click(accountPage.myPersonalInformationButton);
        assertThat(titleContains("Identity - My Store"));
    }

    @Test
    public  void f_verifyWishlists(){
        click(accountPage.myWishlistsButton);
        assertThat(titleContains("My Store"));
        assertThat(textToBePresentInElement(accountPage.myWishlistLabel, "WISHLISTS"));
    }
}
