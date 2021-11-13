package test.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Double.parseDouble;

public class ElifHocaOdev1 {
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

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Ignore
    public void Test1(){
        //// List all the elements on the website
        //   web sitesindeki tüm elementleri listele
        List<WebElement> list=driver.findElements(By.cssSelector("*"));
        for (WebElement each:list
        ) {
            System.out.println(each.getText());
        }

    }

    @Test
//ürünleri listeliyor
    public void ürünListele() throws InterruptedException {
        List<WebElement> productsNameList=driver.findElements(By.className("shelf-item__title"));

        ArrayList<String> liste = new ArrayList<>();
int j=1;
        for (WebElement each : productsNameList
        ) {
            try {
                Thread.sleep(2000);
                liste.add(each.getText());
                j++;
            } catch (Exception e) {

            }
        }
        System.out.println("Sitedeki ürünler: " +liste+ j+" adet  ürün bulunmaktadir");
////////////////////////////////////

    }
@Test
    public void test2() throws InterruptedException {

    List<WebElement> productList = driver.findElements(By.className("shelf-item__title"));

    List<Integer> itemsAddedToCart = new ArrayList<>();
    while (itemsAddedToCart.size()<5){

        Random random=new Random();

    int tümÜrünSayisi= productList.size();

    int randomUrun1= random.nextInt(tümÜrünSayisi);
        if (! itemsAddedToCart.contains(randomUrun1)) {

         itemsAddedToCart.add(randomUrun1);
            productList.get(randomUrun1).click();
         Thread.sleep(1000);
            driver.findElement(By.xpath("//div[@class='float-cart__close-btn']")).click();

            Thread.sleep(1000);
        }





    }

}



    @Test
    public void test3(){
        List<WebElement> soldProductspriceList=driver.findElements(By.xpath(" //div[@class='val']"));
        List<Double> doubleList=new ArrayList<>();
        for (WebElement each:soldProductspriceList ) {
            doubleList.add(Double.parseDouble(each.getText().substring(1)));

        }
        System.out.println(doubleList);
     double   toplam=0;
        for (double each: doubleList
             ) {
            toplam=each+toplam;
        }
        System.out.println(toplam);
        double expected=440.0;

        if (expected==toplam) {
            System.out.println("success");
        }else {
            System.out.println("failed");
        }
    }


    @AfterClass
    public static void tearDown(){

        driver.close();
    }
}















