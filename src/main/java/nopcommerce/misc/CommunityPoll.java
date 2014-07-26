package nopcommerce.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Sasikala on 21/07/2014.
 */
public class CommunityPoll extends abstractHeaderPage {
    public void CommunityPollPage() {
        WebElement commpoll = driver.findElement(By.id("pollanswers-1"));
        commpoll.click();
    }
    public static boolean Polldone() {
        return false;
    }
}
