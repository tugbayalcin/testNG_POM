package tests.day17;

import org.testng.annotations.Test;
import utilities.Driver;

import javax.swing.*;

public class C04_SingletonPattern
{
    @Test
    public void test01(){
        // singleton pattern: bir class'tan birden fazla obje uretilmesine izin vermeyen pattern olarak kabul gormustur
        // biz driver class'ini driver uretmek uzere kullaniyoruz
        // ancak driver class'inda driver isminde bir instance variable da var
        // ve biz obje ureterek bu instance driver'a ulasabiliriz


        // singleton pattern kabul gormus ir patterndir
        // amac bir class'tan obje uretilmesini engekllemektir
        // bunun icin singleton pattern ile koruyacagimiz class'ta parametresiz bir constructor olusturur ve
        // bu constructor'i private yapariz
    }
}
