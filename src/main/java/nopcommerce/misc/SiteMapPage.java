package nopcommerce.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by PRATHYU on 24/07/2014.
 */
public class SiteMapPage extends BaseClass {
    public SiteMapPage(WebDriver driver) {
        super(driver);
    }

    public void siteMapSearchByCategory(String name){

        driver.findElement(By.linkText(name)).click();
    }

    public void siteMapSearchByManufacture(String ManufactureName){

        driver.findElement(By.linkText(ManufactureName)).click();
    }
}
