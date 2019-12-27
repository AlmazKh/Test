import lombok.SneakyThrows;
import ru.itis.Settings;
import ru.itis.User;

public class AuthTestBase extends TestBase {

    @Override
    @SneakyThrows
    public void setUp() {
        super.setUp();

        applicationManager.getLoginHelper().login(
                User.builder()
                        .login(Settings.getValue("login"))
                        .password(Settings.getValue("password"))
                        .build()
        );
    }
}
