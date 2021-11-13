package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleWeatherPage;
import static org.assertj.core.api.Assertions.assertThat;

public class GoogleWeatherTest {


    WebDriver driver;




    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @Test
    public void googleWeather() throws InterruptedException {
        String city="Seattle";
        GoogleWeatherPage weatherPage=new GoogleWeatherPage(driver);

        weatherPage.forCity(city).useCelsius();
        System.out.println(weatherPage.getCurrentTemperature());

        assertThat(weatherPage.getLocation().contains(city));
        assertThat(weatherPage.getTemperatureUnits().endsWith("C"));
    }


    @After
    public void tearDown(){

    }

}
