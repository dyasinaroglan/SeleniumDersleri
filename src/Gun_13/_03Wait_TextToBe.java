package Gun_13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _03Wait_TextToBe extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.demoblaze.com/index.html");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /*
    https://www.demoblaze.com/index.html siteye gidiniz
    Login olunuz
    user : Kraft
    pass : 12345
    Ilk once pass yanlis girilip cikan alert onaylanacak
    sonra dogru pass tekrar yollanip
    Login buttonun a basilacak
    Ana sayfada "Welcome Kraft" yazisi görününceye kadar bekleticez


     */
        WebElement logın = driver.findElement(By.id("login2"));
        logın.click();
        String user = "Kraft";
        WebElement userName = driver.findElement(By.id("loginusername"));
        userName.sendKeys("Kraft");

        WebElement password = driver.findElement(By.id("loginpassword"));
        password.sendKeys("12377");

        WebElement logınTekrar = driver.findElement(By.cssSelector("button[onclick='logIn()']"));
        logınTekrar.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
        password.clear();
        password.sendKeys("12345");

        logınTekrar.click();
        boolean welcome = wait.until(ExpectedConditions.textToBe(By.cssSelector("a#nameofuser"),"welcome " + user ));
        //verdiğimiz lokasyonda istediğimiz text görünür oluncaya kadar bekletti.
        System.out.println("welcome : " + welcome);



    }
}
