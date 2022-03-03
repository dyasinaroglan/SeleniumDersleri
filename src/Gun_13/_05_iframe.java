package Gun_13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _05_iframe extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://chercher.tech/practice/frames");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        //driver.switchTo().frame("frame2");
        //ya da
        driver.switchTo().frame(1); // TODO: 3.03.2022 frame değeri string ve int değer alabilir. index sıfırdan başlar.
        // TODO: 3.03.2022 burada iki tane parentFrame olduğu için bizim istediğimiz frame de ikincisi olduğu için frame indexi 1 oldu.

        WebElement avatar = driver.findElement(By.id("animals"));
        Select select = new Select(avatar);
        select.selectByValue("avatar");
        Thread.sleep(1000);

        driver.quit();

    }
}
