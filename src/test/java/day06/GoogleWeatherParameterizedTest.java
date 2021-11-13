package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleWeatherPage;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)

public class GoogleWeatherParameterizedTest {

  WebDriver driver;
  String city;

  public GoogleWeatherParameterizedTest(String city){
this.city=city;

  }
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @Test
    public void googleWeather() throws InterruptedException {

        GoogleWeatherPage weatherPage=new GoogleWeatherPage(driver);

        weatherPage.forCity(city).useCelsius();
        System.out.println(weatherPage.getCurrentTemperature());

        assertThat(weatherPage.getLocation().contains(city));
        assertThat(weatherPage.getTemperatureUnits().endsWith("C"));
    }


    @After
    public void tearDown(){
        if (!(driver == null)) {
            driver.quit();

        }
    }

    @Parameterized.Parameters(name = "{index}: com.google.weather.WeatherTest({0})={1}")
    public static Iterable<?extends Object>data(){
      return Arrays.asList(
            "Miami",
              "Morocco",
              "Greece",
              "Berlin",
              "Rome",
              "Istanbul",
              "Bursa",
              "Göbeklitepe"

      );
}





}
