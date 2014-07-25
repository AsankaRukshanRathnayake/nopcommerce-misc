package nopcommerce.misc;

import org.junit.Assert;
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

    ////-----------end of data----------//

    //Page Objects
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    CustomerInfoPage customerInfoPage = new CustomerInfoPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    ManufacturersPage manufacturespage = new ManufacturersPage();
    RecentlyViewedProductPage rvp=new RecentlyViewedProductPage();



@Test
public void  registerNewUser()

{

    homePage.gotoLogin();

    loginPage.gotoRegisternewUser();

    RegisterUserPage registerUserPage = new RegisterUserPage();

    if (!registerUserPage.isUserAlreadyRegistered(username))
    {
        Assert.assertTrue(registerUserPage.registerNewUser(newcustomerInfo));
        homePage.logout();
    }
}

@Test
   
public void  updatePersonalDetails()
{
   homePage.gotoLogin();
    loginPage.loginAsConsumer(username, password);

    MyAccountPage myAccountPage = new MyAccountPage();

    myAccountPage.gotoAccountPage();

   Assert.assertTrue(customerInfoPage.updateUserInfo(updateCustomerInfo));

    Assert.assertTrue(customerInfoPage.updateUserInfo(customerInforevert));

    homePage.logout();

}
@Test
public void  updateFirstName(){


    homePage.gotoLogin();

    loginPage.loginAsConsumer(username, password);



    myAccountPage.gotoAccountPage();

    customerInfoPage.updateFirstName(firstname);

    customerInfoPage.savedetails();

    String pageSource = driver.getPageSource();

    Assert.assertTrue(customerInfoPage.isFirstNameValid(pageSource));

    customerInfoPage.updateFirstName(firstname1);

    customerInfoPage.savedetails();

}

@Test
    public void  invalidFirstName(){


        homePage.gotoLogin();


        loginPage.loginAsConsumer(username, password);

        myAccountPage.gotoAccountPage();

        customerInfoPage.updateFirstName(" ");

        String pageSource = driver.getPageSource();

        Assert.assertTrue(customerInfoPage.isFirstNameValid(pageSource));

    }
@Test
    public void select_Manufacture_From_HomePage() {

        String manufacturer = homePage.select_first_manufacturer();
        Assert.assertTrue(manufacturespage.isMaufacturePage(manufacturer));

    }

@Test
    public void select_Manufacture_By_ViewAll() {
        homePage.select_viewall_manufacture();
        Assert.assertTrue(manufacturespage.isMaufactureListPage());

    }
@Test
     public void change_language_to_Duetsch() {

        homePage.setLanguage(Lang_Deutsch);

        Assert.assertTrue(homePage.isSiteLanguageSet(Lang_Deutsch));

}

@Test
    public void change_language_to_English() {

       homePage.setLanguage(Lang_English);

        Assert.assertTrue(homePage.isSiteLanguageSet(Lang_English));

    }

@Test
    public void change_currency_to_Dollars() {

         homePage.setCurrency(Currency_Dollar);

        Assert.assertTrue(homePage.isCurrencySet(Currency_Dollar));

    }

    @Test
    public void change_currency_to_Euro() {



        homePage.setCurrency(Currency_Euro);

        Assert.assertTrue(homePage.isCurrencySet(Currency_Euro));

    }

    @Test
    public void verifyRecentyViewdPage()
    {

        homePage.navigatetologinpage();
        loginPage.loginAsConsumer(username,password);
        homePage.navigateToBooks();
        Assert.assertEquals("Books", driver.findElement(By.xpath(".//*[@id='content-center']/div/div[1]/h1")).getText());
        homePage.viewProducts();
        rvp.verifyViewedProductShownInRecentlyViewedProductsPage();
   }
}


