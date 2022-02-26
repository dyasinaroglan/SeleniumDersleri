package Gun_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class _04BaskentlerFor extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        List<WebElement> baskent = driver.findElements(By.cssSelector("div#dropContent div[id^='box']"));
        List<WebElement> ulkeler = driver.findElements(By.cssSelector("div#countries div[id^='box']"));

        Actions builder = new Actions(driver);
        Action action;
        String expected = "rgba(0, 255, 0, 1)";

        for (int i = 0; i < baskent.size(); i++) {
            for (int j = 0; j < ulkeler.size(); j++) {
                action = builder.dragAndDrop(baskent.get(i),ulkeler.get(j)).build();
                action.perform();

                if(baskent.get(i).getCssValue("background-color").equals(expected)){
                    break;
                }
            }
        }
        Thread.sleep(1000);

    }
}
