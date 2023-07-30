package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists {
    @Test
    public void test01() {
        /*
            Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
        kontrol etmek varlığını doğrulamak için yada bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulayabilmek
        için;
            Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
        dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu)
        Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
        assign ederiz.

        NOT:
            Windows10 sürümlerinden önceki sürümler için pratik olarak dosya yolu almak istersek
            yolunu almak istediğimiz dosyanun üzerine gelip shift+sağKlik tusuna basarak yol olarak kopyala
            seçeneği ile dosya yolunu kopyalayabiliriz.
         */
        String dosyaYolu = "C:/Users/lenovo/Desktop/API Homework.docx";
        System.out.println(Files.exists(Paths.get(dosyaYolu))); //-->Dosya varsa True yoksa False döner
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test02() {
        String dosyaYolu ="C:/Users/lenovo/Desktop/Git-Github Komutları.docx";
        //--> "C" den once ve en sondaki çift tırnaktan önce /" olmayacak
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test03() throws InterruptedException {
        /*
            Bir server'da farkli işletim sistemleri ile aynı anda dosya varlığını test etmek istediğimiz zaman,
        daha dinamik olması açısından System.getProperty("os.name") bu şekilde işletim sistemi alır
        her işletim sistemin kullanıcı yolu farklı olacağından System.getProperty("user.home")
        bilgisayarımızdaki kullanıcı yolunu bu şekilde String bir değişkene farklıYol ismiyle System.getProperty("user.home")
        atayarak herseferinde farklı yolları almayla uğraşmamış oluruz. Dosya diyelimki masaüstünde ve her işletim
        sisteminde bize aynı yolu vereceği için bunuda ortakYol olarak bir String'e assign ederiz
         */
        //-->Dosya yolumuz : "C:/Users/lenovo/Desktop/Git-Github Komutları.docx"
        String farklıYol= "";
        String işletimSistemiAdı = System.getProperty("os.name");//-->İşletim sistemimizin adını verir
        System.out.println(işletimSistemiAdı);
        System.out.println(System.getProperty("user.home")); //-->Bilgisayarımızdaki kullanıcı yolunu verir
        if (işletimSistemiAdı.contains("Win")){
            farklıYol = System.getProperty("user.home"); //-->Windows 10/--> C:/Users/Lenovo
        } else if (işletimSistemiAdı.contains("mac")) {
            farklıYol = "/Users/aycapolatkamali"; //-->Mac işletim sistemi yolu
        }

        String ortakYol = "/Desktop/Git-Github Komutları.docx";
        String dosyaYolu = farklıYol+ortakYol;
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        try {
            Files.delete(Paths.get(dosyaYolu));//-->Bu şekilde belirtmiş olduğumuz dosyayı sileriz
        } catch (IOException e) {
            System.out.println("Dosya bulunamadı");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));//-->Sildiğimiz için assertFalse kullandık

        Thread.sleep(3000);
        //Sildiğimiz dosya isminde yeni bir dosya oluşturalım
        try {
            Files.createFile(Paths.get(dosyaYolu));//-->Belirtmiş olduğumuz dosyayı oluşturduk
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
            Her seferinde test ettiğimiz sayfada download işlemi yapılıyorsa gereksiz dosya kalabalığını önlemek için
        yukardaki delete işlemini kullanabiliriz
         */
    }

    @Test
    public void test04() {
         /*
            Yukarıdaki methodlarda bilgisayarımızdaki dosya yolunun varlığını Files.exists()methoduyla test etmiştik
        Aynı işlemi aşağıdaki örnekteki gibi File class'ından obje oluşturarak da yapabiliriz.
         */
        String dosyaYolu = "C:/Users/lenovo/Desktop/Git-Github Komutları.docx";
        File file = new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
    }
}
