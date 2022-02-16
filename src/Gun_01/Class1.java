package Gun_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();                                         //sendKeys()
                                                                                     //click()
                                                                                     //checkBox()
                                                                                     //getText()
                                                                                     //getAttribute()
                                                                                     //isEnabled()

        driver.close();
        /*
        1.id-- ile element bulma
        2.name-- ile element bulma
        3.className-- ile
        4.LinkText
        5.partialLinkText
        6.tagName
        7.cssSelector todo tagAdı[@özellikAdı='deger']
        8.xpath
        driver.findelelement(By.xpath
        //tagAdı[@özellikAdı = 'deger'] xpath te bu şekilde yapıyoruz.
         */
        Thread.sleep(3000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();
        driver.close();
    }
}