package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        //if Sign out presents --> logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }
    }

    @Test
    public void loginSuccess1() {
        User user = new User().setEmail("qwe@d.com").setPassword("Ff12345$");
        logger.info("Start test with name `loginSuccess`");
        logger.info("Test data ---> email: `qwe@d.com` & password `Ff12345$`");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button `Sign Out` present");
    }
        @Test
    public void loginSuccess(){
            logger.info("Test data ---> email: `qwe@d.com` & password `Ff12345$`");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("qwe@d.com", "Ff12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
            logger.info("Assert check is Element button `Sign Out` present");


        //Assert.assertEquals();
        //Assert.assertNotEquals();
        //Assert.assertTrue();
        //Assert.assertFalse();

    }
    @Test
    public void loginSuccessModel(){
        logger.info("Test data ---> email: `qwe@d.com` & password `Ff12345$`");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("qwe@d.com", "Ff12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button `Sign Out` present");


        //Assert.assertEquals();
        //Assert.assertNotEquals();
        //Assert.assertTrue();
        //Assert.assertFalse();

    }
    @Test
    public void loginWrongEmail(){
        logger.info("Test data ---> email: `qwed.com` & password `Ff12345$`");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("qwed.com", "Ff12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresents("Wrong email or password"));
        logger.info("Assert check is alert with error text `Wrong email or password`");
    }
    @Test
    public void loginWrongPassword(){
        logger.info("Test data ---> email: `qwe@d.com` & password `Ff123`");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("qwe@d.com", "Ff123");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresents("Wrong email or password"));
        logger.info("Assert check is alert with error text `Wrong email or password`");
    }
    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data ---> email: `qwe123321@d.com` & password `KKFf12345$`");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("qwe123321@d.com", "KKFf12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isAlertPresents("Wrong email or password"));
        logger.info("Assert check is alert with error text `Wrong email or password`");
    }
    //Assert.assertEquals();
    //Assert.assertNotEquals();
    //Assert.assertTrue();
    //Assert.assertFalse();
}
