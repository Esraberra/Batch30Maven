package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01_Assertions {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    // ○ logoTest => BestBuy logosunun görüntülendigini test edin
    // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edi
   static WebDriver driver;

@BeforeClass
    public static void setup(){
    WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    driver.get("https://www.bestbuy.com/");
        driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

}

@Test
    public void test1(){


    String expectedUrl="https://www.bestbuy.com/";
    Assert.assertEquals("Istenen URL bulunamadi",expectedUrl,driver.getCurrentUrl());

}

@Test
    public void titleTest(){
    String expectedTitle="Rest";
    Assert.assertFalse(driver.getTitle().equals(expectedTitle));

}

@Test
    public void logoTest(){
    WebElement logo=driver.findElement(By.xpath("(//img[@alt=\"Best Buy Logo\"])[1]"));
    Assert.assertTrue(logo.isDisplayed());

}
@Test
    public  void FrancaisLinkTest(){
WebElement fransizcaLink= driver.findElement(By.xpath("//button[@lang=\"fr\"]"));
Assert.assertTrue(fransizcaLink.isDisplayed());

}


@AfterClass
    public static void tearDown(){
    driver.close();
}
}
