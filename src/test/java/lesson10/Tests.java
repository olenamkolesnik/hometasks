package lesson10;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.frameToBeAvailableAndSwitchToIt;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@RunWith(JUnit4.class)
public class Tests extends BaseTest {
    static final String BASE_URL = "http://automationpractice.com/index.php";

    @Test
    public void test_javaScriptUsage_iFrameSwitching() {
        open(BASE_URL);
        assertThat(titleContains("My Store"));
        WebElement facebookFrame =  $("//*[@id=\"facebook_block\"]/div/div/span/iframe");
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", facebookFrame);
        assertThat(frameToBeAvailableAndSwitchToIt(facebookFrame));
        Assert.assertTrue("Is link contains PrestaShop?", $("//*[@id=\"u_0_1\"]/div[2]/div[2]/div[1]/a").getText().contains("PrestaShop1111"));
    }
}
