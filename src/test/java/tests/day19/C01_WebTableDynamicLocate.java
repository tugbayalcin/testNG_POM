package tests.day19;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C01_WebTableDynamicLocate
{
    // 3 test methodu olusturalim
    // 1. method satir numarasi verdigimde bana o satirdaki datalari yazdirsin
    // 2. method satir no ve data numarasi girdigimde verdigim datayi yazdirsin
    // 3. method sutun numarasi verdigimde bana tum sutunu yazdirsin

    HMCWebTablePage hmcWebTablePage;
    HotelMyCampPage hotelMyCampPage;

    @Test
    public void satirYazdir(){
        // 1. method satir numarasi verdigimde bana o satirdaki datalari yazdirsin
        // 2. satiri yazdir desek locate su sekilde olur --> //tbody//tr[2]
        // 7. satiri yazdir desek locate su sekilde olur --> //tbody//tr[7]

        hmcWebTablePage = new HMCWebTablePage();
        hotelMyCampPage = new HotelMyCampPage();

        hotelMyCampPage.girisYap();

        WebElement ucuncuSatirElementi = hmcWebTablePage.satirGetir(3);
        System.out.println(ucuncuSatirElementi.getText());

        Driver.closeDriver();
    }

    @Test
    public void hucreGetirTesti(){
        // 2. method satir no ve data numarasi girdigimde verdigim datayi yazdirsin
        hmcWebTablePage = new HMCWebTablePage();
        hotelMyCampPage = new HotelMyCampPage();

        hotelMyCampPage.girisYap();

        // 2. satirin 4. datasinin locate'i --> //tbody//tr[2]//td[4]
        // 4. satirin 5. datasinin locate'i --> //tbody//tr[4]//td[5]
        System.out.println("Girilen Hucredeki Data: "+hmcWebTablePage.hucreWebElementGetir(5, 3));

        Driver.closeDriver();
    }

    @Test
    public void sutunYazdirTesti(){
        // 3. method sutun numarasi verdigimde bana tum sutunu yazdirsin

        hmcWebTablePage = new HMCWebTablePage();
        hotelMyCampPage = new HotelMyCampPage();

        hotelMyCampPage.girisYap();

        hmcWebTablePage.sutunYazdir(4);

        Driver.closeDriver();

    }
}
