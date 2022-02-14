package Gun_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main_01 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\SELENIUM\\chromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.tr/?hl=tr");
        Thread.sleep(3000);
        WebElement onay = driver.findElement(By.id("L2AGLb"));
        onay.click();
        WebElement arama = driver.findElement(By.id("input"));
        arama.sendKeys("telefon");

    }
}
