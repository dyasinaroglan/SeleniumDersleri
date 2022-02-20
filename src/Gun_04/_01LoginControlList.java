package Gun_04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _01LoginControlList extends BaseStaticDriver {
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
        String userText = users.getText(); //bütün girişlerin text olarak yazılımı
        //System.out.println(userSText.getText());
        String[] userNames = userText.split("\n"); //bu textleri bir alt satıra geçen "\n" ile ayırabilirim
        //split yöntemiyle bir alt satıra geçtiğinde String bir dizi oluşturarak bu dizimin içine atarım
        for (int i = 1; i < userNames.length; i++) {
            Thread.sleep(1000);

            WebElement userName = driver.findElement(By.id("user-name"));
            userName.clear();  //clear yapmamızın sebebi bir sonra gelen kullanıcı girişinin önceki kullanıcı girişi ile karışmaması.
            //bilgilerin üst üste yazılması tehlikesi.
            userName.sendKeys(userNames[i]); //userName kısmına userNames dizisinini i. elemanını at

            WebElement password = driver.findElement(By.id("password"));
            password.clear();  //şifre girişi yaptık
            password.sendKeys("secret_sauce");

            WebElement login = driver.findElement(By.id("login-button"));
            login.click(); //login tuşuna basıp click yaptık

            List<WebElement> products = driver.findElements(By.cssSelector("span[class='title']"));
            if(products.size()==1){
                System.out.println(userNames[i] + " : Bu userName ile login olundu....");
                Thread.sleep(2000);
                driver.navigate().back();
            }else {
                WebElement error = driver.findElement(By.cssSelector("div[class='error-message-container error']"));
                System.out.println(userNames[i] + " : Bu username ile login olunamadı..." + error.getText());
            }


        }
    }
}
