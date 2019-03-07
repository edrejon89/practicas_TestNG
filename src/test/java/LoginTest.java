import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class LoginTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl;
    @BeforeClass
    public void setUp(){
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("test-type")
                .addArguments("no-sandbox")
                .addArguments("--disable-infobars")
                .addArguments("deny-permission-prompts");
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver(chromeoptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        baseUrl = "http://qa.walook.com.mx:81/login";
        driver.get(baseUrl);
    }
    @AfterClass
    public void cleanUp(){
        driver.quit();
    }

    @Test
    public void login(){
        driver.findElement(By.id("email")).sendKeys("erejon@walook.com.mx");
        driver.findElement(By.id("password")).sendKeys("Abcd1234");
        WebElement btn_login =  driver.findElement(By.cssSelector("input[type='submit']"));
        btn_login.click();
       if(!driver.findElement(By.tagName("h1")).isDisplayed()){
           SoftAssert sa = new SoftAssert();
           sa.fail("No existe el elemento");
       }

    }

}