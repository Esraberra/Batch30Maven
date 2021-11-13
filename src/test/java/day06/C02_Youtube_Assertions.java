package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_Youtube_Assertions {

    //By.xpath("//button[@lang=\"fr\"]")
   static WebDriver driver;


    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
     driver =new ChromeDriver();
     driver.get("https://www.youtube.com");
     driver.findElement(By.xpath("(//tp-yt-paper-button[@id=\"button\"])[6]")).click();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void titleTest(){
String expectedTitle="YouTube";
        Assert.assertEquals(expectedTitle,driver.getTitle());

    }
    @Test
    public void imageTest(){
        WebElement image= driver.findElement(By.xpath("//yt-icon[@id=\"logo-icon\"]"));
      Assert.assertTrue(image.isDisplayed());
    }

@Test
    public void searchBox(){
        WebElement searchBox= driver.findElement(By.xpath("//input[@autocapitalize=\"none\"]"));
        Assert.assertTrue(searchBox.isEnabled());
}

@Test

    public void wrongTitleTest(){
        String hataliBaslik="youtube";
        String baslik=driver.getTitle();
    //Assert.assertFalse("sonuc : hatali baslik youtube a esit",hataliBaslik.equals(baslik));
Assert.assertNotEquals("Title istenmeyen kelimeye esit",hataliBaslik,baslik);
}


@AfterClass
    public static void tearDown(){
        driver.close();
}
}
