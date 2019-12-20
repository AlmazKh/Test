import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;

public class TestBase {

    protected  ApplicationManager applicationManager;

    @Before
    public void setUp(){
        applicationManager =  ApplicationManager.getInstance();
//        applicationManager.getNavigationHelper().openHomePage();
    }

    @AfterClass
    public static void tearDown() {
        ApplicationManager.getInstance().quit();
    }
}
