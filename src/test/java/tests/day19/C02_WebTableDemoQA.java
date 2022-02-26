package tests.day19;

import jdk.swing.interop.SwingInterOpUtils;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_WebTableDemoQA
{
    // Bir Class olusturun D19_WebtablesHomework
    //  1. “https://demoqa.com/webtables” sayfasina gidin
    //  2. Headers da bulunan department isimlerini yazdirin
    //  3. sutunun basligini yazdirin
    //  4. Tablodaki tum datalari yazdirin
    //  5. Tabloda kac cell (data) oldugunu yazdirin
    //  6. Tablodaki satir sayisini yazdirin
    //  7. Tablodaki sutun sayisini yazdirin
    //  8. Tablodaki 3.kolonu yazdirin
    //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

    @Test(groups = {"smoke, regression"})
    public void demoqaTest(){

        //  1. “https://demoqa.com/webtables” sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("DemoqaUrl"));
        DemoqaPage demoqaPage = new DemoqaPage();

        //  2. Headers da bulunan department isimlerini yazdirin
        //   normalde //thead//th olmaliydi ancak bu tablo htmltable ile degil class isimleri ile organize edilmis
        System.out.println("Baslik Satiri Elementi: " + demoqaPage.baslikSatiriElementi.getText());

        // ikinci yontem olarak basliklari bir Listeye koyablirm
        // basliklarWebElementListesi

        //  3. 3.sutunun basligini yazdirin
        System.out.println("3. sutun basligi: " + demoqaPage.basliklarWebelementiListesi.get(2).getText());

        //  4. Tablodaki tum datalari yazdirin
        System.out.println("============= TUM BODY =============");
        System.out.println(demoqaPage.tumBodyElementi.getText());

        //  5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("Tablodaki Data Sayisi: "+demoqaPage.tumDataWebElementList.size());

        //  6. Tablodaki satir sayisini yazdirin
        System.out.println("Tablodaki Satir Sayisi:" + demoqaPage.tumSatirlarWebElementList.size());

        //  7. Tablodaki sutun sayisini yazdirin
        // farkli yollardan hesaplanabilir ama biz hucreSayisi/saatirSayisi yapalim
        System.out.println("Tablodaki Sutun Sayisi:" +
                (demoqaPage.tumDataWebElementList.size()/demoqaPage.tumSatirlarWebElementList.size()));

        //  8. Tablodaki 3.kolonu yazdirin
        demoqaPage.sutunYazdir(3);

        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        demoqaPage.ismeGoreMaasYazdir("Kierra");

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        demoqaPage.hucreYazdir(2,3);

         Driver.closeDriver();

    }
}
