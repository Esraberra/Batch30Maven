package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_Test02 {
    public static void main(String[] args) {

        //1. http://zero.webappsecurity.com sayfasina gidin
        //2. Signin buttonuna tiklayin
        //3. Login alanine  “username” yazdirin
        //4. Password alanine “password” yazdirin
        //5. Sign in buttonuna tiklayin
        //6. Pay Bills sayfasina gidin
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8. tarih kismina “2020-09-10” yazdirin
        //9. Pay buttonuna tiklayin
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com");

driver.findElement(By.xpath("//button[@id=\"signin_button\"]")).click();
        WebElement username=driver.findElement(By.xpath("//input[@type=\"text\"]"));
        WebElement password=driver.findElement(By.xpath("//input[@type=\"password\"]"));
        username.sendKeys("username");
        password.sendKeys("password");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        driver.findElement(By.linkText("Pay Bills"));



    }
}
