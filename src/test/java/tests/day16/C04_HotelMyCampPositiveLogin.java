package tests.day16;

import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C04_HotelMyCampPositiveLogin
{
    HotelMyCampPage hotelMyCampPage;
    @Test(groups = {"miniRegression", "smoke"})
    public void positiveLoginTest(){
        // 1 ) Bir Class olustur : PositiveTest
        // 2) Bir test method olustur positiveLoginTest()
        //        https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");

        //        login butonuna bas
        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.ilkLoginButonu.click();

        //    test data username: manager
        hotelMyCampPage.usernameBox.sendKeys("manager");

        //    test data password : Manager1!
        hotelMyCampPage.passwordBox.sendKeys("Manager1!");

        //    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        hotelMyCampPage.loginButonu.click();
    }
}
