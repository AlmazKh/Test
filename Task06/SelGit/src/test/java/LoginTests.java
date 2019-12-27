import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import ru.itis.Settings;
import ru.itis.User;

public class LoginTests extends TestBase{

    @Test
    @SneakyThrows
    public void LoginWithValidData() {
        User user = User
                .builder()
                .login(Settings.getValue("login"))
                .password(Settings.getValue("password"))
                .build();
        applicationManager.getLoginHelper().login(user);

        Assert.assertEquals(user.getLogin(), applicationManager.getLoginHelper().getUser().getLogin());
    }

    @Test
    @SneakyThrows
    public void LoginWithInvalidData() {
        User user = User
                .builder()
                .login(Settings.getValue("InvalidLogin"))
                .password(Settings.getValue("InvalidPassword"))
                .build();
        applicationManager.getLoginHelper().login(user);

        Assert.assertNull(applicationManager.getLoginHelper().getUser());
    }
}
