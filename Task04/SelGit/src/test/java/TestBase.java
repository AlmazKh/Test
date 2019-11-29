import org.junit.Before;

public class TestBase {

    protected  ApplicationManager applicationManager;

    @Before
    public void setUp(){
        applicationManager =  ApplicationManager.getInstance();
        applicationManager.getNavigationHelper().openHomePage();
    }
}
