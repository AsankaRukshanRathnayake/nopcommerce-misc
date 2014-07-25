package nopcommerce.misc;

import nopcommerce.misc.utils.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

/**
 * Created by Sasikala on 23/07/2014.
 */
public class ManufacturersPage extends HomePage {

    public boolean isMaufacturePage(String manufacturer) {

        WaitUtils.pause(2);
        WebElement manufacturerTitle = driver.findElement(By.xpath("//*[@id='content-center']/div/div[1]/h1"));
        System.out.println( manufacturer);
        System.out.println( manufacturerTitle.getText()) ;
        System.out.println(manufacturer.equals(manufacturerTitle.getText()) );
        Assert.assertEquals(manufacturerTitle.getText(), manufacturer);
        return true;
    }

    public boolean isMaufactureListPage() {
        WebElement manufacturerList = driver.findElement(By.xpath("//*[@id='content-center']/div/div[1]/h1"));
        return manufacturerList.getText().equals("Manufacturer List");
    }
}
