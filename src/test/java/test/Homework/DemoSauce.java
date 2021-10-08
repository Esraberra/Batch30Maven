package test.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DemoSauce {
    public static void main(String[] args) throws IOException {

         /*
        1. "https://www.saucedemo.com" Adresine gidin
        2. Username kutusuna "standard_user" yazdirin
        3. Password kutusuna "secret_sauce" yazdirin
        4. Login tusuna basin
        5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        6. Add to Cart butonuna basin
        7. Alisveris sepetine tiklayin
        8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        9. Sayfayi kapatin
         */
WebDriverManager.chromedriver().setup();
WebDriver driver =new ChromeDriver();
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
driver.get("https://www.saucedemo.com");

        WebElement userName=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        userName.sendKeys("standard_user");
        WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();
    WebElement ilkUrun=    driver.findElement(By.xpath("(//div[@class=\"inventory_item_name\"])[1]"));
    String urunKayit=ilkUrun.getText(); //ürünü String tipinde konteynira kaydettik
        System.out.println(urunKayit);



        ilkUrun.click(); // almak istenen ürüne tikladik
driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();   // ürünü sepete ekledik


driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]")).click();

WebElement sepettekiUrun=driver.findElement(By.xpath("//div[@class=\"inventory_item_name\"]"));

        if (sepettekiUrun.isDisplayed()) {
         System.out.println("sepete basariyla eklenmis PASS");

       }else {
          System.out.println("sepette ürün görünmüyor FAIL");
        }
driver.close();
    }
}
