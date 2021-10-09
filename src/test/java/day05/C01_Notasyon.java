package day05;

import org.junit.Test;

public class C01_Notasyon {
//javadaki gibi selenyumda da methodlar olusturabiliriz
    public void ilkTestMethodu() {

        System.out.println("ilk test methodu");
    }

//JUnit ile notasyon kullanarak siradan methodlari test methoduna dönüstürebilirz
  //  bir test methodu bagimsiz olarak calisabilen test yapmamiza olanak verir
    //
@Test
    public void notasyonluIlkTestMethodu() {

        System.out.println(" NOTASYONLU ilk test methodu");
    }












}
