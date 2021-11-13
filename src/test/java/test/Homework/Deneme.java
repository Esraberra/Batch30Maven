package test.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Deneme {
    ///1. Bir class oluşturun : RadioButtonTest
//    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
//    //-https://www.facebook.com adresine gidin
//    //-“Create an Account” button’una basin
//    //-“radio buttons” elementlerini locate edin
//    //-Secili degilse cinsiyet butonundan size uygun olani secin
WebDriver driver;
    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
      driver=  new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
@Test
    public void test1(){
        driver.get("https://www.facebook.com");
    driver.findElement(By.xpath("(//button[@value=\"1\"])[3]")).click();
    driver.findElement(By.xpath("(//a[@role=\"button\"])[2]")).click();
        WebElement radioButton=driver.findElement(By.xpath("//input[@value=\"1\"]"));
    if (!radioButton.isSelected()) {
        radioButton.click();

    }

}

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}








