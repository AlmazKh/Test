import org.openqa.selenium.By;
import ru.itis.File;

public class FileHelper extends HelperBase{

    public FileHelper(ApplicationManager applicationManager){
        super(applicationManager);
    }

    public void createFile(File file){
        driverGet("https://github.com/Test007000/Test");
        clickElement(findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New pull request'])[1]/following::button[1]")));
        sendKeys(findElement(By.name("filename")), file.getName());
        clearElement(findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Commit new file'])[1]/preceding::pre[1]")));
        clickElement(findElement(By.id("submit-file")));
    }

    public File getFile () {
        driverGet("https://github.com/Test007000/Test");
        return File.builder().name(driver.findElement(By.linkText("TestName6")).getText()).build();
    }
}
