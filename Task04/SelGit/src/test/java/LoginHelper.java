import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import ru.itis.User;

public class LoginHelper extends HelperBase{

    public LoginHelper(ApplicationManager applicationManager){
        super(applicationManager);
    }

    public void login(User user) {
        driverGet("https://github.com/");
        clickElement(findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]")));
        clearElement(findElement(By.id("login_field")));
        sendKeys(findElement(By.id("login_field")), user.getLogin());
        clickElement(findElement(By.id("password")));
        clearElement(findElement(By.id("password")));
        sendKeys(findElement(By.id("password")), user.getPassword());
        clickElement(findElement(By.name("commit")));
    }

    public void logout() {
        driver.get("https://github.com/");
        try {
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New organization'])[1]/following::summary[1]")).click();
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Settings'])[1]/following::button[1]")).click();
        } catch (NoSuchElementException e) {
            return;
        }
    }

    public User getUser() {
        driver.get("https://github.com/");
        try {
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New organization'])[1]/following::summary[1]")).click();
            driver.findElement(By.linkText("Your profile")).click();
        } catch (NoSuchElementException e) {
            return null;
        }
        return User.builder().login(driver.findElement(By.className("p-nickname")).getText()).build();
    }
}
