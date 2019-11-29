import org.junit.Test;
import ru.itis.File;
import ru.itis.Repository;
import ru.itis.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MTest extends TestBase {

    @Test
    public void testAuth() {
        User user = User.builder()
                .login("Test00700000")
                .password("zsv89hho")
                .build();
        applicationManager.getLoginHelper().login(user);

        assertEquals(user.getLogin(), applicationManager.getLoginHelper().getUser().getLogin());
    }

    @Test
    public void testGoToRepository() {
        Repository repository = Repository.builder().name("Test").build();
        applicationManager.getNavigationHelper().goToRepository(repository);

        assertEquals(repository.getName(), applicationManager.getNavigationHelper().getRepository().getName());
    }

    @Test
    public void testCreateFile() {
        File file = File.builder().name("TestName6").build();
        applicationManager.getFileHelper().createFile(file);

        assertEquals(file.getName(), applicationManager.getFileHelper().getFile(file).getName());
    }

    @Test
    public void testDeleteFile() {
        File file = File.builder().name("TestName5").build();
        applicationManager.getFileHelper().deleteFile(file);

        assertNull(applicationManager.getFileHelper().getFile(file));
    }

    @Test
    public void testLogout() {
        applicationManager.getLoginHelper().logout();

        assertNull(applicationManager.getLoginHelper().getUser());
    }
}
