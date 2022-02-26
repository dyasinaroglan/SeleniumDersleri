package Gun_07;

import Gun_03._01TryCatch;
import Gun_06._01Xpath;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _01RandomUrunKontrol extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        /**
         * https://www.saucedemo.com/  siteye git
         * Random bir ürün seç
         * ürüne tıkla
         * bilgilerini kontrol et
         *
         */

        driver.get("https://www.saucedemo.com/");
        _01TryCatch.logın("standard_user","secret_sauce");

        List<WebElement> urunList1 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> list1 = _01Xpath.elementToString(urunList1);
        List<WebElement> urunPrice1 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String> price1 = _01Xpath.elementToString(urunPrice1);
        List<WebElement> addToCart = driver.findElements(By.xpath("//button[text()='Add to cart']"));
        int random = randomSayı(urunList1.size());
        String randomUrunText = list1.get(random);
        String randomUrunPrice = price1.get(random);
        Thread.sleep(1000);
        addToCart.get(random).click();
        Thread.sleep(1000);
        urunList1.get(random).click();

        String sepettekiUrunName = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();
        String sepettekiUrunPrice = driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText();

        Assert.assertEquals(randomUrunText,sepettekiUrunName);
        Assert.assertEquals(randomUrunPrice,sepettekiUrunPrice);

        System.out.println("sepetUrunPrice = " + sepettekiUrunPrice);
        System.out.println("sepetUrunName = " + sepettekiUrunName);

        Thread.sleep(1000);
        driver.quit();

    }
    public static int randomSayı(int size){
        return (int) (Math.random()*size);
    }
}
