package Gun_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseStaticDriver;

import java.io.IOException;

public class Main extends BaseStaticDriver {
    public static void main(String[] args) throws IOException {

        driver.manage().deleteAllCookies();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        By username = By.cssSelector("#txtUsername");  // TODO: 8.03.2022 By --> locater'ların tutulduğu bir class 
        By password = By.cssSelector("#txtPassword");
        By submit = By.cssSelector("#btnLogin");
        By welcome = By.cssSelector("#welcome");

        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        takeScreenShot();

        //id de bulurken 2 tane çıktı biri javaScript ise buna bakmaya gerek yok. direkt kopyala yapıştır.
        /*
        sendKeysTo(By.cssSelector("#txtUsername"),"Admin");
        sendKeysTo(By.cssSelector("#txtPassword"),"admin123");
        clickTo(By.cssSelector("#btnLogin"));

         */

        // TODO: 8.03.2022 xpath geriye doğru da arar. cssSelector sadece ileriye doğru bulur. o yüzden css daha hızlı çalışır.
        sleep(1000);

        sendKeysTo(username,"Admin");
        sendKeysTo(password,"admin123");
        clickTo(submit);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(welcome));
        }catch (Exception e){
            takeScreenShot();  //hata varsa screenShot AL DİYORUZ
        }

        takeScreenShot();

        driver.quit();



    }


}
