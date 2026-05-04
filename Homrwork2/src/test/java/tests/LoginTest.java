package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

//    @Test
//    public void test() {
//
//    }

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("bobthebobert@gmail.com", "Bobert123!");
        app.getHelperUser().submitLogin();

        //Assert --> if element with text "Logged in success" is present

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

        //app.getHelperUser().acceptLogin();


    }


    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("bobthebobert@gmail.com", "Bobert123!");
        app.getHelperUser().submitLogin();


        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

        //app.getHelperUser().acceptLogin();


    }

    @AfterMethod
    public void postCondition(){
        app.getHelperUser().acceptLogin();
    }

}
