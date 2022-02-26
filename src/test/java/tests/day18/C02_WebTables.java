package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelMyCampPage;
import utilities.Driver;

import java.util.List;

public class C02_WebTables
{
    // ● Bir class oluşturun : C02_WebTables
    //● login( ) metodun oluşturun ve oturum açın.
    //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
    //            ○ Username : manager
    //            ○ Password : Manager1!
    //● table( ) metodu oluşturun
    //            ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    //            ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    //● printRows( ) metodu oluşturun //tr
    //            ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    //            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    //            ○ 4.satirdaki(row) elementleri konsolda yazdırın.

    HMCWebTablePage hmcWebTablePage;

    HotelMyCampPage hotelMyCampPage;
    @Test
    public void loginTesti(){
        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.girisYap();

    }

    @Test
    public void table(){
        // header kisminda 1. satir ve altindaki datalari locate edelim
        hmcWebTablePage = new HMCWebTablePage();
        List<WebElement> headerDataList = hmcWebTablePage.headerBirinciSatirDatalar;
        System.out.println("Tablodaki Sutun Sayisi: " + headerDataList.size());

        System.out.println(hmcWebTablePage.tumBodyWeElementi.getText());
        // eger body'yi tek bir webElement olarak locate edersek icindeki tum datalari getText() ile yazdirabiliriz
        // ancak bu durumda, bu elementler ayri ayri degil body'nin icindeki tek bir stringin parcalari olurlar
        // dolayisiyla bu elementlere tek tek ulasmamiz mumkun olmaz
        // sadece contains methodu ile body'de olup olmadiklarini test edebiliriz
        // eger her bir datayi ayri ayri almak istersek o zaman //tbody//td seklinde locte edip bir liste atabiliriz
        //
        List<WebElement> bodyTumDataList = hmcWebTablePage.tumBodyDatalariList;

        System.out.println("Body'deki Data Sayisi: " + bodyTumDataList.size());

    }

    @Test (dependsOnMethods = "loginTesti")
    public void printRows(){

        //          ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        // //tbody//tr
        hmcWebTablePage=new HMCWebTablePage();
        System.out.println(hmcWebTablePage.satirlarListesi.size());
        //          ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        List <WebElement> satirlarWebelementListesi=hmcWebTablePage.satirlarListesi;
        for (WebElement each: satirlarWebelementListesi
        ) {
            System.out.println(each.getText());
        }
        //          ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("4.satir : "+satirlarWebelementListesi.get(3).getText());

        Driver.closeDriver();
    }
}
