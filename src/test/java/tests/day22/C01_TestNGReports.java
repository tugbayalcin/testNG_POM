package tests.day22;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class C01_TestNGReports extends TestBaseRapor
{
    @Test
    public void windowHandleReusableTest() throws IOException {
        // rapor istiyorsam yapacagim ilk sey testBaseReports'da lazim olacak dedigimiz 3 objeden deger atamadigimiz
        // extentTest objesine deger atamaliyiz
        // extentTest istedigimiz adimlardan sonra raporumuza bilgilendirme mesajlari yazmamiza olanak tanir
        extentTest=extentReports.createTest("Window Handle", "Title Ile Ikinci Sayfaya Gecis Yapildigi Test Edildi");
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        // aciklama icin 2 yol var 1. info 2.pass, genellikle buralara info, assertlere pass yazilir
        extentTest.info("herokuapp Sayfasina Gidildi");
        //extentTest.pass()
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        extentTest.info("Yeni Window Linkine Tiklandi");

        ReusableMethods.switchToWindow("New Window");
        extentTest.info("Reusable Method Kullanilarak Acilan Ikinci Sayfaya Gecildi");

        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
        extentTest.pass("Title'in Beklenen Deger Ile Ayni Oldugu Test Edildi");

        // ReusableMethods.getScreenshot("WindowSwitch");
        // Driver.closeDriver();

        // bu iki satita gerek yok cunku after method bu ikisini de iceriyor

        // calistirinca rapor path verdigimiz yere geliyor ama html olarak geliyor ve bu sekilde okuyabilmemiz
        // mumkun degil, bu yuzden sag click ile browser'da ac diyerek inceleyebiliriz

        // test ng reports pek de tercih edilen bir sey degildir

    }
}
