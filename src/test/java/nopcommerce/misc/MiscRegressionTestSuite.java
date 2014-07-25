package nopcommerce.misc;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

public class MiscRegressionTestSuite extends baseTestSuite
{
/////-------------DATA-----------------//
    
private String username = "jamesmiller";
private String password = "jm1234";

private String [] newcustomerInfo = { "Male", "James" , "Miller", "30", "June", "1991", "jamesmiller@test.com", "jamesmiller", "testcom", " ", "Yes", "(UTC) Dublin, Edinburgh, Lisbon, London","jm1234", "jm1234"};

private String [] updateCustomerInfo = { "Female", "Sam" , "Mill", "3", "July", "1990", "samesmil@test.com", "samesmil", "testercom", " ", "No   ", "(UTC-06:00) Central Time (US & Canada)"};

private String [] customerInforevert = { "Male", "James" , "Miller", "30", "June", "1991", "jamesmiller@test.com", "jamesmiller", "testcom", " ", "Yes", "(UTC) Dublin, Edinburgh, Lisbon, London"};

    private String firstname = "Benq";
    private String firstname1 = "James";

    private String Lang_Deutsch = "Deutsch";
    private String Lang_English = "English";
    private String Currency_Dollar ="Dollar";
    private String Currency_Euro = "Euro";
    HomePage homePage = new HomePage();

    ////-----------end of data----------//
@Test
public void  registerNewUser()

{
    HomePage homePage = new HomePage();

    homePage.gotoLogin();

    LoginPage loginPage = new LoginPage();

    loginPage.gotoRegisternewUser();

    RegisterUserPage registerUserPage = new RegisterUserPage();

    if (!registerUserPage.isUserAlreadyRegistered(username))
    {
        assertTrue(registerUserPage.registerNewUser(newcustomerInfo));
        homePage.logout();
    }
}

@Test
   
public void  updatePersonalDetails()
{
        
    HomePage homePage = new  HomePage();

    homePage.gotoLogin();

    LoginPage loginPage = new LoginPage();

    loginPage.loginAsConsumer(username, password);

    MyAccountPage myAccountPage = new MyAccountPage();

    myAccountPage.gotoAccountPage();

    CustomerInfoPage customerInfoPage = new CustomerInfoPage();

    assertTrue(customerInfoPage.updateUserInfo(updateCustomerInfo));

    assertTrue(customerInfoPage.updateUserInfo(customerInforevert));

    homePage.logout();

}
@Test
public void  updateFirstName(){

    HomePage homePage = new  HomePage();

    homePage.gotoLogin();

    LoginPage loginPage = new LoginPage();

    loginPage.loginAsConsumer(username, password);

    MyAccountPage myAccountPage = new MyAccountPage();

    myAccountPage.gotoAccountPage();

    CustomerInfoPage customerInfoPage = new CustomerInfoPage();

    customerInfoPage.updateFirstName(firstname);

    customerInfoPage.savedetails();

    String pageSource = driver.getPageSource();

    assertTrue(customerInfoPage.isFirstNameValid(pageSource));

    customerInfoPage.updateFirstName(firstname1);

    customerInfoPage.savedetails();

}

@Test
    public void  invalidFirstName(){

        HomePage homePage = new  HomePage();

        homePage.gotoLogin();

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsConsumer(username, password);

        MyAccountPage myAccountPage = new MyAccountPage();

        myAccountPage.gotoAccountPage();

        CustomerInfoPage customerInfoPage = new CustomerInfoPage();

        customerInfoPage.updateFirstName(" ");

        String pageSource = driver.getPageSource();

        assertTrue(customerInfoPage.isFirstNameValid(pageSource));

    }
@Test
    public void select_Manufacture_From_HomePage() {
        HomePage homePage = new HomePage();

        String manufacturer = homePage.select_first_manufacturer();

        ManufacturersPage manufacturespage = new ManufacturersPage();

        assertTrue(manufacturespage.isMaufacturePage(manufacturer));

    }

@Test
    public void select_Manufacture_By_ViewAll() {
        HomePage homePage = new HomePage();

        homePage.select_viewall_manufacture();

        ManufacturersPage manufacturespage = new ManufacturersPage();

        assertTrue(manufacturespage.isMaufactureListPage());

    }
@Test
     public void change_language_to_Duetsch() {

        HomePage homePage = new HomePage();

        homePage.setLanguage(Lang_Deutsch);

        assertTrue(homePage.isSiteLanguageSet(Lang_Deutsch));

}

@Test
    public void change_language_to_English() {

        HomePage homePage = new HomePage();

        homePage.setLanguage(Lang_English);

        assertTrue(homePage.isSiteLanguageSet(Lang_English));

    }

@Test
    public void change_currency_to_Dollars() {

        HomePage homePage = new HomePage();

        homePage.setCurrency(Currency_Dollar);

        assertTrue(homePage.isCurrencySet(Currency_Dollar));

    }

    @Test
    public void change_currency_to_Euro() {



        homePage.setCurrency(Currency_Euro);

        assertTrue(homePage.isCurrencySet(Currency_Euro));

    }

    @Test
    public void verifyRecentyViewdPage()
    {

        homePage.navigatetologinpage();
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsConsumer(username,password);

        homePage.navigateToBooks();
        Assert.assertEquals("Books",driver.findElement(By.xpath(".//*[@id='content-center']/div/div[1]/h1")).getText());
   driver.findElement(By.xpath(".//*[@id='content-center']/div/div[2]/div[3]/div/div/div[1]/div[1]/article/figure/a/img")).click();
   driver.findElement(By.xpath(".//*[@id='logobar']/a/img")).click();
   driver.findElement(By.xpath(".//*[@id='content-left']/div[4]/div[2]/ul/li[5]/a")).click();
   homePage.navigateToRecentlyviewedpage();
   Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().contains("Autos der Superlative"));
    }
}


