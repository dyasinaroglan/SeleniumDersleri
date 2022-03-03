package Gun_12;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _03WaitExample extends BaseStaticDriver {
    /**
     * https://www.demoblaze.com/index.html  --- Bu siteye giriniz
     * Samsung galaxy s6  ürününü aciniz
     * AddToCart butonuna basiniz
     * alert kutusu cikana kadar bekleyiniz
     * Alert kabul edin.

     */
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));  //her element için

        WebElement productS6 = driver.findElement(By.linkText("Samsung galaxy s6"));
        productS6.click();

        WebElement addToCard =driver.findElement(By.cssSelector("a[class='btn btn-success btn-lg']"));
        addToCard.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent()); // alert görünür oluncaya kadar bekle
        String message = driver.switchTo().alert().getText();
        System.out.println("alert mesaj" + message);
        Assert.assertEquals("Product added",message);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.quit();



    }
}
