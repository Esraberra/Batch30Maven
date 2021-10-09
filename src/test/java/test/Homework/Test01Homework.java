package test.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test01Homework {

    //1-Test01 isimli bir class olusturun
    //2- https://www.amazon.com/ adresine gidin
    //3- Browseri tam sayfa yapin
    //4-Sayfayi “refresh” yapin
    //5- Sayfa basliginin “Amazon” ifadesi icerdigini control edin
    //6-Sayfa basliginin “Amazon.com. Spend less. Smile more.” a esit oldugunu control ediniz
    //7- URL in amazon.com icerdigini control edin
    //8-”Nutella” icin arama yapiniz byid "twotabsearchtextbox"
    //9- Kac sonuc bulundugunu yaziniz
    //10-Sayfayi kapatin
    static WebDriver driver;

@BeforeClass
    public static void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.get("https://www.amazon.com");
    driver.manage().window().fullscreen();
    driver.navigate().refresh();
    }
    @Test
    public void test1(){
        String title =driver.getTitle();
     String  expectedTitle="Amazon";

        System.out.println(title);
        if (title.contains(expectedTitle)) {
            System.out.println("Amazon ifadesi iceriyor");

        }else {
            System.out.println("Amazon ifadesi icermiyor");
        }


    }
@Test
    public void test2(){  //6-Sayfa basliginin “Amazon.com. Spend less. Smile more.” a esit oldugunu control ediniz
    String title =driver.getTitle();
    String  expectedTitle="Amazon.com. Spend less. Smile more.";


   if (title.equals(expectedTitle)) {
      System.out.println("Amazon.com. Spend less. Smile more.' a esit PASS");

 } else {
    System.out.println("FAILED");
    }

}
@Test
    public void test3(){
    String expectedUrl="amazon.com";
    if (driver.getCurrentUrl().contains(expectedUrl)) {
        System.out.println("current url contains amazon.com : PASS");

    } else {
        System.out.println("\"current url DOESNT contains amazon.com : FAILED\"");
    }

    }
@Test
//8-”Nutella” icin arama yapiniz byid "twotabsearchtextbox"
public void test4(){
    WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
    searchBox.sendKeys("Nutella" + Keys.ENTER);
  ;
    System.out.println( "Nutella sonuc sayilari :"+driver.findElement(By.xpath("(//span[@dir=\"auto\"])[1]")).getText());
}



@AfterClass
    public static void tearDown(){
    driver.close();

    }

}
