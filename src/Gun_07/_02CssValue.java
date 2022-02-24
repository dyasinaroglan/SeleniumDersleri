package Gun_07;

import Gun_03._01TryCatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _02CssValue extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        System.out.println(login.getCssValue("color"));
        System.out.println(login.getCssValue("background-color"));
        System.out.println(login.getCssValue("border"));
        Thread.sleep(1000);
        login.click();

    }
}
