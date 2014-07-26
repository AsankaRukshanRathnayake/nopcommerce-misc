package nopcommerce.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Shahab on 25/07/2014.
 */
public class AddAddressPage extends abstractHeaderPage {

    public void gotoaddresspage()
    {

        System.out.println("Inside address");
        WebElement myaccount =  driver.findElement(By.xpath(".//*[@id='content-left']/div/div[2]/ul/li[2]/a"));
        //span[1]/span[2]
        myaccount.click();

    }



    public void gotoNewAddressPage()
    {

        System.out.println("Inside add new address");
        WebElement myaccount =  driver.findElement(By.xpath("//*[@id='content-center']/div/div[2]/div[1]/a"));
        //span[1]/span[2]
        myaccount.click();



    }
    public void accountAddNewAddress(String firstName,String lastName, String address,String postCode,String city,String country,String email,String phone)
    {
//-------passing first name to test box----//
        WebElement wfirstname = driver.findElement(By.xpath("//*[@id='Address_FirstName']"));
        wfirstname.clear();
        wfirstname.sendKeys(firstName);

        WebElement wlastname = driver.findElement(By.xpath("//*[@id='Address_LastName']"));
        wlastname.clear();
        wlastname.sendKeys(lastName);

        WebElement waddress = driver.findElement(By.xpath("//*[@id='Address_Address1']"));
        waddress.clear();
        waddress.sendKeys(address);

        WebElement wpostcode = driver.findElement(By.xpath("//*[@id='Address_ZipPostalCode']"));
        wpostcode.clear();
        wpostcode.sendKeys(postCode);

        WebElement wcity = driver.findElement(By.xpath("//*[@id='Address_City']"));
        wcity.clear();
        wcity.sendKeys(city);

       /* WebElement wcountry = driver.findElement(By.xpath("//div[@id='s2id_Address_CountryId']/a/span"));
        wcountry.click();
        WebElement wscountry = driver.findElement(By.xpath("html/body/div[2]/div/input"));
        wcountry.sendKeys("Germany");
        WebElement wsscountry = driver.findElement(By.xpath("html/body/div[2]/ul/li[1]/div"));
        wsscountry.click();
*/

       // driver.findElement(By.xpath("//div[9]/div/div/a/span")).sendKeys("Germany");

        WebElement dropDownListBox = driver.findElement(By.xpath("html/body/div[2]/div/input"));

        Select clickThis = new Select(dropDownListBox); clickThis.selectByValue("Germany");
clickThis.selectByVisibleText("Germany");




        WebElement wemail = driver.findElement(By.xpath("//*[@id='Address_Email']"));
        wemail.clear();
        wemail.sendKeys(email);


        WebElement wphone = driver.findElement(By.xpath("//*[@id='Address_PhoneNumber']"));
        wphone.clear();
        wphone.sendKeys(phone);

        WebElement wsave = driver.findElement(By.xpath("//*[@id='content-center']/form/div/div[3]/div[3]/div/div/button"));
        wsave.click();




/*
    System.out.println(newAddressInfo[0]);
    for (int i = 0; i < newAddressInfo.length; i++) {
        switch (i) {
            case 0:
                updateGender(newAddressInfo[i]);
                break;
            case 1:

                updateFirstName(newAddressInfo[i]);
                break;
            case 2:

                updateLastName(newAddressInfo[i]);
                break;

            default:
                break;
        }
    }
}

*/
    }




}
