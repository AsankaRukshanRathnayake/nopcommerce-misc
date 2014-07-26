package nopcommerce.misc.utils;

import nopcommerce.misc.HomePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by SQL2008DB on 26/07/2014.
 */


    public class PopulartagsPage extends HomePage {

        public boolean isPopulartagsPage(String populartags) {

            WaitUtils.pause(2);
            WebElement populartagsTitle = driver.findElement(By.xpath("//*[@id='content-left']/div[3]/div[1]"));
            System.out.println( populartags);
            System.out.println( populartagsTitle.getText()) ;
            System.out.println(populartags.equals(populartagsTitle.getText()) );
            Assert.assertEquals(populartagsTitle.getText(), populartags);
            return true;
        }

        public boolean isPopulartagsListPage() {
            WebElement PopulartagsList = driver.findElement(By.xpath(".//*[@id='content-center']/div/div[1]/h1"));
            return PopulartagsList.getText().equals("All product tags");
        }
    }





