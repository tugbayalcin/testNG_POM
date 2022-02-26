package tests.day16;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_FacebookLogin
{

    // test class'indaki hedef, manuel bir sey girmemektir !!!!!! her sey bir yerlerden gelmeli
    FacebookPage facebookPage;

    @Test(groups = {"miniRegression, regression"})
    public void test01() throws InterruptedException {
        // 1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com");
        facebookPage = new FacebookPage();

        // 2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
           // ettik facebookPage'de


        // 3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker = new Faker();
        Thread.sleep(3000);
        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());
        facebookPage.loginButonu.click();

        // 4- Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girisYapilamadiYazisiElementi.isDisplayed());
        Thread.sleep(2000);
        Driver.closeDriver();
    }

}
