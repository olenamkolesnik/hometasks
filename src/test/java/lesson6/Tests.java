package lesson6;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests extends LoginPage{

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

    @Test
    public  void a_verifyLogin(){
        accountPage = logIn("olenamkolesnik@gmail.com", "olenamkolesnik");
        assertThat(titleContains("My account - My Store"));
    }

    @Ignore
    @Test
    public  void b_verifyLoginChaining(){
        enterUsername("olenamkolesnik@gmail.com")
        .enterPassword("olenamkolesnik")
        .clickSignInBtn();
        assertThat(titleContains("My account - My Store"));
    }

    @Test
    public  void c_verifyLogout(){
        loginPage = accountPage.signOut();
        assertThat(titleContains("Login - My Store"));
    }
}
