import org.junit.Test;
import ru.itis.File;
import ru.itis.Repository;
import ru.itis.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MTest extends TestBase {

    @Test
    public void testAuth() throws Exception {
        User user = User.builder()
                .login("Test007000")
                .password("Qwerty_007_AKHR")
                .build();
        applicationManager.getLoginHelper().login(user);

        assertEquals(user.getLogin(), applicationManager.getLoginHelper().getUser().getLogin());
    }

    @Test
    public void testGotToRepository() {
        Repository repository = Repository.builder().name("Test").build();
        applicationManager.getNavigationHelper().goToRepository(repository);

        assertEquals(repository.getName(), applicationManager.getNavigationHelper().getRepository().getName());
    }

    @Test
    public void testCreateFile() {
        File file = File.builder().name("TestName6").build();
        applicationManager.getFileHelper().createFile(file);

        assertEquals(file.getName(), applicationManager.getFileHelper().getFile().getName());
    }

    @Test
    public void testLogout() {
        applicationManager.getLoginHelper().logout();

        assertNull(applicationManager.getLoginHelper().getUser());
    }
}
