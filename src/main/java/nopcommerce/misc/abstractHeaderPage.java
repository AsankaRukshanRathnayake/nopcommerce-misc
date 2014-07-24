package nopcommerce.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class abstractHeaderPage extends abstractPage{



    public void gotoLogin(){
        WebElement loginButton = driver.findElement(By.xpath("//div[@id='shopbar-account']/a/span[1]/span[2]"));
        loginButton.click();
    }

    public void logout() {
        WebElement account_dropdown = driver.findElement(By.xpath("//*[@id='shopbar-account']/a/span[1]/span[2]/i"));
        account_dropdown.click();
        WebElement logout_link = driver.findElement(By.xpath("//*[@id='shopbar-account']/ul/li[6]/a"));
        logout_link.click();
        driver.getPageSource().contains("Log in");
    }

    public void setLanguage(String language) {
        if (language.equals("Deutsch")) {
            WebElement duetsch = driver.findElement(By.xpath("//*[@id='language-selector']/ul/li[1]/a"));
            duetsch.click();
        }
        else
        if (language.equals("English")) {

            WebElement english = driver.findElement(By.xpath("//*[@id='language-selector']/ul/li[2]/a"));
            english.click();
        }
    }

    public  boolean isSiteLanguageSet(String language) {
        if ( language.equals("Deutsch")) {
            WebElement homepagetext = driver.findElement(By.xpath("//*[@id='nav-home']/ul[1]/li[1]/a"));
            return (homepagetext.getText().trim().equals("Startseite"));
        }
        if (language.equals("English"))
        {
            String url = driver.getCurrentUrl();
            return (url.contains("frontend.smartstore.net/en/"));
        }
        return false;

    }

    public void setCurrency(String currency) {
        if (currency.equals("Euro")) {
            WebElement euro = driver.findElement(By.xpath("//*[@id='currency-selector']/ul/li[1]/a"));
            euro.click();
        }
        else
        if (currency.equals("Dollar")) {

            WebElement dollar = driver.findElement(By.xpath("//*[@id='currency-selector']/ul/li[2]/a"));
            dollar.click();
        }
    }

    public boolean isCurrencySet(String currency) {
        WebElement total = driver.findElement(By.xpath("//*[@id='shopbar-cart']/a/span[1]/span[1]/span"));
        if ( currency.equals("Euro")) {
            return (total.getText().contains("€"));
        }
        if (currency.equals("Dollar")) {
            return (total.getText().contains("$"));
        }
        return false;
    }

    public void gotoShoppingCart() {

    }
}
