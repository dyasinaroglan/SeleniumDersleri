package Gun_09;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _03ActionDragAndDrogBy extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://talkerscode.com/webtricks/demo/demo_price-range-slider-using-jquery-css-and-php.php");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");

        WebElement solKaydır= driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-state-default ui-corner-all'][1]"));
        WebElement sagKaydır = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-state-default ui-corner-all'][2]"));

        Actions builder = new Actions(driver);
        Action solKaydırGeri = builder.dragAndDropBy(solKaydır,-100,0).build();
        // TODO: 24.02.2022 işlem yapacağım elementi seçiyorum, x ekseninde hangi yöne hareket edeceksem onu yazıyorum.
        solKaydırGeri.perform();

        Action sagKaydırIleri = builder.dragAndDropBy(sagKaydır,50,0).build();
        sagKaydırIleri.perform();
    }
}
