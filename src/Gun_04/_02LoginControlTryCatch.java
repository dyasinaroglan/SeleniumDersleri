package Gun_04;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _02LoginControlTryCatch extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
         /*
        1- https://www.saucedemo.com/  sitesini acin
     2- Ekranda gorunen usernameleri bir string diziye atiniz
     3- Bu username ve passwordlarını hepsinin login olup olamadığını
        login olduktan sonraki sayfada Products kelimesinin kontrol ederek
        doğrulayınız.
        diğer login kontrolleri için navigate.back kullanınız.
     4- Login olamayan userları ve hata bilgisini yazdırınız.
         */

        driver.navigate().to("https://www.saucedemo.com/");
        WebElement users = driver.findElement(By.cssSelector(".login_credentials"));
        String userText = users.getText();
        //System.out.println(userSText.getText());
        String[] userNames = userText.split("\n");
        for (int i = 1; i < userNames.length; i++) {
            Thread.sleep(1000);

            WebElement userName = driver.findElement(By.id("user-name"));
            userName.clear();
            userName.sendKeys(userNames[i]);

            WebElement password = driver.findElement(By.id("password"));
            password.clear();
            password.sendKeys("secret_sauce");

            WebElement login = driver.findElement(By.id("login-button"));
            login.click();

            try {
                Thread.sleep(2000);
                WebElement products = driver.findElement(By.cssSelector("span[class='title']"));
                Assert.assertTrue(products.getText().equalsIgnoreCase("products"));
                System.out.println(userNames[i] + " : Bu userName ile login olundu....");
                Thread.sleep(1000);
                driver.navigate().back();
            }catch (Exception e){
                WebElement errorMessage = driver.findElement(By.cssSelector("div[class='error-message-container error']"));
                System.out.println(userNames[i] + " : Bu username ile login olunamadı..." + errorMessage.getText());
            }
        }
        driver.quit();
    }
}
