import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.itis.File;
import ru.itis.Repository;
import ru.itis.User;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestBase {

    protected WebDriver driver;
    protected String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public TestBase(){
        this.driver = new FirefoxDriver();
        this.baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void tearDown(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void login(User user) {
        driverGet("https://github.com/");
//        clickElement(findElement(By.linkText("Sign in")));
        clickElement(findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]")));
        clearElement(findElement(By.id("login_field")));
        sendKeys(findElement(By.id("login_field")), user.getLogin());
        clickElement(findElement(By.id("password")));
        clearElement(findElement(By.id("password")));
        sendKeys(findElement(By.id("password")), user.getPassword());
        clickElement(findElement(By.name("commit")));
    }

    public void goToRepository(Repository repository){
        driverGet("https://github.com/");
        clickElement(findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New project'])[1]/following::summary[1]")));
        clickElement(findElement(By.linkText("Your repositories")));
        clickElement(findElement(By.linkText(repository.getName())));
//        clickElement(findElement(By.linkText("Test")));
//        clickElement(findElement(By.xpath("/html/body/div[4]/div/aside[1]/div[2]/div[2]/div/ul/li[6]/div/a")));
    }

    public void addFile(File file){
        driverGet("https://github.com/AlmazKh/Test");
        clickElement(findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New pull request'])[1]/following::button[1]")));
        sendKeys(findElement(By.name("filename")), file.getName());
        clearElement(findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Commit new file'])[1]/preceding::pre[1]")));
        clickElement(findElement(By.id("submit-file")));
    }

    public WebElement findElement(By linkText){
        return driver.findElement(linkText);
    }

    public void clickElement(WebElement webElement){
        webElement.click();
    }

    public void clearElement(WebElement webElement){
        webElement.clear();
    }

    public void sendKeys(WebElement webElement, CharSequence charSequence){
        webElement.sendKeys(charSequence);
    }

    public void driverGet(String link){
        driver.get(link);
    }

}
