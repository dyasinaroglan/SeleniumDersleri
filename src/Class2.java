import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://login.yahoo.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.id("createacc")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("usernamereg-firstName")).sendKeys("AHMET");
        Thread.sleep(3000);
        driver.findElement(By.id("usernamereg-lastName")).sendKeys("password123!");
        Thread.sleep(3000);
        driver.findElement(By.id("usernamereg-yid")).sendKeys("yasinargln@264@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.id("usernamereg-phone")).sendKeys("54664754754");
        driver.quit();

    }
}
