package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseStaticDriver {
    public static WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromeDriver\\chromedriver.exe");

         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // driver ilk açılırken yüklenmesini bekletiyoruz.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // her element için bekleme süresi

    }
}
