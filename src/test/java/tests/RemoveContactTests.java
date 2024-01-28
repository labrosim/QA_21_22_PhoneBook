package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("qwe@d.com").setPassword("Ff12345$"));
            logger.info("Before method --> User is logged in");
        }
        //if list <3 ===>add 3 contacts

        app.getHelperContact().provideContacts();
        logger.info("Added 3 new contacts");
    }


    @Test(groups = {"smoke"})
    public void removeOneContact() {
        Assert.assertEquals(app.getHelperContact().removeOneContact(), 1);
        logger.info("Assert --> One contact is removed");
        //Assert size list less by one
    }

    @Test
    public void removeAllContacts() {
        app.getHelperContact().removeAllContacts();
        Assert.assertEquals(app.getHelperUser().getMessage(),"No Contacts here!");
        logger.info("Assert --> `No Contacts here!`");
        //"No contacts here"
    }
}
