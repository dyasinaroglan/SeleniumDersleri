package Gun_07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _04ElementStatus extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        /**
         *
         * boolean  isSelected(); -> secili mi
         * boolean isEnabled();   -> Kullanilabilir mi
         * boolean isDisplayed();  -> Görünüyor mu
         *
         * isSelected();   -> Wednesday  ->  true
         * isEnabled();    -> Monday    ->  true
         * isEnabled();    -> Sunday    ->  false (etkin değil)
         *
         * isDisplayed();   -> Monday    ->  true
         * isDisplayed();   -> Sunday    ->  true
         *
         */

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");


        Thread.sleep(2000);
        WebElement wednesday = driver.findElement(By.id("gwt-debug-cwCheckBox-Wednesday-label"));
        System.out.println("seçilmeden önce: " + wednesday.isSelected());
        System.out.println(wednesday.isEnabled());
        System.out.println(wednesday.isDisplayed());

        wednesday.click();
        System.out.println("seçildikten sonra : " + wednesday.isSelected());

        List<WebElement> daysList = driver.findElements(By.xpath("//input[@type='checkbox"));
        for (WebElement webElement : daysList) {
            System.out.println(webElement.isDisplayed());
            System.out.println(webElement.isEnabled());
            System.out.println(webElement.isSelected());

        }
    }
}
