import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class RegistroUsuario extends BaseTest{
    Locale locale = new Locale("es","us");
    Faker faker = new Faker(locale);



    @Test(priority = 1, dataProvider = "register",dataProviderClass = DataGenerator.class)
    public void registroUsuario(String user,String pass){
        WebElement btnRegister = driver.findElement(By.xpath("//a[contains(@href,'http://qa.walook.com.mx:81/usuario')]"));
        btnRegister.click();
        driver.findElement(By.id("nombres")).sendKeys("Alberto");
        driver.findElement(By.id("apellidop")).sendKeys("dominguez");
        List <WebElement> gender = new ArrayList(driver.findElements(By.name("genero")));
        gender.get(1);
        driver.findElement(By.id("celular")).sendKeys("9999999999");
        driver.findElement(By.id("puestoempresarial")).sendKeys("Narcotraficante");
        driver.findElement(By.id("corporativo")).sendKeys("Siempre vivo");
        driver.findElement(By.id("telempresa")).sendKeys("9991765847");
        driver.findElement(By.tagName("option"));
        List <WebElement> pais = new ArrayList<>(driver.findElements(By.className("optionpais")));
        pais.get(17).click();
        driver.findElement(By.id("estadospaises")).sendKeys(faker.address().city());
        driver.findElement(By.id("ciudad")).sendKeys(faker.address().city());
        driver.findElement(By.id("correo")).sendKeys(faker.internet().emailAddress());
        String password = faker.internet().password();
        driver.findElement(By.id("correo")).sendKeys(password);
        System.out.println(password);
        WebElement btnRegistro = driver.findElement(By.id("btnRegistrarse"));
        btnRegistro.click();
    }

    @Test(priority = 0)
    public void registroUsuarioCancelar(){
        WebElement btnRegister = driver.findElement(By.xpath("//a[contains(@href,'http://qa.walook.com.mx:81/usuario')]"));
        btnRegister.click();
        driver.findElement(By.id("nombres")).sendKeys("Alberto");
        driver.findElement(By.id("apellidop")).sendKeys("dominguez");
        List <WebElement> gender = new ArrayList(driver.findElements(By.name("genero")));
        gender.get(1).click();
        driver.findElement(By.id("celular")).sendKeys("9999999999");
        driver.findElement(By.id("puestoempresarial")).sendKeys("Narcotraficante");
        driver.findElement(By.id("corporativo")).sendKeys("Siempre vivo");
        driver.findElement(By.id("telempresa")).sendKeys("9991765847");
        driver.findElement(By.tagName("option"));
        List <WebElement> pais = new ArrayList<>(driver.findElements(By.className("optionpais")));
        pais.get(17).click();
        driver.findElement(By.id("estadospaises")).sendKeys(faker.address().city());
        driver.findElement(By.id("ciudad")).sendKeys(faker.address().city());
        driver.findElement(By.id("correo")).sendKeys(faker.internet().emailAddress());
        String password = faker.internet().password();
        driver.findElement(By.id("correo")).sendKeys(password);
        System.out.println(password);
        WebElement btnRegistro = driver.findElement(By.xpath("//a[contains(@href,'http://qa.walook.com.mx:81')]"));
        btnRegistro.click();
    }

}