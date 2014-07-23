package nopcommerce.misc;
import nopcommerce.misc.utils.BrowserFactory;
import org.openqa.selenium.WebDriver;


public class abstractPage {

    public static WebDriver driver;

    public abstractPage()
    {
           driver = BrowserFactory.getBrowser("firefox");
    }


}
