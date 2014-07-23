package nopcommerce.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Sasikala on 23/07/2014.
 */
public class CustomerInfoPage extends RegisterUserPage{

    public boolean updateUserInfo(String[] customerInfo) {
        enterUserDetails(customerInfo);
        savedetails();
        return true;
    }

    public void savedetails() {
        WebElement saveButton = driver.findElement(By.name("save-info-button"));
        saveButton.click();
    }
}
