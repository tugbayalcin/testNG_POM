package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// test ng kendi kendine raporlama yapamaiyor
// avenstach kulaniyoruz
// maven'a avenstacjk yazica extentReport cikiyor
// extentRReports olarak bilinir
// 2019 versiyonunu kullaniyoruz cunku yeni cikan 5 versiyonu duzgun calismiyor

public abstract class TestBaseRapor
{

    protected static ExtentReports extentReports; //extent report'a ilk atamayi yapar
    // raporlamayi baslatip bitirmek icin bu objeye ihtiyac duyariz
    // raporlamayi bbitirdigi anda flush() methodu calismaya baslar
    // bunu kagida yazilacaklar olarak dusun

    protected static ExtentTest extentTest; // test pass veya failed gibi bilgileri kaydeder. Ayrica ekran resmi icin de kullaniriz
    // bunu yap, yapildi   sunu yap, yapildi diyen obje
    protected static ExtentHtmlReporter extentHtmlReporter; // Html raporu duzenler
    // html formatinda bir form olusturur,
    // bunu da kagit olrak dusun

    // bu 3 obje bizim raporumuz icin lazim

    // Test işlemine başlamadan hemen önce (test methodundan önce değil, tüm test işleminden önce)
    @BeforeTest(alwaysRun = true) // alwaysRun : her zaman çalıştır.
    public void setUpTest() {
        extentReports = new ExtentReports();
        //rapor oluştuktan sonra raporunuz nereye eklensin istiyorsanız buraya yazıyorsunuz.
        // bu initialize ile raporlama baslatilmis olur !!!

        // ardindan raporumuzu nereye kaydetmek istedigimize karar vermeliyiz
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // date'i aldik ki rapor adimiz da unique olsun
        String filePath = System.getProperty("user.dir") + "/test-output/Rapor"+date+".html";
        // burada path'in user.dir olarak verilmesi dynamic olmasina ve her ilgisayarda calismasina imkan tanimis olur

        //oluşturmak istediğimiz raporu (html formatında) başlatıyoruz, filePath ile dosya yolunu belirliyoruz.
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        // bu initialize ile bu path'de bir dosya olusmus olur
        // bu dosyanin uzerinde asagidaki gibi bazi standart cumleler vardir ve kendimzie gore design edebiliriz
        extentReports.attachReporter(extentHtmlReporter);
        // İstediğiniz bilgileri buraya ekeyebiliyorsunuz.
        extentReports.setSystemInfo("Enviroment","QA");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser")); // chrome, firefox
        extentReports.setSystemInfo("Automation Engineer", "Tugba");
        extentHtmlReporter.config().setDocumentTitle("amazon Arama Testi");
        extentHtmlReporter.config().setReportName("amazon Arama Automation Reports");
        // buralari kendimize gore degistiririz
    }
    // Her test methodundan sonra eğer testte hata varsa, ekran görüntüsü alıp rapora ekliyor
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) { // eğer testin sonucu başarısızsa
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { // eğer test çalıştırılmadan geçilmezse
            extentTest.skip("Test Case is skipped: " + result.getName()); // Ignore olanlar
        }
        Driver.closeDriver();
        // after method ise her test methodundan sonra calisir
    }
    // Raporlandırmayı sonlandırmak icin
    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        extentReports.flush();
    }
    // test dedigimiz seyin level'i suit'in hemen altinda ve class'in ustundedir (package'in da ustunde)
    // yani methodşardan classlardan olusan genis bir kapsama alani olan daha komplex bir test yapisidir
    // smoke test, regression test gibi
    // butuuuun test ıvırım zıvırım calisti o zaman flush() ı calistirip cikip gidiyorum bitiyor dukkani kapatiyorum
}
