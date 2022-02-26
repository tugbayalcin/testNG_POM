package tests.day16;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonMainPage;
import utilities.Driver;

public class C02_PageIlkClass
{
    // POM'da farkli class'lara farkli sekilde erisim yolu belirlenmistir
    // Driver Class'i icin static yontemi kullanilir
    // Page Class'lari icin ise obje uzerinden kullanilmasi tercih edilmistir
    // consept bu sekildedir


    @Test
    public void test01(){
        // Amazon'a gidelim
        Driver.getDriver().get("https://www.amazon.com");

        // arama kutusuna Nutella yazip aratalim
        AmazonMainPage amazonMainPage = new AmazonMainPage();
        amazonMainPage.amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER);


        // arama sonuclarinin Nutella icerdigini test edelim
        String actualSonucStr = amazonMainPage.sonucYazisiElementi.getText();
        Assert.assertTrue(actualSonucStr.contains("Nutella"));
    }

    // grouplar farkli paketlerde de olabilir ayni pakette de olabilir sikinti yok
    @Test(groups = {"miniRegression, smoke"})
    public void test02(){
        // amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");
        //java icin arama yapalim
        AmazonMainPage amazonPage=new AmazonMainPage();
        amazonPage.amazonAramaKutusu.sendKeys("java"+Keys.ENTER);
        // sonucun java icerdigini test edelim
        String sonucYazisiStr=amazonPage.sonucYazisiElementi.getText();

        Assert.assertTrue(sonucYazisiStr.contains("java"));

        Driver.closeDriver();
    }
}
