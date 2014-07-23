package nopcommerce.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends abstractHeaderPage {

    public String select_first_manufacturer() {

        WebElement firstmanufacturer = driver.findElement(By.xpath("//*[@id='content-left']/div[2]/div[2]/ul/li[1]/a"));
        firstmanufacturer.click();
        return  firstmanufacturer.getText();
    }

    public void select_viewall_manufacture(){
        WebElement allmanufacture = driver.findElement(By.xpath("//*[@id='content-left']/div[2]/div[2]/div/a"));
        allmanufacture.click();

    }
}
