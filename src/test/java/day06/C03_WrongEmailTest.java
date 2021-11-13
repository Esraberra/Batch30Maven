package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_WrongEmailTest {
    //1.Bir Class olusturalim YanlisEmailTesti
    //2.http://automationpractice.com/index.php sayfasina gidelim
    //3.Sign in butonuna basalim
    //4.Email kutusuna @isareti olmayan bir mail yazip enter’a
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void gecersizMailTesti() throws InterruptedException {
        driver.findElement(By.partialLinkText("Sign in")).click();
        Thread.sleep(3000);
        WebElement emailGiriskutusu=driver.findElement(By.id("email_create"));
        emailGiriskutusu.sendKeys("MerhabaTelevole" + Keys.ENTER);
        Thread.sleep(3000);
        WebElement hatayazisielementi=driver.findElement(By.id("create_account_error"));
        Assert.assertTrue("Mesaj gorunmedi",hatayazisielementi.isDisplayed());
    }




}
