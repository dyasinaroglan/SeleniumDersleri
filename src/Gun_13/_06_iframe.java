package Gun_13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _06_iframe extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://chercher.tech/practice/frames");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));


        driver.switchTo().frame(0);
        //ya da
        //driver.switchTo().frame("frame1");

        driver.switchTo().frame(0); // frame in altında bir tane daha frame var. ilk frame olduğu için '0' değerini aldı.
        //frame1 in altındaki ilk frame olduğu için 0 değerini aldı.
        //ya da
        //driver.switchTo().frame("frame3");

        WebElement checkBox = driver.findElement(By.cssSelector("input[id='a']"));
        System.out.println("checkbox : " + checkBox.isSelected());
        checkBox.click();
        System.out.println("checkbox : " + checkBox.isSelected());

        // TODO: 3.03.2022 şu an iki tane frame in içindeyiz o zaman bu iki frame den çıkmak için 2 defa parentFrame methodunu kullanmalıyız

        driver.switchTo().parentFrame(); //en son girdiğimiz frame den çıktık.
        driver.switchTo().parentFrame(); //ilk girdiğimiz frame den çıktık ve ana sayfada artık işlem yapabiliriz.

        WebElement selenium = driver.findElement(By.cssSelector("a[class='nav-link head active white']"));
        selenium.click();
        Thread.sleep(1000);
        driver.quit();


    }
}
