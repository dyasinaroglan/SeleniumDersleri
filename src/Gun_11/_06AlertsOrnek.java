package Gun_11;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _06AlertsOrnek extends BaseStaticDriver {


    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.demo.guru99.com/test/delete_customer.php");

        WebElement customerID = driver.findElement(By.cssSelector("input[type='text']"));
        customerID.click();
        Thread.sleep(1000);
        WebElement customer = driver.findElement(By.cssSelector("input[type='text']"));
        customer.sendKeys("12345");

        WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));
        submit.click();
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[type='submit']"));
        submit.click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        String expected = "Customer Successfully Delete!";
        String actual = driver.switchTo().alert().getText();
        Assert.assertEquals("yanlış url",expected,actual);
        if(expected.equals(actual)){
            System.out.println("harika bir test...");
        }
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.quit();

    }
}
