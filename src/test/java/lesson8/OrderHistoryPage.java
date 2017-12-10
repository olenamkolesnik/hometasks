package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class OrderHistoryPage extends BasePage {




    public OrderHistoryPage(WebDriver webDriver) {
        super(webDriver);
    }


    void openOrder(String text){
        LOG.info("Open order details");
        webDriver.findElement(By.linkText(text)).click();
    }

    String getProductFromOrder(){
        LOG.info("Get product from order");
        assertThat(presenceOfElementLocated(By.xpath("//*[@id=\"order-detail-content\"]/table/tbody")));
        WebElement table = (webDriver.findElement(By.xpath("//*[@id=\"order-detail-content\"]/table/tbody")));
        return getCell(table, 1,2).getText();
}
    private WebElement getCell(WebElement webTable, int rowIdx, int colIdx){
        try {
            List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
            WebElement row = tableRows.get(rowIdx - 1);
            List<WebElement> tableCols = row.findElements(By.tagName("td"));
            WebElement cell = tableCols.get(colIdx - 1);
            return cell;

        }
        catch (NoSuchElementException e){
            throw new NoSuchElementException("Failed to get cell editor");
        }
    }
}