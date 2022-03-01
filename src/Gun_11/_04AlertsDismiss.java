package Gun_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _04AlertsDismiss extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demoqa.com/alerts");
        WebElement alert = driver.findElement(By.id("confirmButton"));
        alert.click();

        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        driver.quit();
    }
}
