package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        //if Sign out presents --> logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }
    }

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000);

        //int i = (int)(System.currentTimeMillis()/1000%3600);
        User user = new User().setEmail("Zxcv" + i + "@mail.com").setPassword("Asdf1452$");
        logger.info("Start tests --> RegistrationSuccess");
        logger.info("Test data --> email: `Zxcv + i + @mail.com` & password: `Asdf1452$`");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert --> Button Sign Out is present");
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
        logger.info("Assert --> Page `No contacts here` is displayed");

    }

    @Test(description = "Bug report #123456, Fixed")
    public void registrationWrongEmail() {
        Random random = new Random();
        int i = random.nextInt(1000);

        //int i = (int)(System.currentTimeMillis()/1000%3600);

        logger.info("Test data --> email `dontmail.com` & password: `Asdf1452$`");
        User user = new User().setEmail("dontmail.com").setPassword("Asdf1452$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresents("Wrong email or password"));
        logger.info("Assert --> `Wrong email or password` is displayed");

    }

    @Test
    public void registrationWrongPassword() {
        Random random = new Random();
        int i = random.nextInt(1000);


        logger.info("Test data --> email `dont + i + @mail.com` & password: `Aa145`");
        User user = new User().setEmail("dont" + i + "@mail.com").setPassword("Aa145");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresents("Wrong email or password"));
        logger.info("Assert --> `Wrong email or password` is displayed");

    }

    @Test
    public void registrationExistsUser() {


        logger.info("Test data --> email `qwe@d.com` & password: `Ff12345$`");
        User user = new User().setEmail("qwe@d.com").setPassword("Ff12345$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresents("User already exist"));
        logger.info("Assert --> `User already exist` is displayed");

    }
}
