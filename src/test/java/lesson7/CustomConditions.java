package lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.ui.ExpectedCondition;

import javax.annotation.Nullable;
 import java.util.List;

         public class CustomConditions {

             public static ExpectedCondition<List<WebElement>> listSizeIs(By locator, int minSize){
                return new ExpectedCondition<List<WebElement>>() {
             @Nullable
             @Override
             public List<WebElement> apply(@Nullable WebDriver webDriver) {
                                List<WebElement> list = webDriver.findElements(locator);
                                return list.size() == minSize ? list : null;
                            }
                };
            }

             public static ExpectedCondition<List<WebElement>> listNthElementHasText(By locator, int index, String text){
                 return new ExpectedCondition<List<WebElement>>(){
                     @Nullable
                     @Override
                     public List<WebElement> apply(@Nullable WebDriver webDriver){
                         List<WebElement> list = webDriver.findElements(locator);
                         try{
                             return (list.get(index).getText().contains(text)) ? list : null;
                         }catch (IndexOutOfBoundsException e){
                             System.out.println("Index " + index + " out of bounds.");
                             return null;
                         }
                     }
                 };

             }

            public static ExpectedCondition<Boolean> pageIsLoaded(String url, String title){
                return new ExpectedCondition<Boolean>(){
                    @Nullable
                    @Override
                    public Boolean apply(@Nullable WebDriver webDriver){
                        Boolean isTitleCorrect = webDriver.getTitle().contains(title);
                        Boolean isUrlCorrect = webDriver.getCurrentUrl().contains(url);
                        return isUrlCorrect && isTitleCorrect;
                    }
                };

            }

             public static ExpectedCondition<Boolean> stalenessOfElement(By locator){
                 return new ExpectedCondition<Boolean>(){
                     @Nullable
                     @Override
                     public Boolean apply(@Nullable WebDriver webDriver){
                         try{
                            webDriver.findElement(locator);
                            return false;
                         }
                         catch (NoSuchElementException e){
                             return true;
                         }
                     }
                 };

             }




 }
