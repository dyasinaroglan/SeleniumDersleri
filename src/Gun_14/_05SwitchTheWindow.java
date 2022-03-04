package Gun_14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class _05SwitchTheWindow extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        /*
        https://www.selenium.dev/  siteye gidiniz
        github link i click yapilacak
        github da Wiki click yapilacak
         */

        driver.get("https://www.selenium.dev/");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().deleteAllCookies();

        String anasayfaID = driver.getWindowHandle(); //sayfada yönelme geçekleşmeden önce ana sayfanın id sini kayıt altına aldık.
        WebElement github = driver.findElement(By.xpath("(//a[@target='_blank'])[9]"));
        github.click();

        Set<String> windowID = driver.getWindowHandles();
        for (String i : windowID) {
            if(!windowID.equals(anasayfaID)){ //açılan sayfa anaSayfanın İD si değilse diğer açılan sayfaya geçiş yap diyoruz.
                driver.switchTo().window(i);

                WebElement wiki = driver.findElement(By.cssSelector("span[data-content='Wiki']"));
                wiki.click();
                Thread.sleep(1000);
                driver.close(); //close yapıp kapatıyoruz fakat switchTo ile geçiş yapmamız lazım tekrardan
            }
        }
        driver.switchTo().window(anasayfaID);
        WebElement slack = driver.findElement(By.xpath("(//a[@target='_blank'])[10]"));
        slack.click();
        System.out.println("getTitle : " + driver.getTitle());
    }
}
