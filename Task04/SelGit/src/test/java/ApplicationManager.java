import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ApplicationManager {

    protected WebDriver driver;
    protected String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    private LoginHelper loginHelper;
    private NavigationHelper navigationHelper;
    private FileHelper fileHelper;


    public ApplicationManager() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Almaz\\Desktop\\gecko\\geckodriver.exe");
        this.driver = new FirefoxDriver();
        this.baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginHelper = new LoginHelper(this);
        fileHelper = new FileHelper(this);
        navigationHelper = new NavigationHelper(this);
    }

    public void tearDown() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public StringBuffer getVerificationErrors() {
        return verificationErrors;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public FileHelper getFileHelper() {
        return fileHelper;
    }
}
