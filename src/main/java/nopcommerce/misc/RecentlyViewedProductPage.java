package nopcommerce.misc;

import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by Sasikala on 21/07/2014.
 */
public class RecentlyViewedProductPage extends abstractPage{
    HomePage homePage=new HomePage();
public void verifyViewedProductShownInRecentlyViewedProductsPage()
{
    homePage.navigateToRecentlyviewedpage();
    Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().contains("Autos der Superlative"));

}
}

