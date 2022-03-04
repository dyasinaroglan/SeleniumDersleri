package Gun_14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class _04OpenWİndow extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.selenium.dev/");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().deleteAllCookies();

        String anasayfaID = driver.getWindowHandle(); //sayfada yönelme geçekleşmeden önce ana sayfanın id sini kayıt altına aldık.

        List<WebElement> targetLinks = driver.findElements(By.cssSelector("a[target='_blank']"));

        for (WebElement targetLink : targetLinks) { //listedeki bütün linkleri açtık
            targetLink.click();
        }
        Set<String> windowHandles = driver.getWindowHandles();
        //farklı sayfalarda açılan linklerin  id lerini set ile kayıt altına aldık.

        for (String windowHandle : windowHandles) {
            System.out.println("window handles : " + windowHandle);
        }
       // id ler her zaman değişiyor



    }
}
