import org.openqa.selenium.By;
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
}
