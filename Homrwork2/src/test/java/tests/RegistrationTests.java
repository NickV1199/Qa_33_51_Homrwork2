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
        }
    }


    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        System.out.println(i);
        System.out.println("=================");

        int z = (int) ((System.currentTimeMillis() / 1000) % 360);
        System.out.println(z);


        User user = new User()
                .setName("Lisa")
                .setLastName("Snow")
                .setEmail("snow" + z + "@gmail.com")
                .setPassword("Snow12345678!");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");
    }

    @Test
    public void registrationWrongEmail(){
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        System.out.println(i);
        System.out.println("=================");

        int z = (int) ((System.currentTimeMillis() / 1000) % 360);
        System.out.println(z);


        User user = new User()
                .setName("Lisa")
                .setLastName("Snow")
                .setEmail("snow" + z + "gmail.com")
                .setPassword("Snow12345678!");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(),"Wrong email format\n" +
                "Wrong email format");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void registrationWrongPassword(){
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        System.out.println(i);
        System.out.println("=================");

        int z = (int) ((System.currentTimeMillis() / 1000) % 360);
        System.out.println(z);


        User user = new User()
                .setName("Lisa")
                .setLastName("Snow")
                .setEmail("snow" + z + "@gmail.com")
                .setPassword("Snow");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password must contain minimum 8 symbols\n" +
                "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void registrationExistingUser(){
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        System.out.println(i);
        System.out.println("=================");

        int z = (int) ((System.currentTimeMillis() / 1000) % 360);
        System.out.println(z);


        User user = new User()
                .setName("Lisa")
                .setLastName("Snow")
                .setEmail("snow" + z + "@gmail.com")
                .setPassword("Snow12345678!");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"\"User already exists\"");
    }


    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }




}
