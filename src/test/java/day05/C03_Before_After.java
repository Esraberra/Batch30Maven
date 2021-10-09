package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Before_After {
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
    public void amazonTesti() {
        driver.get("https://amazon.com");
        System.out.println(driver.getTitle());
    }
    @Test
    public void techproedTesti() {
        driver.get("https://techproeducation.com");
        System.out.println(driver.getTitle());
    }
@Test
    public void facebookTesti() {
        driver.get("https://facebook.com");
        System.out.println(driver.getTitle());
    }
 @After
    public  void tearDown(){
        driver.close();

    }




}
