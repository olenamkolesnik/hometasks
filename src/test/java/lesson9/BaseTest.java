package lesson8;

import org.junit.AfterClass;
        import org.junit.BeforeClass;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

public class BaseTest extends SimpleAPI{

     static WebDriver webDriver;

     @BeforeClass
     public static void setUp(){
         LoggingPreferences logs = new LoggingPreferences();
         logs.enable(LogType.BROWSER, Level.ALL);
         logs.enable(LogType.CLIENT, Level.SEVERE);
         logs.enable(LogType.DRIVER, Level.WARNING);
         logs.enable(LogType.PERFORMANCE, Level.INFO);
         logs.enable(LogType.SERVER, Level.ALL);

         DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
         desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        webDriver.quit();
        webDriver = null;
    }

     @Override
     public WebDriver getWebDriver() {
        return webDriver;
    }
}
