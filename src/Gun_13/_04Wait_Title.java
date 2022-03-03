package Gun_13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _04Wait_Title extends BaseStaticDriver {
    public static void main(String[] args) {

       /*
        https://www.yogaalliance.org/  siteye gidiniz
        Action ile Become a Member uzerine geliniz
        Teacher click yapiniz
        title  "Teachers | Yoga Alliance"  olana kadar beklet

     */


        driver.get("https://www.yogaalliance.org/");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement become = driver.findElement(By.cssSelector("li[class='root first haschild child-1']"));
        Actions builder = new Actions(driver);
        Action action =  builder.moveToElement(become).build();
        action.perform();

        WebElement teachers = driver.findElement(By.className("(//li[@class='category child-3'])[3]"));
        teachers.click();

        String expected = "Teachers | Yoga Alliance";
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        boolean title = wait.until(ExpectedConditions.titleContains(expected));
        boolean title1 = wait.until(ExpectedConditions.titleIs(expected));

        String resultTitle = driver.getTitle(); //bulunduğumuz sayafanın title ını alıyoruz.
        System.out.println("resultTitle : " + resultTitle);

    }
}
