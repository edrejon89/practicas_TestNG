import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {
   protected WebDriver driver;
   protected WebDriverWait wait;
   protected String baseUrl;
    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions chromeoptions = new ChromeOptions();
            chromeoptions.addArguments("test-type")
                    .addArguments("no-sandbox")
                    .addArguments("--disable-infobars")
                    .addArguments("deny-permission-prompts");
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver(chromeoptions);
        }else if(browser.equalsIgnoreCase("firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addPreference("dom.webnotifications.enabled",true)
                    .addPreference("dom.disable_open_during_load", false)
                    .addPreference("dom.disable_beforeunload", true);
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        baseUrl = "http://qa.walook.com.mx:81/login";
        driver.get(baseUrl);
    }
    @AfterClass
    public void cleanUp(){
        if(driver!=null){
            driver.quit();
        }
    }
}
