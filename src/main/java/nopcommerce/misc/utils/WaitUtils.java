package nopcommerce.misc.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class WaitUtils {

    public static WebDriver driver = BrowserFactory.getBrowser("firefox");

    public static void waitForElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    public static boolean isTextAvailable(String text)
    {
        return driver.getPageSource().contains(text);
    }

    public static void pause(int time)
    {
        try {
            Thread.sleep(time*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementDisplayed(By by) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public static void implicitWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static boolean isElementPresent(WebElement element) {
        try {
            implicitWait();
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementPresent(By by) {
        try {
            implicitWait();
            driver.findElement(by).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
