package Gun_03;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _02NaviGateTo extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        //_01TryCatch.logın("standard_user","secret_sauce"); methodun içinde driver.get() özelliğini kullandığı için
        //bu methodu kullanamayız.
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        Thread.sleep(3000);

        driver.navigate().back();
        String backSite = driver.getCurrentUrl();
        try {
            String expected1 = "https://www.saucedemo.com/inventory.html";
            Assert.assertEquals("yanlış url", expected1, backSite);
        } catch (AssertionError e) {
            System.out.println("e.getMessage() = " + e.toString());
            System.out.println("assert işlemi yapılamadı");
            Thread.sleep(3000);

            driver.navigate().forward();
            String forwardSite = driver.getCurrentUrl();
            String expected2 = "https://www.saucedemo.com/inventory-item.html?id=4";
            Assert.assertEquals("yanlış url girdiniz", expected2, forwardSite);
            if (forwardSite.equals(expected2)) {
                System.out.println("dogru sayfadasınız");
            }

            Thread.sleep(1000);
            driver.quit(); //senaryo ile açılan tüm sayfalar kapanır.
            //driver.close(); Sadece en son açık kalan sayfayı kapatır.
        }
    }
}
