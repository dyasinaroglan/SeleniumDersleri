package Gun_09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _01ActionDragAndDrop extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        Thread.sleep(1000);
        driver.switchTo().frame("gdpr-consent-notice");
        // ekranda devam edebilmemiz icin iframe olustu. Gecis yapabilmek icin bu kodu yazdik.
        // iframe bulabilmek icin name ve id kullanilmali
        Thread.sleep(1000);
        WebElement akzeptieren = driver.findElement(By.xpath("//span[text()='Alle akzeptieren']"));
        akzeptieren.click();

        WebElement bank = driver.findElement(By.id("credit2"));  //   (//a[@class='button button-orange'])[5]
        WebElement hedef = driver.findElement(By.id("bank"));
        Actions builder = new Actions(driver);
     //   Action tasıma = builder.clickAndHold(bank).moveToElement(hedef).release().build();
     //   tasıma.perform();
        // TODO: 24.02.2022 release taşıma işlemini yapan
        // TODO: 24.02.2022 bir şeyi tutucam ve hedeflediğim yer var oraya atıcam bunu da clickAndHold ile yapıyorum
        // TODO: 24.02.2022 clickAndHold --- taşınacak elementi tıklayıp tutuyor,
        // TODO: 24.02.2022  release---hedefe bırakmasını sağlar,taşıma işlemi yapar
        // TODO: 24.02.2022 moveToElement ---- hedefe hareket et hadi bakalım,koş

        Action tasıma1 = builder.dragAndDrop(bank,hedef).build();
        tasıma1.perform();  //2.yol

    }
}
