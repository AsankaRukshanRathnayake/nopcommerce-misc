package nopcommerce.misc;

import nopcommerce.misc.utils.BrowserFactory;
import nopcommerce.misc.utils.REPORTER;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class baseTestSuite {
    private static final Logger LOGGER  = Logger.getLogger(baseTestSuite.class);
    public static final boolean DebugSwitch = false;

    public static WebDriver driver;
    static String sheet;

    public static String browser;
    public static Object getDriver;

    private static String BROWSER;
    private static String SERVERURL;
    static String propertiesFileName = "automation.properties";
//    public static Properties PROPERTIES = loadProperties(propertiesFileName);;



    @BeforeClass
    public static void browserStart() throws Exception {
        LOGGER.info("I am Starting the Reporter and driver");
        REPORTER.startReporter();
//        PROPERTIES =
        startRemoteWebBrowser("Firefox");
//		sheet = PROPERTIES.getProperty("SHEET");
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("browser", PROPERTIES.getProperty("BROWSER"));
//        caps.setCapability("platform", PROPERTIES.getProperty("PLATFORM"));
//        caps.setCapability("version", PROPERTIES.getProperty("VERSION"));
//        driver = new RemoteWebDriver(new URL(PROPERTIES.getProperty("URL")),caps);
//		SERVERURL = PROPERTIES.getProperty("SERVERURL");
//		BROWSER = PROPERTIES.getProperty("BROWSER");
//		selSer = new SeleniumServer();
//		selSer.start();
        //      REPORTER = new testReporter("ReportNew");
        //    REPORTER.addNewIteration("new iteration");
//        if (PROPERTIES.getProperty("BROWSER").equalsIgnoreCase("FIREFOX"))
//            driver = new FirefoxDriver();
//        else if (PROPERTIES.getProperty("BROWSER").equalsIgnoreCase("SAFARI"))
//            driver = new SafariDriver();
//        else if (PROPERTIES.getProperty("BROWSER").equalsIgnoreCase("CHROME"))
//        {
//
//            driver = new ChromeDriver();
//        }
//        else if (PROPERTIES.getProperty("BROWSER").equalsIgnoreCase("IE"))
//            driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//        driver.get(PROPERTIES.getProperty("URL"));
    }

    private static Properties loadProperties(String propertiesFileName2) {
        Properties pro = new Properties();
        try {
            pro.load(new FileInputStream(propertiesFileName2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pro;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public static void browserclose() {
        //bl.logout();
        driver.quit();
        REPORTER.closeReports();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        String file = "target\\qa-logs\\SampleTest_Results.XML";
//        MailReporter mailSender=new MailReporter("jkumar12398@gmail.com","Selenium Webdriver Execution Report","Hi this is a test mail",file);
        // Disconnect the Server
        LOGGER.info("I am Closing the Server............");
//        try {
//          //  Runtime.getRuntime().exec("taskkill /im firefox.exe");
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }


    }
    @Before
    public void beforeMethod()
    {
//        REPORTER.setIteration((m.getName()));
    }


    //@After
    public void afterMethod() {
//        sl.captureScreen(result.getMethod().getMethodName());
        LOGGER.info("I am in after method");
        driver.quit();
        driver = null;
//        selSer.stop();
//        sl = null;
    }


    protected static void startRemoteWebBrowser(String browser) throws MalformedURLException {

//        this.browser = browser;
        String email = "test12@mailinator.com";
        String runAt = null;
        runAt = "local";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);   //

        // capabilities.setCapability("version", Integer.parseInt(PROPERTIES.getProperty("VERSION")));
        //capabilities.setCapability("platform", PROPERTIES.getProperty("PLATFORM"));
        capabilities.setBrowserName(browser);
//        runStandAloneServer();
//        URL url = new URL(PROPERTIES.getProperty("SERVERURL"));

        driver = BrowserFactory.getBrowser(browser);
       // driver = new RemoteWebDriver(new URL("http://cb_ram-core:2c259106-416c-4890-9e0a-9f09ccb96c74@ondemand.saucelabs.com:80/wd/hub"), capabilities);

        driver.get("http://frontend.smartstore.net/en/");
        driver.manage().window().maximize();
    }

//    protected void startBrowser(String browser) {
//
//        this.browser = browser;
//        if (browser.equals("IEXPLORE")) {
//            driver = new InternetExplorerDriver();
//        } else if (browser.equals("IEXPLORE")) {
//
//            driver = new AndroidDriver();
//        } else {
//            FirefoxProfile firefoxProfile = new FirefoxProfile();
//            driver = new FirefoxDriver(firefoxProfile);
//        }
//        driver.get(PROPERTIES.getProperty("URL"));
//        sl = new SystemLibrary();
//
//    }
}
