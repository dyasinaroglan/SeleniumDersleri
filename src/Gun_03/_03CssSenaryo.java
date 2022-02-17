package Gun_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _03CssSenaryo extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        /**
         *https://formsmarts.com/form/yu?mode=h5  siteye acin
         *      Business  secelim
         *      Online Advertising - secelim
         *      Every Day    - secelim
         *      Average        - secelim
         *      I'm using XYZ for about a week  - secelim
         *      Message kismina bir yazi gönderelim
         *
         */
        driver.get("https://formsmarts.com/form/yu?mode=h5");
        Thread.sleep(1000);
        WebElement bussiness = driver.findElement(By.cssSelector("input[name='u_Dsr_4586']"));
        bussiness.click();
        Thread.sleep(1000);
        WebElement select = driver.findElement(By.cssSelector("select[name='u_Dsr_4588']"));
        select.click();
        Thread.sleep(1000);
        WebElement onlineAdvertising = driver.findElement(By.cssSelector("option[value='Online Advertising']"));
        onlineAdvertising.click();

        WebElement everyDay = driver.findElement(By.cssSelector("input[name='u_Dsr_89585']"));
        everyDay.click();

        WebElement avarage = driver.findElement(By.cssSelector("input[value='Average']"));
        avarage.click();

        WebElement select1 = driver.findElement(By.cssSelector("select[name='u_Dsr_4597']"));
        select1.click();

        WebElement XYZweek = driver.findElement(By.cssSelector("option[value=\"I'm using XYZ for about a week\"]"));
        XYZweek.click();

        WebElement message = driver.findElement(By.cssSelector("textarea[id='u_Dsr_89597']"));
        message.sendKeys("bu bir selenium testidir.");

        Thread.sleep(2000);
        driver.quit();

    }
}
