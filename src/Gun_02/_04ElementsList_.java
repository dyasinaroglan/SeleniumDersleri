package Gun_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class _04ElementsList_ {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");  //SİTEYİ AÇIYORUZ

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        List<WebElement> urunLıstesi = driver.findElements(By.className("inventory_item_name"));

        for (WebElement webElement : urunLıstesi) {
            System.out.println(webElement.getText());
        }
        List<WebElement> addToCard = driver.findElements(By.cssSelector("div[class='inventory_item']"));
        for (WebElement webElement : addToCard) {
            webElement.click();
        }
        List<WebElement> removeAddToCard = driver.findElements(By.cssSelector("button[class='btn btn_secondary btn_small btn_inventory']"));
        for (WebElement webElement : removeAddToCard) {
            webElement.click();

        }

    }
}
