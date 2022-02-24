package Gun_07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _03CssValue extends BaseStaticDriver {
    public static void main(String[] args) {


        driver.get ("https://form.jotform.com/220466667555061");
        driver.manage().window().maximize();
        WebElement name = driver.findElement(By.cssSelector("input[id='first_3']")); // TODO: 24.02.2022 hiçbir şey göndermeden cssValue sını aldım 
        // TODO: 24.02.2022 sendKeys yaptırmadan önce 
        System.out.println("click ten önce : " + name.getCssValue("border-color"));
        name.click();
        
        WebElement surName = driver.findElement(By.id("last_3"));
        surName.click();

        WebElement email= driver.findElement(By.id("input_4"));
        email.click();
        // TODO: 24.02.2022 surname ve email i tıkladıktan sonra renk değişimi oluyor.
        
        
        System.out.println("click'ten sonra = " + name.getCssValue("border-color"));
    }
}
