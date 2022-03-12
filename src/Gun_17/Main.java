package Gun_17;

import org.openqa.selenium.WebDriver;

public class Main {
    public static WebDriver driver;
    public static void main(String[] args) {

        driver = Driver.getDriver(Browsers.FIREFOX); //bu şekilde direkt chrome u çağırıyor.
        driver.get("https://www.google.com.tr/");

        driver = Driver.getDriver(Browsers.CHROME);
        driver.get("https://www.yahoo.com");

    }
}
