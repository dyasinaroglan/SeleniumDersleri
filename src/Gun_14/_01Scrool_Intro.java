package Gun_14;

import org.openqa.selenium.JavascriptExecutor;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _01Scrool_Intro extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().deleteAllCookies(); //site otomatik test edildiğini anladığında kendini korumaya alabiliyor.
        //cookisler temizlendiğinde

        driver.get("https://triplebyte.com/");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,2000)"); //bulunduğu konumdan verdiğimiz ölçü kadar scroll yapar
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,-2000)");  //yukarı scroll yapıyor
        Thread.sleep(1000);
        js.executeScript("scroll(0, 250);");  //tüm sayfada konumlanmasını istediğimiz yerin konumuna scroll yapıyor.
    }
}
