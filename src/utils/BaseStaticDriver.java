package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseStaticDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromeDriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // driver ilk açılırken yüklenmesini bekletiyoruz.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // her element için bekleme süresi
        // TODO: 8.03.2022 2implicit wait---> Aranan herbir element için precence olmasını bekler
        // TODO: 8.03.2022 max 30 saniye bekleyecek. her 0.5 saniye de bir kontrol eder.bulduğu an geçer.

         wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        // TODO: 8.03.2022 2.explicit --> elementin durumuna göre özel bekleme türü
        // TODO: 8.03.2022  bir elementin visible olana kadar yad clickable oluncaya kadar beklenemsi. elemente özel bekleme

    }
    public static void sleep(long milis){
        try {
            Thread.sleep(milis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void clickTo(By locator){
        // 1.yazılışı ---> driver.findElement(locator).click();
        // 2. yazılışı ----> WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        //element.click();
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        //By locator demek by sınıfından By.xpath
                                       //  By.ByCssSelector
                                        // By.id() bir locator.
    }
    public static void sendKeysTo(By locator, String str){
        //driver.findElement(locator).sendKeys(str);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(str);
        //webElement return ettiği için click yapabiliyorum.
    }
    public static void takeScreenShot() throws IOException {
        String fileName = "ScreenShot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        TakesScreenshot scrShot = (TakesScreenshot) driver;
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        File destFile = new File("screenShots\\" + fileName + ".png");
        try {
            FileUtils.copyFile(srcFile,destFile);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
