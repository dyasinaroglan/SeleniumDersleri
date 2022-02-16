package Gun_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _03By_GetAttribute {
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

        String a_class = login.getAttribute("class");
        String a_Type = login.getAttribute("type");

        System.out.println("type = " + a_Type);
        System.out.println("class = " + a_class);
        login.click();

    }
}
