package Gun_12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class _01WaitGiris extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
       // driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // driver ilk açılırken yüklenmesini bekletiyoruz.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));  // her element için bekleme süresi
        // TODO: 1.03.2022  element bulunduğu anda beklemeyi bırakır. 
       // Thread.sleep(1000); // elementi bulsa da bulmasa da beklenen süreyi bekler. JAVAYA AİT bir bekleme methodudur.
        // TODO: 1.03.2022 thread.sleep java ya ait bekletme kodu
        WebElement button = driver.findElement(By.cssSelector("button[onclick='timedText()']"));
        button.click();

        WebElement webDriver = driver.findElement(By.xpath("//p[text()='WebDriver']")); //button a click yapıldıktan sonra oluşan lokasyon
        //impilicitlyWait aktif olmadığı zaman driver da bu lokasyonun  gelmesini beklemdiği için hata verdi
        System.out.println("WebDriver = " + webDriver.getText());

        // TODO: 2.03.2022 duration of seconds ---> saniye süresi 
        // TODO: 2.03.2022 page Load TimeOut  ----> sayfa yükleme zaman aşımı 
        // TODO: 2.03.2022 implicitly wait    -----> dolaylı olarak bekle

        /**
         * implicit wait -- aranan herbir element için precence olmasını bekler.
         * max 30 saniye bekleyeek bulduğu an geçer.
         */

    }
}
