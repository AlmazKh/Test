import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import ru.itis.User;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GeneratedFileTest {
    private static final String EXPECTED_PASSWORD = "HaIRAcCOB";
    private static final String EXPECTED_LOGIN = "a8fAjDDC2";

    @Test
    public void testXml() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        User user = xmlMapper.readValue(new File("testLoginData.xml"), User.class);
        assertEquals(EXPECTED_PASSWORD, user.getPassword());
        assertEquals(EXPECTED_LOGIN, user.getLogin());
    }
}
