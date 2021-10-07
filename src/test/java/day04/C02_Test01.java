package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_Test01 {

    public static void main(String[] args) {

//1-Test01 isimli bir class olusturun
//2- https://www.walmart.com/ adresine gidin
//3- Browseri tam sayfa yapin
//4-Sayfayi “refresh” yapin
//5- Sayfa basliginin “Save” ifadesi icerdigini control edin
//6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
//7- URL in walmart.com icerdigini control edin
//8-”Nutella” icin arama yapiniz
//9- Kac sonuc bulundugunu yaziniz
//10-Sayfayi kapatin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.walmart.com/");
      String actuelTitle= driver.getTitle();
      String arananKelime="Save";
        if (actuelTitle.contains(arananKelime)) {
            System.out.println("title " + arananKelime + " kelimesini icerioyr, test PASS");

        }else  {
            System.out.println("title " + arananKelime + " kelimesini icermiyorr, test FAILED");
        }
        // Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz

String expectedTitle="Walmart.com | Save Money.Live Better";
        if (expectedTitle.equals(actuelTitle)) {
            System.out.println("sayfa title i beklenen ile ayni test PASS");

        } else {
            System.out.println("sayfa title  beklenen ile ayni degil");
            System.out.println("actual title  : " +actuelTitle);
        }

//7- URL in walmart.com icerdigini control edin
        String actualUrl=driver.getCurrentUrl();
        String arananUrl="walmart.com";
        if (actualUrl.contains(arananKelime)) {
            System.out.println("URL "+ arananUrl+ " kelimesini iceriyor PASS");

        }else {
            System.out.println("URL "+ arananUrl+ " kelimesini icermiyor TEST FAILED");
        }

//”Nutella” icin arama yapiniz

        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@name=\"q\"]"));
        aramaKutusu.sendKeys("Nutella");
        WebElement searchtool=driver.findElement(By.xpath("//button[@aria-label=\"Search icon\"]"));
        searchtool.click();
        //9- Kac sonuc bulundugunu yaziniz
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='inline-flex mv3-xl mt3 ml3 ml4-xl mr1 db']"));
        System.out.println(sonucYazisiElementi.getText());
        //10-Sayfayi kapatin
        driver.close();
    }
}







