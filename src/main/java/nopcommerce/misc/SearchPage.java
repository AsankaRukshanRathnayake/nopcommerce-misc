package nopcommerce.misc;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchPage extends BaseClass {

    public SearchPage(WebDriver driver) {

        super(driver);
    }


    public void searchWithProdName(String item){

        driver.findElement(By.id("Q")).sendKeys(item);
        driver.findElement(By.xpath(".//*[@id='content-center']/div/div[2]/form/div[1]/div/div[4]/div/button")).click();
    }

}
