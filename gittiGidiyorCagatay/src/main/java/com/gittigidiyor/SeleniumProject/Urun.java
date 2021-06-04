package com.gittigidiyor.SeleniumProject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Urun {
    WebDriver webDriver;
    public Urun(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void aramaYapma() {    // Arama kısmına tıklanır ve bilgisayar kelimesi yazılır. Sonrasında BUL butonuna tıklanır.
        try {
            String urun= "bilgisayar";
            webDriver.findElement(By.xpath("//input[@name='k']")).sendKeys(urun);
            webDriver.findElement(By.xpath("//*[@data-cy='search-find-button']")).click();
            Thread.sleep(2500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
