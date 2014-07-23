package nopcommerce.misc;
import nopcommerce.misc.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Sasikala on 22/07/2014.
 */
public class RegisterUserPage extends abstractHeaderPage {

    public boolean isUserAlreadyRegistered(String username) {
        WebElement userName = driver.findElement(By.id("Username"));
        userName.sendKeys(username);
        return isUsernameAvailable();
    }
    public boolean isUsernameAvailable() {

        WebElement checkAvailability = driver.findElement(By.id("check-availability-button"));
        checkAvailability.click();
        WaitUtils.pause(2);
        return driver.getPageSource().contains("Username not available");
    }

    public boolean registerNewUser(String[] customerInfo) {
        enterUserDetails(customerInfo);
        WebElement registerButton = driver.findElement(By.xpath(".//*[@id='content-center']/form/div/div[2]/div/div/button"));
        registerButton.click();
        return true;
     }

    public void enterUserDetails(String[] customerInfo) {

        for (int i = 0; i < customerInfo.length; i++) {
            switch (i) {
                case 0:
                    updateGender(customerInfo[i]);
                    break;
                case 1:

                    updateFirstName(customerInfo[i]);
                    break;
                case 2:

                    updateLastName(customerInfo[i]);
                    break;
                case 3:
                    //updateDay(customerInfo[i]);
                    break;
                case 4:
                    //updateMonth(customerInfo[i]);
                    break;
                case 5:
                    //updateYear(customerInfo[i]);
                    break;
                case 6:

                    updateEmail(customerInfo[i]);
                    break;
                case 7:

                    updateUsername(customerInfo[i]);
                    break;
                case 8:

                    updateCompany(customerInfo[i]);
                    break;
                case 9:

                    updateVatNumber(customerInfo[i]);
                    break;
                case 10:

                    updateNewLetter(customerInfo[i]);
                    break;
                case 11:

                    updateTimezone(customerInfo[i]);
                    break;
                case 12:

                    updatePassword(customerInfo[i]);
                    break;
                case 13:

                    updateNewPassword(customerInfo[i]);
                    break;

                default:
                    break;
            }
        }
    }

    public boolean isErrorPresent(){
        WaitUtils.pause(100);
        String pageSource = driver.getPageSource();
        boolean error_msg = false;
        for ( int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    System.out.println("0");
                    error_msg = checkFirstName(pageSource);
                    break;
                case 1:
                    System.out.println("1");
                    error_msg = checkLastName(pageSource);
                    break;
                case 2:
                    System.out.println("2");
                    error_msg = checkUsername(pageSource);
                    break;
                case 3:
                    System.out.println("3");
                    error_msg = checkEmail(pageSource);
                    break;
                case 4:
                    System.out.println("4");
                    error_msg = checkPassword(pageSource);
                    break;

                default:
                    break;
            }
            if (error_msg) {
                System.out.println("inside the error page");
                return false;
            }
        }
        return true;
    }

    public void updateGender(String gender) {

        if (gender.equals("Male")) {
            WebElement gendermale = driver.findElement(By.id("gender-male"));
            gendermale.click();
        } else if (gender.equals("Female")) {

            WebElement genderfemale = driver.findElement(By.id("gender-female"));
            genderfemale.click();
        }
    }
    public void updateFirstName(String firstname) {

        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.clear();
        firstName.sendKeys(firstname);
    }

    public void updateLastName(String lastname) {
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.clear();
        lastName.sendKeys(lastname);
    }

    public void updateDay(String day) {
        WebElement day_date = driver.findElement(By.id("//*[@id='s2id_autogen1']/a/span"));
    }

    public void updateMonth(String month) {
        WebElement month_date = driver.findElement(By.xpath("//*[@id='s2id_autogen2']/a/span"));
    }

    public void updateYear(String year) {
        WebElement year_date = driver.findElement(By.id("//*[@id='s2id_autogen3']/a/span"));
    }

    public void updateEmail(String email) {
        WebElement useremail = driver.findElement(By.id("Email"));
        useremail.clear();
        WaitUtils.pause(2);
        useremail.sendKeys(email);
    }

    public void updateUsername(String username) {
        WebElement userName = driver.findElement(By.id("Username"));
        userName.clear();
        userName.sendKeys(username);
    }

    public void updateCompany(String company) {
        WebElement companyName = driver.findElement(By.id("Company"));companyName.clear();
        companyName.sendKeys(company);
    }

    public void updateVatNumber(String vatnumber) {
        WebElement vatNumber = driver.findElement(By.id("VatNumber"));
    }

    public void updateNewLetter(String newsletter) {
        WebElement newsLetter = driver.findElement(By.id("Newsletter"));
        //newsLetter.sendKeys(newsletter);
    }

    public void updateTimezone(String timezone) {
        Select timeZone = new Select(driver.findElement(By.id("TimeZoneId")));
    }

    public void updatePassword(String password) {
        WebElement userpassword = driver.findElement(By.id("Password"));
        userpassword.clear();
        userpassword.sendKeys(password);
    }

    public void updateNewPassword(String confirmpassword) {
        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.clear();
        confirmPassword.sendKeys(confirmpassword);
    }

    public boolean checkFirstName(String pageSource){
         return pageSource.contains("First name is required.");
    }

    public boolean checkLastName(String pageSource) {
        return   pageSource.contains("Last name is required.");
    }

    public boolean checkUsername(String pageSource){
        return pageSource.contains("The username is already in use");
    }

    public boolean checkEmail(String pageSource){
        return ( pageSource.contains("Wrong email") | pageSource.contains("The e-mail address is already in use") | pageSource.contains("The specified email already exists") );
    }

    public boolean checkPassword(String pageSource){
        return ( pageSource.contains("Password is required"));
    }

}





