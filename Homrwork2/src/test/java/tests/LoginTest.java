package tests;

import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void test() {

    }

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("bobthebobert@gmail.com", "Bobert123!");
        app.getHelperUser().submitLogin();
        app.getHelperUser().acceptLogin();


    }

}
