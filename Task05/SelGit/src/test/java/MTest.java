import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import ru.itis.Repository;
import ru.itis.TxtFile;
import ru.itis.User;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MTest extends TestBase {

    @Test
    @SneakyThrows
    public void testAuth() {
        XmlMapper xmlMapper = new XmlMapper();
        User user = xmlMapper.readValue(new File("C:\\Users\\Almaz\\Desktop\\Test\\Task05\\SelGit\\testLoginData.xml"), User.class);

//        User user = User.builder()
//                .login("Test00700000")
//                .password("zsv89hho")
//                .build();
        try {
            applicationManager.getLoginHelper().login(user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(user.getLogin(), applicationManager.getLoginHelper().getUser().getLogin());
    }

    @Test
    public void testGoToRepository() {
        Repository repository = Repository.builder().name("Test").build();
        applicationManager.getNavigationHelper().goToRepository(repository);

        Assert.assertEquals(repository.getName(), applicationManager.getNavigationHelper().getRepository().getName());
    }

    @Test
    @SneakyThrows
    public void testCreateFile() {
        XmlMapper xmlMapper = new XmlMapper();
        TxtFile txtFile = xmlMapper.readValue(new File("C:\\Users\\Almaz\\Desktop\\Test\\Task05\\SelGit\\testFileData.xml"), TxtFile.class);
//        TxtFile txtFile = TxtFile.builder().name("TestName10").build();
        applicationManager.getFileHelper().createFile(txtFile);

        assertEquals(txtFile.getName(), applicationManager.getFileHelper().getFile(txtFile).getName());
    }

    @Test
    @SneakyThrows
    public void testDeleteFile() {
        XmlMapper xmlMapper = new XmlMapper();
        TxtFile txtFile = xmlMapper.readValue(new File("C:\\Users\\Almaz\\Desktop\\Test\\Task05\\SelGit\\testFileData.xml"), TxtFile.class);
//        TxtFile txtFile = TxtFile.builder().name("TestName9").build();
        applicationManager.getFileHelper().deleteFile(txtFile);

        assertNull(applicationManager.getFileHelper().getFile(txtFile));
    }

    @Test
    public void testLogout() {
        applicationManager.getLoginHelper().logout();

        assertNull(applicationManager.getLoginHelper().getUser());
    }
}
