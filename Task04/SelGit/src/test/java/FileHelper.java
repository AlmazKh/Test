import org.openqa.selenium.By;
import ru.itis.File;

public class FileHelper extends HelperBase{

    public FileHelper(ApplicationManager applicationManager){
        super(applicationManager);
    }

    public void addFile(File file){
        driverGet("https://github.com/AlmazKh/Test");
        clickElement(findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New pull request'])[1]/following::button[1]")));
        sendKeys(findElement(By.name("filename")), file.getName());
        clearElement(findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Commit new file'])[1]/preceding::pre[1]")));
        clickElement(findElement(By.id("submit-file")));
    }
}
