package com.gittigidiyor.SeleniumProject;

public class App {
    public static void main(String[] args) {
        Anasayfa anasayfa = new Anasayfa();
        anasayfa.sayfaninAcilmasi();
        anasayfa.girisSayfasi();
        anasayfa.girisYapmak();
        anasayfa.reklamKapatma();
        anasayfa.aramaYapmak();
        anasayfa.IkinciSayfa();
        anasayfa.rastgeleUrunSecimi();
        anasayfa.sepeteEkleme();
        anasayfa.sepetKontrol();
        anasayfa.arttirma();
        anasayfa.urunSilme();
    }
}