package test.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ElifHocaOdev {
////Navigate to "https://react-shopping-cart-67954.firebaseapp.com/"
//// List all the elements on the website
 //   web sitesindeki tüm elementleri listele
  //   string array list yarat ürünlerin isimlerini array listeye at
    //benim elimde su an
//// Create a String Arraylist and put Product Names into the ArrayList
//// Choose 5 items randomly, add to cart and print the names of items
//// (Each product cannot be added more then 1 time!)
//
//// CHECK THE PRICES!
//// Sum each item's price and compare your result with the website
//// If results are matching print success message
//// Get string price values from Website, convert them to double and add to <Double> ArrayList and print the price list
//// Click Checkout
static WebDriver driver;




    public static void main(String[] args) throws InterruptedException {

     setup();
Thread.sleep(2000);
//test1();
//List<WebElement> ProductNames=driver.findElements(By.xpath(""));
        test2();
}



    public  void test1(){

        List<WebElement> list=driver.findElements(By.cssSelector("*"));
        for (WebElement each:list
        ) {
            System.out.println(each.getText());

        }


    }

    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    public static void test2(){

        ArrayList<String> liste = null;
     List<WebElement> productList=driver.findElements(By.xpath("//p"));


        for (WebElement each:productList
             ) {
          liste = new ArrayList<>(Collections.singleton(each.getText()));
          System.out.println("all products are listed : "+liste);
        }
        int tümÜrünSayisi= productList.size();
        Random random=new Random();
        int randomUrun= random.nextInt(tümÜrünSayisi);
        productList.get(randomUrun).click();

        //tüm ürünleri arrayliste atip yazdiriyorum
        //listeden random 5 ürün sec ve sepete at

    }

}
