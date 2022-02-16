package Gun_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _01ByLinkText {
    public static void main(String[] args) {
        //Sauce Labs Backpack

        System.setProperty("webdriver.chrome.driver","C:\\SELENIUM\\chromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");  //SİTEYİ AÇIYORUZ

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        WebElement urun1 = driver.findElement(By.linkText("Sauce Labs Backpack"));
        System.out.println("urun1 getText = " + urun1.getText());// text i alarak ürünü bulduk ve o ürünü açtık.
        urun1.click();


    }
}
