package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverIlkTest
{

    /*
        * Driver class'i sayesinde bizim eski kucuk d ile olan driver'imiz oldu.
        * Artik driver'a ihtiyac varsa Driver.getDriver() yazacagiz
        *
     */

    // pom da driver classindaki yapilar static methodlar ile olusturulur
    // page sayfalarindaki yapilar ise static olmayan methodlarla yazilir ve classtan obje ureterek kullanilir
    // extend yoktur, bu karar bize birakilmamistir
    // modelin kurallari bunlardir
    // POM'da farkli class'lara farkli sekilde erisim yolu belirlenmistir
    // Driver Class'i icin static yontemi kullanilir
    // Page Class'lari icin ise obje uzerinden kullanilmasi tercih edilmistir
    // consept bu sekildedir

    @Test
    public void test01(){
        // amazona gidelim
        Driver.getDriver().get("https://www.amazon.com/");


        // amazon'a gittigimizi test edelim
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains("Amazon"));

        Driver.closeDriver();

        //Driver.getDriver method'u her calistiginda
        //driver=new ChromeDriver(); komutundan dolayi yeni bir driver olusturuyor
        //Biz Driver class'dan getDriver'i calsitirdigimizda new atamasi olsun
        //sonraki calistirmalarda atama olmasin istiyoruz
        //bunun icin driver= new ChromeDriver(); satiri bir if blogu iicine alacagiz
    }

    @Test
    public void test02(){
        // bestbuy anasayfasina gidelim
        Driver.getDriver().get("https://www.bestbuy.com");

        // bestbuy'a gittigimizi test edelim
        String url = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("best"));

        Driver.closeDriver();

    }
}
