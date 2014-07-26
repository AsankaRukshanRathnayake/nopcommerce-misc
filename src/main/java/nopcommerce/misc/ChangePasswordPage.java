package nopcommerce.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by User on 21/07/2014.
 */
public class ChangePasswordPage extends abstractHeaderPage {

    public void updatepassword(String oldpassword, String newpassword, String confirmpassword) {

        WebElement oldpass = driver.findElement(By.id("oldpassword"));
        oldpass.clear();
        oldpass.sendKeys(oldpassword);
        WebElement newpass = driver.findElement(By.id("newpassword"));
        newpass.clear();
        newpass.sendKeys(newpassword);
        WebElement confpass = driver.findElement(By.id("confirmpassword"));
        confpass.clear();
        confpass.sendKeys(confirmpassword);
    }

    public void savedetails() {
        WebElement changepasswordButton = driver.findElement(By.xpath("//div[4]/div/button"));
        changepasswordButton.click();
    }

    public static boolean ispasswordchanged() {
        WebElement passchange=driver.findElement(By.xpath("//div/div[2]/div"));
        return passchange.getText().equals("change password");
    }
}




