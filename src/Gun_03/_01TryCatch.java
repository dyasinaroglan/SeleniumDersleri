package Gun_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _01TryCatch extends BaseStaticDriver {
    public static void main(String[] args) {
        logın("standard_user","secret_sauce");
        try {
            WebElement urun = driver.findElement(By.cssSelector("img[alt='Sauce Labs Backpac']"));  //sonda ki k yı sildik--backpack
            urun.click();
        }catch (Exception e){
            System.out.println("element bulunamadı = " + e.getMessage());
        }


    }
    public static void logın(String user, String pass){
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

    }

}
