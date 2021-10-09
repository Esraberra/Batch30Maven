package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C04_CheckBox {

    //1. Bir class oluşturun : CheckBoxTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    // a. Verilen web sayfasına gidin.
    //     https://the-internet.herokuapp.com/checkboxes
    // b. Checkbox1 ve checkbox2 elementlerini locate edin.
    // c. Checkbox1 seçili değilse onay kutusunu tıklayın
    // d. Checkbox2 seçili değilse onay kutusunu tıklayın

    WebDriver driver;


    //

    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
     WebElement checkbox=driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]"));
        WebElement checkbox1=driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]"));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
///////////////////
        if (!checkbox1.isSelected()) {
            checkbox1.click();
            Thread.sleep(3000);
        }
    }





    @After
    public  void tearDown(){
        driver.close();

    }



}
