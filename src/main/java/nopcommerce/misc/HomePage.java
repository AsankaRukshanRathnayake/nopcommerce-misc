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

    public void navigateToBooks() {
        driver.findElement(By.linkText("Books")).click();
    }

    public void navigatetologinpage() {
        driver.findElement(By.xpath(".//*[@id='shopbar-account']/a/span[1]/span[2]")).click();

    }

    public void navigateToRecentlyviewedpage() {
        driver.findElement(By.linkText("Recently viewed products")).click();
    }

    public void viewProducts() {
        //Viewing a product from Books Category
        driver.findElement(By.xpath(".//*[@id='content-center']/div/div[2]/div[3]/div/div/div[1]/div[1]/article/figure/a/img")).click();
        driver.findElement(By.xpath(".//*[@id='logobar']/a/img")).click();
        driver.findElement(By.xpath(".//*[@id='content-left']/div[4]/div[2]/ul/li[5]/a")).click();
    }
}
