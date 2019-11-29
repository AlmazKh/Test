import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itis.File;
import ru.itis.Repository;
import ru.itis.User;

public class MTest extends TestBase {

    @Test
    public void testLogin() throws Exception {
        User user = User.builder().login("hamedzhanovalmaz@gmail.com").password("Qwerty_007_AKHR").build();
        applicationManager.getLoginHelper().login(user);
    }

    @Test
    public void testGotToRepository () {
        Repository repository = Repository.builder().name("Test").build();
        User user = User.builder().login("hamedzhanovalmaz@gmail.com").password("Qwerty_007_AKHR").build();
        applicationManager.getLoginHelper().login(user);
        applicationManager.getNavigationHelper().goToRepository(repository);
    }

    @Test
    public void testAddFile () {
        User user = User.builder().login("hamedzhanovalmaz@gmail.com").password("Qwerty_007_AKHR").build();
        applicationManager.getLoginHelper().login(user);
        File file = File.builder().name("TestName3").build();
        applicationManager.getFileHelper().addFile(file);
    }
}
