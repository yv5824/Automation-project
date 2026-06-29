package test.java;

import BTL.BachurYeshiva;
import BTL.BtlBasePage;
import BTL.BtlContributions;
import BTL.Maternuty_benefits;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class btlTest {

    protected WebDriver driver;
    @BeforeEach
    public void BeforeEach() {
        // הגדרת הדרייבר (למשל כרום)
        WebDriverManager.chromedriver().setup(); // אם את משתמשת ב-WebDriverManager
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.btl.gov.il"); // כניסה לאתר
    }
    @Test
    public void testSearchMaternityBenefits() {
        // 1. הגדרת מחרוזת החיפוש כפי שנדרש
        String s = "חישוב סכום דמי לידה ליום";
        BtlBasePage bbp=new BtlBasePage(driver);
        bbp.Search(s);
        String expectedTitle = "תוצאות חישוב עבור חישוב סכום דמי לידה ליום";
        Maternuty_benefits mb=new Maternuty_benefits(driver);
        String current =mb.GetCurrentItem();
        Assertions.assertEquals(expectedTitle, current, "הכותרת בדף התוצאות אינה תואמת לצפי!");
    }
    @Test
    public void calculatingForBachurTeshiva(){
        BtlBasePage bbp=new BtlBasePage(driver);
        String s1="דמי ביטוח";
        String s2=" דמי ביטוח לאומי";
        bbp.Nuvigate(s1,s2);

        BtlContributions bc=new BtlContributions(driver);
        bc.GotoCalculator();

        String s3="חישוב דמי ביטוח עבור עצמאי, תלמיד, שוהה בחוץ לארץ ומי שלא עובד";
        BachurYeshiva by=new BachurYeshiva(driver);
        String  current=by.GetPage();
        Assertions.assertEquals(s3,current,"הכותרת בדף התוצאות אינה תואמת לצפי!");
        by.FirstStep();

        //בדיקה שהגענו לשלב השני
        String s4="צעד שני";
        String s5=by.AssertStep();
        Assertions.assertEquals(s4,s5,"הכותרת בדף התוצאות אינה תואמת לצפי!");

        //ביצוע השלב השני
        by.SecondStep();

        String s6=by.AssertStep();
        String s7="סיום";
        Assertions.assertEquals(s7,s6,"הכותרת בדף התוצאות אינה תואמת לצפי!");

        String sum="171";
        String sum2=by.SumEnd();
        Assertions.assertEquals(sum,sum2,"הכותרת בדף התוצאות אינה תואמת לצפי!");

    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
