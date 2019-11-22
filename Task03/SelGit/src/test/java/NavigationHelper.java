import org.openqa.selenium.By;
import ru.itis.Repository;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(ApplicationManager applicationManager){
        super(applicationManager);
    }

    public void goToRepository(Repository repository){
        driverGet("https://github.com/");
        clickElement(findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New project'])[1]/following::summary[1]")));
        clickElement(findElement(By.linkText("Your repositories")));
        clickElement(findElement(By.linkText(repository.getName())));
    }
}
