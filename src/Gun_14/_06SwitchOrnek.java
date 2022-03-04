package Gun_14;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.Set;

public class _06SwitchOrnek extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
           /*
    https://www.amazon.com.tr/  siteye gidiniz
    Cerezleri kabul et                                         // input[name='accept']
    arama textbox a "Kitap" yazip ara butonuna click yapalim    // input#twotabsearchtextbox   // input[type='submit']
    Ürün listesinde 40. kitaba e kadar scrool yapalim            (//img[@class='s-image'])[40]
     sonra kitabi click yapalim
     Twitter iconun kadar scroll yapip click yapalim         //  (//a[@target='_blank'])[2]
     name kismina bir text gönderelim                        // input[type='text']
     */
        driver.get("https://www.amazon.com.tr/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
        String anaSayfaID = driver.getWindowHandle();

        driver.get("https://www.amazon.com.tr/");
        WebElement cerez1 = driver.findElement(By.cssSelector("input[id='sp-cc-accept']"));
        cerez1.click();
        WebElement search = driver.findElement(By.cssSelector("input[type='text']"));
        search.sendKeys("kitap");
        WebElement ara = driver.findElement(By.cssSelector("input[id='nav-search-submit-button']"));
        ara.click();

        WebElement kitap41 = driver.findElement(By.cssSelector("img[data-image-index='40']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);",kitap41);
        Thread.sleep(2000);
        kitap41.click();

        WebElement twitter = driver.findElement(By.xpath("//i[@aria-label='Twitter']"));
        js.executeScript("arguments[0].scrollIntoView(false);",twitter);
        Thread.sleep(1000);
        twitter.click();

        Set<String> windowId = driver.getWindowHandles();
        for (String i : windowId) {
            if(!windowId.equals(anaSayfaID)){
                driver.switchTo().window(i);  //bunu yaptıktan sonra diğer sayfaya geçmiş oluyoruz ve artık bu sayfada diledeğimiz işlemi yapabiliriz
                Thread.sleep(1000);
                driver.close();
            }
        }
        driver.switchTo().window(anaSayfaID);
        driver.quit();
    }
}
