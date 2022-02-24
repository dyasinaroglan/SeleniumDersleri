package Gun_08;

import Gun_03._01TryCatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _01Css_XPathChıld extends BaseStaticDriver {
    public static void main(String[] args) {

        /**
         * Css
         * ul li---- ul tagname altında li olanları veriyor
         * ul>li ----- ul tagname altında li olanları veriyor.
         * ul.sociual li:first-child listenin iilk child i alma
         * ul.sociual li:last-child listenin son child i alma
         * ul.social li:nth-child(2) ---- listede indeksli child seçme
         */

        /**
         * XPath
         * //ul/li   --- ul tagname ın altında  li olanları veriyor.
         * //ul/li[1] ---- listenin ilk child i almak için
         * //ul[@class='social']/li[1]    ->listenin ilk child almak icin
         * //ul[@class='social']/li[last()]   ->listenin son child almak icin
         * //ul[@class='social']/li[2]         ->listede indeksli child secmek icin
         *
         */

        _01TryCatch.logın("standard_user","secret_sauce");
        WebElement facebook = driver.findElement(By.cssSelector("ul.social li:nth-child(2)"));
        System.out.println("facebook : " + facebook.getText());
        //facebook.click();

        WebElement linkedIn = driver.findElement(By.xpath("//ul[@class='social']/li[last()]"));
        System.out.println("LinkedIn = " + linkedIn.getText());

        List<WebElement> social = driver.findElements(By.cssSelector("ul li"));
        for (WebElement webElement : social) {
            System.out.println("social = " + webElement.getText());

        }
    }
}
