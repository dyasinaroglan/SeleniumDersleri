package Gun_13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _01WaitClickable extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement productS6 = driver.findElement(By.linkText("Samsung galaxy s6"));
        productS6.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addTOCard = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[onclick='addToCard(1)']")));
        //element clickable olana kadar bekle.
        System.out.println("addToCard : " + addTOCard.isEnabled());
        WebElement addToCard =driver.findElement(By.cssSelector("a[class='btn btn-success btn-lg']"));
        addToCard.click();
        //alert mesajı çıkana kadar bekle
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        driver.quit();

    }
}
