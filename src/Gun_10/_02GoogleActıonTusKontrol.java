package Gun_10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _02GoogleActıonTusKontrol extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.google.com/");

        WebElement google = driver.findElement(By.cssSelector("input.gLFyf.gsfi"));
        google.click();
        google.sendKeys("Selenium");

        Actions builder = new Actions(driver);
        Action enter = builder.sendKeys(Keys.SPACE).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build();
        enter.perform();
        // TODO: 25.02.2022 tuşa sadece bir kez yaptırdığımız işlemler için sendKeys özelliğini kullanıyoruz
        Thread.sleep(1000);

        enter = builder.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).build();
        enter.perform();
        Thread.sleep(1000 );
        driver.quit();
    }

}
