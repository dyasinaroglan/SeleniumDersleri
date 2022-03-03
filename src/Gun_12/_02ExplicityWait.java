package Gun_12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _02ExplicityWait extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        /*
        implicity : bütün elementler için beklme süresi
        Explicity : özel olarak tek bir element için bekleme süresi


        .tıtleIs ---> tıtle bu olana kada bekle
        .titleContains  ----> title içinde belirttiğimiz kelime geçene kadar bekle
        .visibilityOfTheElement ---> element gözükene kadar bekle
        .elementToBeClickable  ----> element tıklanabilir olana kadar bekle
        .elementToBeSelected  ----> element seçilebilir olana kadar bekle
        .alertIsPresent  ---->  alert çıkana kadar bekle
        .textToBe ---->  element text görünür olana kadar bekle
        .InvisibilityOfTheElement  ----> element kaybolana kadar bekle

        Implicity wait in suresini bekliyor, hala bulamadiysa explicity wait ile belirgin elementi bekliyor.
        Her iki sure sonunda bulamazsa , hata veriyor.

         */

        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement button = driver.findElement(By.cssSelector("button[onclick='timedText()']"));
        button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); //Elementi bulduğu anda verilen süreyi beklemez.
        WebElement webDriver = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
       // WebElement webDriver = driver.findElement(By.xpath("//p[text()='WebDriver']"));
        System.out.println("WebDriver = " + webDriver.getText());

        Thread.sleep(1000);   //sayfanın son durumunu gözlemlemek için kullanılabilir.
        driver.quit();


    }
}
