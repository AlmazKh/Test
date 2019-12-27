import org.openqa.selenium.*;

public class HelperBase {

    protected ApplicationManager applicationManager;
    protected WebDriver driver;

    private boolean acceptNextAlert = true;

    public HelperBase(ApplicationManager applicationManager){
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
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
