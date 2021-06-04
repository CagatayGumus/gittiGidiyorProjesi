package com.gittigidiyor.SeleniumProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class Anasayfa {
    Urun urun;
    Sepet sepet;
    WebDriver webDriver;
    public void sayfaninAcilmasi(){  // gittigidiyor.com sayfası açılır ve sayfanın açılıp açılmadığı kontrol edilir.
        System.setProperty("webdriver.chrome.driver","C:/Users/Cagatay/Selenium/ChromeDriver/chromedriver.exe");
        webDriver = new ChromeDriver();
        urun = new Urun(webDriver);
        sepet = new Sepet(webDriver);
        webDriver.get("https://www.gittigidiyor.com/");
        webDriver.manage().window().maximize();
        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.gittigidiyor.com/");
    }

    public void girisSayfasi(){ // giris yapmak içingiris sayfasına tıklanır
        try {
            Thread.sleep(1000);
            webDriver.findElement(By.xpath("//*[@class='gekhq4-0 koEZsC'}")).click();
            webDriver.findElement(By.xpath("//*[@class='gekhq4-4 egoSnI']")).click();
            Thread.sleep(1000);
            webDriver.findElement(By.xpath("//*[@class='sc-12t95ss-3 fDarBX']")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void girisYapmak(){ // giris sayfasında kullanıcı adı ile şifre alanı doldurulur ve giriş butonuna tıklanır
        try {
            webDriver.findElement(By.name("kullanici")).sendKeys("ahmetcagataygumus52@gmail.com");
            webDriver.findElement(By.name("sifre")).sendKeys("cagatay993.");
            webDriver.findElement(By.xpath("//input[@value='Giriş Yap' and //input[@name='pass']]")).click();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.gittigidiyor.com/");
    }

    public void reklamKapatma(){ // 2. sayfaya geçmeden önce daha 1. sayfadayken karşımıza bi reklam sekmesi açılıyor. Bu reklamın kapatılmasını sağlar
        try{
            webDriver.findElement(By.xpath("//*[contains(@class,'tyj39b-3')]")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void aramaYapmak(){ // aramaYapma methodunu çağırır
        urun.aramaYapma();
    }


    public void IkinciSayfa(){ // 1. sayfanın sonuna inip reklam sekmesi kapatıldıktan sonra 2. sayfaya tıklanır
        try {
            webDriver.findElement(By.linkText("2")).click();
            Thread.sleep(2000);
            Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int rastgeleUrunSecimi(){ // 2. sayfadaki ürünler arasından Random methodu ile rastgele seçim yapılır
        List<WebElement> urunler;
        try {
            urunler  = webDriver.findElements(By.xpath("//ul[@class='catalog-view clearfix products-container']/li[1]/a"));
            Thread.sleep(2000);
            Random random = new Random();
            int rastgeleUrun  = random.nextInt(urunler.size());
            urunler.get(rastgeleUrunSecimi()).click();
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return 0;
    }

    public void sepeteEkleme(){ // sepeteEkleme methodunu çağırır
        sepet.sepeteEkleme();
    }

    public void sepetKontrol(){ // sepetKontrol methodunu çağırır
        sepet.sepetKontrol();
    }

    public void arttirma(){ // arttirma methodunu çağırır
        sepet.arttirma();
    }

    public void urunSilme(){ // urunSilme methodunu çağırır
        sepet.urunSilme();
    }

}
