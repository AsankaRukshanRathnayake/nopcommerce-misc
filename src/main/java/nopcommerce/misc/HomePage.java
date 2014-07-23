package nopcommerce.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 * User: sriramangajala
 * Date: 20/07/2014
 * Time: 21:37
 * To change this template use File | Settings | File Templates.
 */
public class HomePage extends abstractHeaderPage {

    public void gotoCatagory(String category) {
    }

    public void gotoRegisternewUser() {
        driver.findElement(By.linkText("Register")).click();
    }

    public void gotoLogin(){
        System.out.println("inside login");
    WebElement loginButton = driver.findElement(By.xpath("//div[@id='shopbar-account']/a/span[1]/span[2]"));
     loginButton.click();

    }

    public void viewAllManufactures(){

    };

    public void logout() {

        WebElement account_dropdown = driver.findElement(By.xpath("//*[@id='shopbar-account']/a/span[1]/span[2]/i"));
        account_dropdown.click();
        WebElement logout_link = driver.findElement(By.xpath("//*[@id='shopbar-account']/ul/li[6]/a"));
        logout_link.click();
        driver.getPageSource().contains("Log in");

    }

    public void select_first_manufacturer() {
    }

    public void select_viewall_manufacture() {
    }

    public void setLanguage(String deutsch) {

    }

    public  boolean verifyDuetschSettings() {
        return true;
    }

    public boolean verifyEnglishSettings() {
        return true;
    }

    public boolean verifyDollarSettings() {
        return true;
    }

    public boolean verifyEuroSettings() {
        return true;
    }
}
