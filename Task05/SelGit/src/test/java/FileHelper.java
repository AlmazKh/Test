import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import ru.itis.File;

public class FileHelper extends HelperBase{

    public FileHelper(ApplicationManager applicationManager){
        super(applicationManager);
    }

    public void createFile(File file){
        driverGet("https://github.com/Test00700000/Test");
        clickElement(findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New pull request'])[1]/following::button[1]")));
        sendKeys(findElement(By.name("filename")), file.getName());
        clearElement(findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Commit new file'])[1]/preceding::pre[1]")));
        clickElement(findElement(By.id("submit-file")));
    }

    public File getFile (File file) {
        driverGet("https://github.com/Test00700000/Test");
        try {
            driver.findElement(By.linkText(file.getName()));
        } catch (NoSuchElementException e) {
            return null;
        }
        return File.builder().name(driver.findElement(By.linkText(file.getName())).getText()).build();
    }

    public void deleteFile(File file) {
        driverGet("https://github.com/Test00700000/Test");
        clickElement(findElement(By.linkText(file.getName())));
//        clickElement(findElement(By.id("e13ac203b388f115b9a14e6470cbeafa-8b137891791fe96927ad78e64b0aad7bded08bdc")));
        clickElement(findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='History'])[1]/following::button[2]")));
        clickElement(findElement(By.id("submit-file")));
    }
}
