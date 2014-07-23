package nopcommerce.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Sasikala on 21/07/2014.
 */
public class MyAccountPage extends abstractHeaderPage{
    public void gotoAccountPage() {
        System.out.println("Inside gotoaccount");
        WebElement myaccount =  driver.findElement(By.xpath("//*[@id='shopbar-account']/a"));
        //span[1]/span[2]
        myaccount.click();
        System.out.println("Inside gotoaccount");
        WebElement myaccountlink = driver.findElement(By.xpath("//*[@id='shopbar-account']/ul/li[1]/a"));
        myaccountlink.click();
    }
}
