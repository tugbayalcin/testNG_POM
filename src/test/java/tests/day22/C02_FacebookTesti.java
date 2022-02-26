package tests.day22;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_FacebookTesti extends TestBaseRapor
{
    FacebookPage facebookPage;

    @Test
    public void test01() {

        // adim 1: TestBaseRapor'u extend et
        // adim 2: extentTest'i initialize et
        extentTest = extentReports.createTest("facebook","Fake Isim Ile Girilemedigi Test Edildi");
        // adim 3: infolarini istedigin yerlere ekle


        // 1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com");
        extentTest.info("facebook Sayfasina Gidildi");
        facebookPage = new FacebookPage();

        // 2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        // ettik facebookPage'de


        // 3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker = new Faker();
        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());
        facebookPage.loginButonu.click();
        extentTest.info("facebook Giris Bilgileri Faker Ile Dolduruldu");

        // 4- Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girisYapilamadiYazisiElementi.isDisplayed());
        extentTest.pass("Girilemedigi Test Edildi");
        ReusableMethods.waitFor(1);
        // Driver.closeDriver();

    }
}
