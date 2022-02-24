package Gun_08;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Locale;

public class _02Select extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.ebay.com/");

        WebElement kategori = driver.findElement(By.cssSelector("select[id='gh-cat']"));
        Thread.sleep(1000);
        Select select = new Select(kategori);
        //select.selectByVisibleText("Books");
        select.selectByIndex(10);  // TODO: 24.02.2022 index değeri ile elementi bulma. option larda index sıfırdan başlar.//select.selectByValue("267");
        // select.selectByValue("267"); // TODO: 24.02.2022  value değeri bulma, String

        List<WebElement> option = select.getOptions();
        String secim = option.get(10).getText();
        System.out.println("seçim = " + secim);

        WebElement search = driver.findElement(By.cssSelector("input[type='submit']"));
        search.click();

        Thread.sleep(2000);
        WebElement urunIsmı = driver.findElement(By.xpath("(//a[@class='seo-breadcrumb-text'])[2]"));
        System.out.println("ürün ismi = " + urunIsmı.getText());

        Assert.assertTrue(secim.contains(urunIsmı.getText()));

        String url = driver.getCurrentUrl();
        System.out.println("url = " + url);
        Assert.assertTrue(url.toLowerCase(Locale.ROOT).contains(secim.toLowerCase(Locale.ROOT)));




    }
}
