package Gun_13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _02WaitInvisibility extends BaseStaticDriver {
    public static void main(String[] args) {
        /*
        https://the-internet.herokuapp.com/dynamic_controls  siteye gidiniz
        Remove buttonuna basiniz
        wait loading kaybolana kadar bekletin
        Sonrada "It's back! " bu yazini görünürlügünü onaylayin
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement remove = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        remove.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        boolean loading =  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//div[@id='loading'])[1]")));
        //invisibility özelliği boolean olarak değişkene alınabiliyor.

        System.out.println("loading : " + loading);

        WebElement mesaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("p#message")));
        //visibility özelliği webElement olarak değişkene alınabiliyor.
        System.out.println("mesaj = " + mesaj.isEnabled());
        System.out.println("mesaj : " + mesaj.getText());




    }
}
