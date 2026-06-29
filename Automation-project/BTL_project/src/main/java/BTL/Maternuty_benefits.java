package BTL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Maternuty_benefits extends BtlBasePage {
    public Maternuty_benefits(WebDriver driver) {
        super(driver);
    }


    public String GetPage(String s) {

        String str = driver.findElement(By.className("active breadcrumbs-item")).getText();
        return str;
    }
    public String GetCurrentItem(){
        String current = driver.findElement(By.id("lblSearchTitle")).getText();
        return current;
    }
}
