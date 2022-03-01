package Gun_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

public class _03Alerts extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        WebElement alert = driver.findElement(By.id("alertButton"));
        alert.click();
        Thread.sleep(1000);
     driver.switchTo().alert().accept();

     WebElement alert1 = driver.findElement(By.id("timerAlertButton"));
     alert1.click();

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(1000);

        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.quit();


    }
}
