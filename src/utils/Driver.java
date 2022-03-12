package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    /*
    driver üretecek
    projede driver kullanırken, driver bu class dan istenecek
    chrome, firefox, ie, edge, opera...
     */

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Object Browsers;


    public static WebDriver getDriver() {
        return getDriver(Gun_17.Browsers.CHROME);
    }


    public static WebDriver getDriver(Gun_17.Browsers browser) {
        if (driver == null) {
            switch (browser) {
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM\\Drivers\\geckodriver-v0.30.0-win64 (1)\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                case OPERA:
                    System.setProperty("webdriver.opera.driver", "C:\\SELENIUM\\Drivers\\operadriver.exe");
                    driver = new OperaDriver();
                    break;
                case EDGE:
                    System.setProperty("webdriver.msedge.driver", "C:\\SELENIUM\\Drivers\\msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;
                case IE:
                    System.setProperty("webdriver.ie.driver", "C:\\SELENIUM\\Drivers\\IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    break;
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM/chromeDriver\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
            }
        }
        return driver;
    }
    public static void quitDriver(){
        driver.quit();
    }
}

