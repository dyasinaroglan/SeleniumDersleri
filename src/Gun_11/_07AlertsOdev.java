package Gun_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class _07AlertsOdev extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("http://www.demo.guru99.com/test/delete_customer.php");

        List<WebElement> menu = driver.findElements(By.xpath("//li[@class='dropdown']"));
        Actions builder = new Actions(driver);

        for (WebElement i : menu) {
            Action action = builder.moveToElement(i).build();
            action.perform();
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
        driver.quit();
    }
}
