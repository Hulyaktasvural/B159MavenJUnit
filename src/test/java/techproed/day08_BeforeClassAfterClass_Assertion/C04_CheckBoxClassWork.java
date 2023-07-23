package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxClassWork {
    /*
    Verilen web sayfasına gidin.
    https://the-internet.herokuapp.com/checkboxes
    Checkbox1 ve checkbox2 elementlerini locate edin.
    Checkbox1 seçili değilse onay kutusunu tıklayın
    Checkbox2 seçili değilse onay kutusunu tıklayın
     */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void checkBox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement chechBox1 = driver.findElement(By.xpath("(//input)[1]"));
        WebElement chechBox2 = driver.findElement(By.xpath("(//input)[2]"));
        Thread.sleep(2000);
        // Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!chechBox1.isSelected()){ //seçili değilse
            chechBox1.click();  //checkBox'ı click yap
        }
        Thread.sleep(2000);
        //Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!chechBox2.isSelected()){ //seçili değilse
            chechBox2.click();  //checkBox'ı click yap
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
