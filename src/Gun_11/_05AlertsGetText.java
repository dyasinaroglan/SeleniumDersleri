package Gun_11;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _05AlertsGetText extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        WebElement alert = driver.findElement(By.id("promtButton"));
        Thread.sleep(1000);
        alert.click();

        driver.switchTo().alert().sendKeys("bu bir testtir");
        Thread.sleep(1000);
        System.out.println(driver.switchTo().alert().getText());

        String expected = "Please enter your name";
        String actual = driver.switchTo().alert().getText();

        Assert.assertEquals("yanlış mesaj",expected,actual);
        if(expected.equals(actual)){
            System.out.println("başarılı mesaj ve test");
        }
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
