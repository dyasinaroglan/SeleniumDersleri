package Gun_10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _01ActionTusKontrol extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/auto-complete");

        WebElement textBox = driver.findElement(By.xpath("//div[@class='auto-complete__value-container css-1hwfws3']"));
        Thread.sleep(1000);
        Actions builder = new Actions(driver);
        //Kraft
        Action action = builder.moveToElement(textBox).click().keyDown(Keys.SHIFT).sendKeys("k")
                .keyUp(Keys.SHIFT).sendKeys("raft").build();   //keyDown -- aşağı  KeyUp --- yukarı
      //  Keys.SHIFT --- Harfi büyütüyor.
        action.perform();
        Thread.sleep(2000);

        Actions action1 = builder.moveToElement(textBox).keyDown(Keys.CONTROL).sendKeys("a").sendKeys(Keys.DELETE);
        action1.perform();
        Thread.sleep(2000);
        // TODO: 25.02.2022 tuşa basılı kalmasını istediğimizde KeyDown kullanıyoruz.
        driver.quit();
    }
}
