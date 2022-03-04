package Gun_14;

import org.openqa.selenium.JavascriptExecutor;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _02Scrool_High extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().deleteAllCookies(); //site otomatik test edildiğini anladığında kendini korumaya alabiliyor.
        //cookisler temizlendiğinde

        driver.get("https://triplebyte.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //sayfanın en altına iner
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)"); //sayfanın en üstüne çıkar
        Thread.sleep(1000);


    }
}
