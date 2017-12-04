package lesson5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Utils {
    public static WebDriver webDriver;

    public void assertThat(ExpectedCondition<?> condition){
        (new WebDriverWait(webDriver, 5)).until(condition);
    }

    void enterText(WebElement webElement, String text){
        assertThat(visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    void click(WebElement webElement) {
        assertThat(elementToBeClickable(webElement));
        webElement.click();
    }
}
