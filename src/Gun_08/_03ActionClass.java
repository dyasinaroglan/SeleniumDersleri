package Gun_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _03ActionClass extends BaseStaticDriver {

    private static WebDriver d;

    public static void main(String[] args) throws InterruptedException {
        /**
         * mouse çift tıklama --- doubleClick()
         * mouse sağ tıklama --- ContextClick()
         * tek tıklama ---- click()
         */

        driver.get("https://demoqa.com/buttons");
        WebElement ciftTıklama = driver.findElement(By.cssSelector("button[id='doubleClickBtn']"));
        Actions action = new Actions(driver);  // TODO: 24.02.2022 tarayıcı üzerinden yapıldığı için işlemler drive yazdık
        Thread.sleep(1000);
        //action.doubleClick(ciftTıklama).perform();
        Action ciftClick = action.moveToElement(ciftTıklama).doubleClick().build();
        ciftClick.perform(); // TODO: 24.02.2022 asıl aksiyon bu kod ile gerçekleşiyor.
        Thread.sleep(1000);

        WebElement sagTıklama = driver.findElement(By.cssSelector("button[id='rightClickBtn']"));
        Action sagClick = action.moveToElement(sagTıklama).contextClick().build();
        sagClick.perform();


        WebElement tekTıklama = driver.findElement(By.xpath("//button[text()='Click Me']"));
        Thread.sleep(1000);
        Action tekClick = action.moveToElement(tekTıklama).click().build();
        tekClick.perform();


        }
}
