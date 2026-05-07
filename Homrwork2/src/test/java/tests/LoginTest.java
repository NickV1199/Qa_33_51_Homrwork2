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
        }
    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("bobthebobert@gmail.com","Bobert123!");
        app.getHelperUser().submit();
        //Assert--> if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        //app.getHelperUser().clickOkButton();
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
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("bobthebobertgmail.com","Bobert123!");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("bobthebobert@gmail.com","Bobert123");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
    }

    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("luna@gmail.com","Luck123456$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
    }



    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }

}