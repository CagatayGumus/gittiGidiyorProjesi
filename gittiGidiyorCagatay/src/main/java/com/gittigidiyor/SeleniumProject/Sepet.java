package com.gittigidiyor.SeleniumProject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sepet {
    WebDriver webDriver;

    public Sepet(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void sepeteEkleme(){  //Seçilen rastgele ürünü sepete ekler.
        try {
            webDriver.findElement(By.id("add-to-basket")).click();
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sepetKontrol(){ // Ürün sayfasındaki fiyat ile sepette yer alan ürünün fiyatını karşılaştırı
        try {
            webDriver.findElement(By.xpath("//input[start-with*[@class='header-cart-hidden-link'] or @type='text']")).click();
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void arttirma(){ // Sepetteki ürünün sayısını 2 butonuna tıklayarak 2 ye çıkarır
        try {
            webDriver.findElement(By.className("amount")).click();
            webDriver.findElement(By.xpath("//*[@value='2']")).click();
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void urunSilme(){ // sepettek ürünü sil butonuna tıklayarak siler ve ürünün silinip silinmediğini kontrol eder
        try {
            webDriver.findElement(By.id("695373966")).click();
            Thread.sleep(2000);
            Assert.assertNotNull(By.xpath("//*[@title='Sil']"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
