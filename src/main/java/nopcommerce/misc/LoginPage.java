package nopcommerce.misc;
import nopcommerce.misc.utils.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends abstractHeaderPage{

    public void gotoRegisternewUser() {
        driver.findElement(By.linkText("Register")).click();
    }
    public void loginAsConsumer(String username, String password) {

        {
            WebElement userName = driver.findElement(By.id("Username"));
            userName.sendKeys(username);
            WebElement passWord = driver.findElement(By.id("Password"));
            passWord.sendKeys(password);
            WebElement submitButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
            submitButton.click();
            WaitUtils.pause(5);
//        if(!isUserLoggedin(admin))
//        throw new RuntimeException("User is not logged in");

        }

    }
}
