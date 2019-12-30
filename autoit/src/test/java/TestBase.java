import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;

public class TestBase {
    public AppManager app;

    @Before
    public void initApp(){
        app = new AppManager();
    }

    @After
    public void stopApp(){
        app.stop();
    }
}
