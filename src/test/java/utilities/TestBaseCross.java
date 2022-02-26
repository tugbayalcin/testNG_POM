package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBaseCross
{
    public WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional String browser){ // optional notasyonu ile parameters notasyonu koordineli calisir
        // get driver icine browserımı yazmam lazim ama artik benim 1 tane yok
        // birden cok browser'i alabilmem icin yukariya @parameters notasyonunu eklemem, bunu da kullanabilmek icin
        // mmethoduma @Optional notasyonu ile method parametresi olarak yazmam ve en sonunda da get driver icine browser
        // yazmam gerek, artik get driver icindeki browser parametresi beni birden fazla driver'a goturebilecek

        driver=CrossDriver.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterMethod
    public void teardown(){
        CrossDriver.closeDriver();
    }
}
