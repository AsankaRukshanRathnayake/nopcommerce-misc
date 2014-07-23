package nopcommerce.misc;

import org.junit.Test;
import static org.junit.Assert.*;

public class MiscRegressionTestSuite extends baseTestSuite
{
/////-------------DATA-----------------//
    
private String username = "jamesmiller";
private String password = "jm1234";
private String category = "Books";
private String product  = "Fast Cars, Picture Calendar 2013";
private int qty=1;
private String [] customerInfo = { "Male", "James" , "Miller", "30", "June", "1991", "jamesmiller@test.com", "jamesmiller", "testcom", " ", "Yes", "(UTC) Dublin, Edinburgh, Lisbon, London","jm1234", "jm1234"};
private String [] updateCustomerInfo = { "Female", "Sames" , "Miller", "3", "July", "1990", "samesmiller@test.com", "samesmiller", "testercom", " ", "No   ", "(UTC-06:00) Central Time (US & Canada)"};

 Boolean registration_successful = true;
    private String username1 = "Ben";
    private String Lang_Deutsch = "Deutsch";
    private String Lang_English = "English";
    private String Currency_Dollar ="Dollar";
    private String Currency_Euro = "Euro";


    ////-----------end of data----------//
@Test
public void  registerNewUser()

{
    HomePage homePage = new HomePage();

    homePage.gotoLogin();

    homePage.gotoRegisternewUser();

    RegisterUserPage registerUserPage = new RegisterUserPage();

    if (!registerUserPage.isUserAlreadyRegistered(username))
    {
        assertTrue(registerUserPage.registerNewUser(customerInfo));
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

    customerInfoPage.updateFirstName(username1);

    String pageSource = driver.getPageSource();

    assertFalse(customerInfoPage.checkFirstName(pageSource));

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

        assertTrue(customerInfoPage.checkFirstName(pageSource));

    }
@Test
    public void select_Manufacture_From_HomePage() {
        HomePage homePage = new HomePage();

        homePage.gotoLogin();

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsConsumer(username, password);

        homePage.select_first_manufacturer();

        ManufacturersPage manufacturespage = new ManufacturersPage();

        assertTrue(manufacturespage.isMaufacturePage());

        manufacturespage.select_a_Product();

   }

@Test
    public void select_Manufacture_By_ViewAll() {
        HomePage homePage = new HomePage();

        homePage.gotoLogin();

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsConsumer(username, password);

        homePage.select_viewall_manufacture();

        ManufacturersPage manufacturespage = new ManufacturersPage();

        assertTrue(manufacturespage.isMaufactureListPage());

        manufacturespage.select_first_Manufacturer();

        manufacturespage.select_a_Product();

    }
@Test
     public void change_language_to_Duetsch() {

        HomePage homePage = new HomePage();

        homePage.setLanguage(Lang_Deutsch);

        assertTrue(homePage.verifyDuetschSettings());

}

@Test
    public void change_language_to_English() {

        HomePage homePage = new HomePage();

        homePage.setLanguage(Lang_English);

        assertTrue(homePage.verifyEnglishSettings());

    }

@Test
    public void change_currency_to_Dollars() {

        HomePage homePage = new HomePage();

        homePage.setLanguage(Currency_Dollar);

        assertTrue(homePage.verifyDollarSettings());

    }

    @Test
    public void change_currency_to_Euro() {

        HomePage homePage = new HomePage();

        homePage.setLanguage(Currency_Euro);

        assertTrue(homePage.verifyEuroSettings());

    }
}


