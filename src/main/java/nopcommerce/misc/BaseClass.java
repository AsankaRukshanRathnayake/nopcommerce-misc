package nopcommerce.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;



public class BaseClass {


    WebDriver driver;

    public BaseClass(WebDriver driver) {

        this.driver = driver;
    }


    public void url(){

        driver.get("http://frontend.smartstore.net/en/");
        driver.manage().window().maximize();
    }


    public void loginAttempt(String name, String password){
        driver.get("http://frontend.smartstore.net/en/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("Username")).sendKeys(name);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.cssSelector(".btn.login-button")).click();
    }


    public void logout(){
        driver.findElement(By.xpath(".//*[@id='shopbar-account']/a/span[1]/span[2]")).click();
        //driver.findElement(By.xpath(".//*[@id='shopbar-account']/ul/li[6]/a")).click();

    }


    public void goToMyaccount(){
        driver.findElement(By.xpath(".//*[@id='shopbar-account']/a/span[1]/span[2]")).click();
        driver.findElement(By.xpath(".//*[@id='shopbar-account']/ul/li[1]/a")).click();
    }

    public void goToAvatarPage(){
        goToMyaccount();
        driver.findElement(By.linkText("Avatar")).click();
    }

    public void waitforsometime() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void goToSiteMapPage(){

        driver.findElement(By.linkText("Sitemap")).click();
    }

    public void goToSearchPage(){

        driver.findElement(By.linkText("Search")).click();
    }
}

