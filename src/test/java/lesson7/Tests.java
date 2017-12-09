package lesson7;

import org.junit.FixMethodOrder;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.junit.runners.JUnit4;
 import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import static lesson7.CustomConditions.listNthElementHasText;
import static lesson7.CustomConditions.pageIsLoaded;
import static lesson7.CustomConditions.stalenessOfElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

 @RunWith(JUnit4.class)
 @FixMethodOrder(MethodSorters.NAME_ASCENDING)
 public class Tests extends BaseTest{
     MainPage mainPage = new MainPage(webDriver);


     @Test
     public void test_customCondition_listNthElementHasText(){
         mainPage.visit();
         MainPage mainPage = new MainPage(webDriver);
         mainPage.searchWithResult("Dress");
         assertThat(listNthElementHasText(By.xpath("//*[@id=\"center_column\"]/ul/li"), 1, "Dress"));
     }


     @Test
     public void test_customCondition_pageIsLoaded(){
         mainPage.visit();
         MainPage mainPage = new MainPage(webDriver);
         assertThat(pageIsLoaded(MainPage.BASE_URL, "My Store"));
         mainPage.enterQuery("Dress");
         assertThat(textToBePresentInElement(mainPage.advice, "Dress"));
     }

     @Test
     public void test_customCondition_stalenessOfElement(){
         mainPage.visit();
         MainPage mainPage = new MainPage(webDriver);
         SearchPage searchPage = mainPage.searchWithResult("Dress");
         assertThat(presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/ul/li[2]")));
         searchPage.searchWithResult("Shirt");
         assertThat(stalenessOfElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]")));
     }
 }
