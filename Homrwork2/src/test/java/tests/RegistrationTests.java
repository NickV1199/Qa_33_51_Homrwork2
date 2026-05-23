package tests;

import models.User;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("Before method finished logout");

        }

    }


    @Test
    public void registrationSuccess(){

        logger.info("Start test with name 'registrationSuccess'");

        int z = (int) ((System.currentTimeMillis() / 1000) % 360);
        System.out.println(z);


        User user = new User()
                .setName("Ziza")
                .setLastName("Snow")
                .setEmail("ziza" + z + "@gmail.com")
                .setPassword("Snow12345678!");

        logger.info("Test data --->  name: 'Ziza', lastName: 'Snow', email: 'ziza" + z + "@gmail.com', password: 'Snow12345678!'");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");

        logger.info("Assert check: is element message 'You are logged in success' displayed");
    }

    //***********************NEGATIVE************************************

    @Test
    public void registrationEmptyName(){
        logger.info("Start test with name 'registrationEmptyName'");

        User user = new User()
                .setName("")
                .setLastName("Snow")
                .setEmail("snow@gmail.com")
                .setPassword("Snow12345678!");

        logger.info("Test data --->  name: ' ', lastName: 'Snow', email: 'snow@gmail.com', password: 'Snow12345678!'");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(),"Name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

        logger.info("Assert check: is element error 'Name is required' displayed and is element 'Yalla' button is not active");
    }

    @Test
    public void registrationEmptyLastName(){
        logger.info("Start test with name 'registrationEmptyLastName'");
        User user = new User()
                .setName("Liza")
                .setLastName("")
                .setEmail("snow@gmail.com")
                .setPassword("Snow12345678!");

        logger.info("Test data --->  name: 'Liza', lastName: ' ', email: 'snow@gmail.com', password: 'Snow12345678!'");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(),"Last name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

        logger.info("Assert check: is element error 'Last name is required' displayed and is element 'Yalla' button is not active");
    }

    @Test
    public void registrationEmptyPassword(){
        logger.info("Start test with name 'registrationEmptyPassword'");
        User user = new User()
                .setName("Liza")
                .setLastName("Snow")
                .setEmail("snow@gmail.com")
                .setPassword("");

        logger.info("Test data --->  name: 'Liza', lastName: 'Snow', email: 'snow@gmail.com', password: ' '");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

        logger.info("Assert check: is element error 'Password is required' displayed and is element 'Yalla' button is not active");
    }

    @Test
    public void registrationEmptyEmail(){
        logger.info("Start test with name 'registrationEmptyEmail'");

        User user = new User()
                .setName("Liza")
                .setLastName("Snow")
                .setEmail("")
                .setPassword("Snow12345678!");

        logger.info("Test data --->  name: 'Liza', lastName: 'Snow', email: ' ', password: 'Snow12345678!'");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(),"Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

        logger.info("Assert check: is element error 'Email is required' displayed and is element 'Yalla' button is not active");
    }


    @Test
    public void registrationWrongEmail(){
        logger.info("Start test with name 'registrationWrongEmail'");

                User user = new User()
                .setName("Lisa")
                .setLastName("Snow")
                .setEmail("snowgmail.com")
                .setPassword("Snow12345678!");

        logger.info("Test data --->  name: 'Liza', lastName: 'Snow', email: 'snowgmail.com', password: 'Snow12345678!'");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        //Assert.assertEquals(app.getHelperUser().getErrorText(),"Wrong email format\n" +
        //        "Wrong email format");
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("Wrong email format"));
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

        logger.info("Assert check: is element error 'Wrong email format' displayed and is element 'Yalla' button is not active");
    }

    @Test
    public void registrationWrongPassword(){
        logger.info("Start test with name 'registrationWrongPassword'");

        User user = new User()
                .setName("Lisa")
                .setLastName("Snow")
                .setEmail("snow@gmail.com")
                .setPassword("Snow");

        logger.info("Test data --->  name: 'Liza', lastName: 'Snow', email: 'snow@gmail.com', password: 'Snow'");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password must contain minimum 8 symbols\n" +
                "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

        logger.info("Assert check: is element error 'Password must contain minimum 8 symbols\\n\" +\n" +
                "                \"Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]' displayed and is element 'Yalla' button is not active");
    }

    @Test
    public void registrationExistingUser(){
        logger.info("Start test with name 'registrationExistingUser'");

        User user = new User()
                .setName("Lisa")
                .setLastName("Snow")
                .setEmail("snow@gmail.com")
                .setPassword("Snow12345678!");

        logger.info("Test data --->  name: 'Liza', lastName: 'Snow', email: 'snow@gmail.com', password: 'Snow12345678!'");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"\"User already exists\"");

        logger.info("Assert check: is element message 'User already exists' displayed");


    }


    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }




}
