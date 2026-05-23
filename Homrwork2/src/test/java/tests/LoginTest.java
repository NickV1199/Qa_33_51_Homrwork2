package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("Before method finished logout");

        }

    }

    @Test
    public void loginSuccess(){

        logger.info("Start test with name 'loginSuccess'");
        logger.info("Test data --->  email: 'bobthebobert@gmail.com' & password: 'Bobert123!'");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("bobthebobert@gmail.com","Bobert123!");
        app.getHelperUser().submit();
        //Assert--> if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        //app.getHelperUser().clickOkButton();


        logger.info("Assert check is element message 'Logged in success' is displayed");
    }

//    @Test
//    public void loginSuccessModel(){
//        app.getHelperUser().openLoginForm();
//        app.getHelperUser().fillLoginForm("margo@gmail.com","Mmar123456$");
//        app.getHelperUser().submitLogin();
//        //Assert--> if element with text "Logged in success" is present
//        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
//       // app.getHelperUser().clickOkButton();
//    }

    @Test
    public void loginWrongEmail(){

        logger.info("Start test with name 'loginWrongEmail'");
        logger.info("Test data --->  email: 'bobthebobertgmail.com' & password: 'Bobert123!'");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("bobthebobertgmail.com","Bobert123!");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

        logger.info("Assert check is element error 'It'snot look like email' is displayed and is element 'Yalla' button is not active");
    }

    @Test
    public void loginWrongPassword(){
        logger.info("Start test with name 'loginWrongPassword'");
        logger.info("Test data --->  email: 'bobthebobertgmail.com' & password: 'Bobert123'");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("bobthebobert@gmail.com","Bobert123");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");

        logger.info("Assert check is element message 'Login or Password incorrect' is displayed");

    }

    @Test
    public void loginUnregisteredUser(){
        logger.info("Start test with name 'loginUnregisteredUser'");
        logger.info("Test data --->  email: 'luna@gmail.com' & password: 'Luck123456$'");


        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("luna@gmail.com","Luck123456$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");

        logger.info("Assert check is element message 'Login or Password incorrect' is displayed");
    }



    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }

}