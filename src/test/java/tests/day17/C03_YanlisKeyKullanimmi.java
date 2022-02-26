package tests.day17;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_YanlisKeyKullanimmi
{
    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCurl"));


        // eger key olarak girdigimiz String configuration.propertşies dosyasinda yoksa
        // ornegin HMCUrl yerine HMCurl yazarsak
        // configReader.getProperty() o dosyayi bulamaz
    }
}
