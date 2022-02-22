package Gun_06;

import Gun_03._01TryCatch;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.ArrayList;
import java.util.List;

public class _01Xpath extends BaseStaticDriver {
    public static void main(String[] args) {

        /**
         * https://www.saucedemo.com/  siteye git
         * Bütün ürünleri sepete ekle
         * Sepete git
         * Sepetteki ürünleri önceki ürünlerle kiyasla
         * dogruysa Checkout butonuna tikla
         * Cikan formu doldur
         * Continue butonuna tikla
         *Total fiyati kiyasla
         * Finish butonuna tikla
         * "THANK YOU FOR YOUR ORDER" yazisinin sayfada oldugunu onayla
         * Back Home basip bulundugu sayfanin url kontrol et "https://www.saucedemo.com/inventory.html"
         */

        _01TryCatch.logın("standard_user","secret_sauce");
        //button[@class='inventory_item_img']
        // todo button[text()='Add to cart']  ---text aldığımız zaman--tag name i yoksa

        // TODO: tagname i olmayan textlerden lokasyon bulmak istediğimde xpath kullanmak amaçlı
        // TODO: fakat eger dite farklı dil seçenekleri ile yapılmışsa testimiz sadece tek bir dil ile çalışır.

        List<WebElement> urunList1 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> list1 = new ArrayList<>();
        for (WebElement urun : urunList1) {
            list1.add(urun.getText());
        }
        System.out.println(list1);

        List<WebElement> urunPrice1 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        // TODO: 21.02.2022 web element için list oluşturduk 
        List<String> price1 = new ArrayList<>();
        // TODO: 21.02.2022 bu da ürünlerin fiyatları ve isimlerinin getText leri için arrayList
        for (WebElement price : urunPrice1) {
            price1.add(price.getText());
        }
        System.out.println(price1);
        
        List<WebElement> addToCart = driver.findElements(By.xpath("//button[text()='Add to cart']"));
        for (WebElement e : addToCart) {
            e.click();
        }
        WebElement sepet = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        sepet.click();



        List<WebElement> urunList2 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> list2 = elementToString(urunList2);

        List<WebElement> priceList2 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String> price2 = elementToString(priceList2);

        if(list1.size() == list2.size()){
            stringListKontrol(list1,list2);
        }else
            System.out.println("listenin uzunluğu eşit değil");
        System.out.println("*********************");

        if(price1.size()== price2.size()){
            stringListKontrol(price1,price2);
        }else
            System.out.println("listenin uzunluğu eşit değil");

        WebElement checkOut = driver.findElement(By.xpath("//button[@data-test='checkout']"));
        checkOut.click();
        WebElement firstName = driver.findElement(By.xpath("//input[starts-with(@data-test,'first')]"));
        firstName.sendKeys("Kraft");
        WebElement lastName = driver.findElement(By.xpath("//input[starts-with(@data-test,'last')]"));
        lastName.sendKeys("Techno");
        WebElement zip = driver.findElement(By.xpath("//input[contains(@data-test,'postal')]"));
        zip.sendKeys("12345");
        WebElement next = driver.findElement(By.xpath("//input[@data-test='continue']"));
        next.click();


       WebElement totalPrice = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));////button[contains(text(),'Finis')]
        Double sumPrice = 0.0;
        for (String s : price2) {
            sumPrice+=stringToDouble(s);
        }
        String sumText = String.valueOf(sumPrice);
        Assert.assertTrue(totalPrice.getText().contains(sumText));
        if(totalPrice.getText().contains(sumText)){
            System.out.println("fiyat toplamı doğru");
        }

        WebElement finish = driver.findElement(By.xpath("//button[contains(text(),'Finis')]"));
        finish.click();

    }

    public static List<String> elementToString(List<WebElement> list){
        List<String> textList = new ArrayList<>();
        for (WebElement element : list) {
            textList.add(element.getText());
        }
        return textList;
    }
     public static void stringListKontrol (List<String> list1, List<String> list2) {
         for (int i = 0; i < list1.size(); i++) {
             if (list1.get(i).equals(list2.get(i))) {
                 System.out.println(list1.get(i) + " ürün sepette var...");
             }
             //   Assert.assertEquals("bilgiler eşleşmedi",list1.get(i),list2.get(i));
         }
     }
     public static double stringToDouble(String text){
        String rakamText = text.replaceAll("[$]","");
        Double sayi = Double.parseDouble(rakamText);
        return sayi;
     }
}
