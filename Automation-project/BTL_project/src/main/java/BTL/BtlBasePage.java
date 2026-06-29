package BTL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BtlBasePage extends BaseTest {

    public BtlBasePage(WebDriver driver) {
        super(driver);
    }
    public void Nuvigate(String main,String sub){
        driver.findElement(By.xpath("//a[text()='" + main + "']")).click();
        driver.findElement(By.xpath("//a[text()='" + sub + "']")).click();
    }
    public void Search(String s){
        driver.findElement(By.id("TopQuestions")).sendKeys(s);
        driver.findElement(By.id("ctl00_SiteHeader_reserve_btnSearch")).click();
    }
}
