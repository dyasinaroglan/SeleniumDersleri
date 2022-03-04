package Gun_14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.Set;

public class _07_WindowOdev extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        /*
    https://techno.study/  sitesine gidiniz
    Get free consultation  butonuna click yapiniz
    acilan windowdaki email textbox  yazi gonderiniz
     */
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();

        driver.get("https://techno.study/");
        Thread.sleep(1000);

        //a[text()='SDET course']

        String anaSayfaId = driver.getWindowHandle();

        WebElement freeConsultation = driver.findElement(By.xpath("(//div[@class='t228__right_buttons_but']//a)[1]"));
        freeConsultation.click();
        Thread.sleep(1000);

        Set<String> windowHndles = driver.getWindowHandles();
        for (String i : windowHndles) {
            if(!windowHndles.equals(anaSayfaId)){
                driver.switchTo().window(i);
            }
        }
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(anaSayfaId);
        Thread.sleep(1000);


        WebElement facebook = driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
        facebook.click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String s : windowHandles) {
            if(!windowHandles.equals(anaSayfaId)){
                driver.switchTo().window(s);
            }
        }
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(anaSayfaId);

        driver.quit();
    }
}
