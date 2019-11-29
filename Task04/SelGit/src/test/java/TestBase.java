import org.junit.After;
import org.junit.Before;

public class TestBase {

    protected  ApplicationManager applicationManager;

    @Before
    public void setUp(){
        applicationManager = new ApplicationManager();
    }

    @After
    public void tearDown(){
        applicationManager.tearDown();
    }
}
