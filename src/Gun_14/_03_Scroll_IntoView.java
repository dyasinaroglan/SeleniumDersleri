package Gun_14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _03_Scroll_IntoView extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://triplebyte.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.cssSelector("div[class='text-center font-bold text-3xl']"));

        js.executeScript("arguments[0].scrollIntoView(true);",element); //lokasyonunu verdğiğim elemente kadar scroll yap
        //default olarak window un üst kısmına konuşlanıyor. window un üst kısmına konuçlanıyor.
        //js.executeScript("arguments[0].scrollIntoView(false);",element);
        //window un alt kısmına konuçlanıyor
        //js.executeScript("arguments[0].scrollIntoView();",element);
        //lokasyonunu verdiğim element kadar scroll yap. default olarak  window un üst kısmına konuclanıyor.

    }
}
