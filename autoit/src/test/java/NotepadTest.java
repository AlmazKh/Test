import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class NotepadTest extends TestBase {
    private static final String TEST_FILE_NAME = "file";

    @Before
    public void setStopParam() {
        app.setTitle(TEST_FILE_NAME + ".txt - Блокнот");
    }

    @Test
    public void typeWordTest() throws InterruptedException {
        app.getNotepadHelper().typeASD();
        app.getNotepadHelper().saveFile(TEST_FILE_NAME);
        Thread.sleep(3000);
        assertTrue(app.getNotepadHelper().getSavedResult(TEST_FILE_NAME));
    }
}
