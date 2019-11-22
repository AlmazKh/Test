import org.junit.After;
import org.junit.Before;
import ru.itis.File;
import ru.itis.Repository;
import ru.itis.User;

public class MTest {

    private TestBase testBase;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Almaz\\Desktop\\gecko\\geckodriver.exe");
        testBase = new TestBase();
    }

    @org.junit.Test
    public void testUntitledTestCase() throws Exception {
        User user = new User();
        user.setLogin("hamedzhanovalmaz@gmail.com");
        user.setPassword("Qwerty_007_AKHR");
        testBase.login(user);

        Repository repository = new Repository();
        repository.setName("Test");
        testBase.goToRepository(repository);

        File file = new File();
        file.setName("TestName1");
        testBase.addFile(file);
    }

    @After
    public void tearDown() throws Exception {
       testBase.tearDown();
    }
}
