import models.User;
import org.testng.annotations.Test;
import org.testng.Assert;

public class RegistrationTests extends TestBase {

    @Test
    public void registrationPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "Teli",
                "Viva",
                "tlv_" + i + "@cit.com",
                "$T234543a"
        );

        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
    }

    @Test
    public void registrationNegativeInvalidName() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "",
                "Viva",
                "tlv_" + i + "@cit.com",
                "$T234543a"
        );

        openRegistrationForm();
        fillRegistrationForm1(user);
        Assert.assertTrue(isErrorMessageDisplayed2());
        // submitRegistration();
    }

    @Test
    public void registrationNegativeInvalidLastName() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "Teli",
                "",
                "tlv_" + i + "@cit.com",
                "$T234543a"
        );

        openRegistrationForm();
        fillRegistrationForm1(user);
        Assert.assertTrue(isErrorMessageDisplayed3());
        // submitRegistration();
    }


@Test
    public void registrationNegativeInvalidEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "Teli",
                "Viva",
                "t@lv_" + i + "@cit.com",
                "$T234543a"
        );

        openRegistrationForm();
        fillRegistrationForm1(user);
        Assert.assertTrue(isErrorMessageDisplayed());
    //submitRegistration();
    }

    @Test
    public void registrationNegativeInvalidPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "Mila",
                "Vara",
                "tlv_" + i + "@lav.com",
                "тек2345096"
        );

        openRegistrationForm();
        fillRegistrationForm1(user);
        submitRegistration();
        Assert.assertTrue(isErrorMessageDisplayed4());

    }
}
