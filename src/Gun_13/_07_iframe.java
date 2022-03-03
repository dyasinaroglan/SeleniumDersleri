package Gun_13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _07_iframe extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://chercher.tech/practice/frames");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        driver.switchTo().frame(0); //frame1

        WebElement topics = driver.findElement(By.cssSelector("body>input"));
        topics.sendKeys("Kraft Techno");

        driver.switchTo().parentFrame();

        WebElement selenium = driver.findElement(By.xpath("(//a[@class='nav-link head'])[2]"));
        selenium.click();

        driver.quit();


    }
}
