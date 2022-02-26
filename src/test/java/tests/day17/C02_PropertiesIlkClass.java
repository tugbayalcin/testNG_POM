package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PropertiesIlkClass
{
    @Test(groups = "regression")
    public void positiveLoginTesti(){
        //Hotel My Camp sitesine positive login testini POM'a uygun olarak yapiniz

        // https://www. hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

        // login butonuna bas
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.ilkLoginButonu.click();

        // test data username: manager
        hotelMyCampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));

        // test data password : Manager1!
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hotelMyCampPage.bekle(3); // yazdigimiz method sayesinde artik exception firlatmiyor ve 000 yazmak zorunda kalmiyoruz

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        hotelMyCampPage.loginButonu.click();
        Assert.assertTrue(hotelMyCampPage.basariliGirisYaziElementi.isDisplayed());


        Driver.closeDriver();
    }
}
