package Gun_09;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _02ActionDragAndDrop extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement norvec = driver.findElement(By.id("box101"));

        System.out.println("oslo taşınmadan önce : " + oslo.getCssValue("background-color"));

        Actions builder = new Actions(driver);
        Action action = builder.dragAndDrop(oslo,norvec).build();
        //tasınan ---oslo    hedef----norvec
        action.perform();

        System.out.println("oslo taşındıktan sonra : " + oslo.getCssValue("background-color"));
        String expected = "rgba(0, 255, 0, 1";
        Assert.assertEquals(expected,oslo.getCssValue("background-color"));

        WebElement madrid = driver.findElement(By.id("box7"));
        WebElement spain = driver.findElement(By.id("box107"));

        action = builder.dragAndDrop(madrid,spain).build();
        action.perform();

        Assert.assertEquals(expected,madrid.getCssValue("background-color"));

        WebElement rome = driver.findElement(By.id("box6"));
        WebElement ıtaly = driver.findElement(By.id("box106"));

        action = builder.dragAndDrop(rome,ıtaly).build();
        action.perform();

        Assert.assertEquals(expected,rome.getCssValue("background-color"));

        Thread.sleep(1000);
        driver.quit();

    }
}
