package Gun_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class _02ActionHoverOver extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.etsy.com/");
        Thread.sleep(1000);
       /* WebElement clothing = driver.findElement(By.cssSelector("span#catnav-primary-link-10923"));
        WebElement kids = driver.findElement(By.cssSelector("span#side-nav-category-link-10941"));
        Thread.sleep(1000);
        Actions builder = new Actions(driver);
        Action action = builder.moveToElement(clothing).build();
        action.perform();
        Thread.sleep(1000);

         action = builder.moveToElement(kids).build();
        action.perform();

        */
        Actions builder = new Actions(driver);

        List<WebElement> menuBar = driver.findElements(By.cssSelector("span[class='wt-text-black']"));



        for (WebElement i : menuBar) {
            Action action = builder.moveToElement(i).build();
            action.perform();
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
        driver.quit();
    }
}
