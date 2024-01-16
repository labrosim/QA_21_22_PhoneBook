package tests;

import models.Contacts;
import models.User;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AddNewContactsTests extends TestBase {

    @BeforeClass
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("qwe@d.com").setPassword("Ff12345$"));
            logger.info("Before class --> User is logged in");
        }
    }

    @Test
    public void addNewContactSuccessAll() throws InterruptedException {
        int i = (int) (System.currentTimeMillis() / 1000 % 3600);
        Contacts contacts = Contacts.builder()
                .name("Emma"+i)
                .lastName("Cold")
                .phone("1236583" + i)
                .email("ghj@yug.io")
                .address("Argentina")
                .description("all fields")
                .build();

        logger.info("Test data --> name: `Emma+i` & lastname: `Cold` & phone: `1236583 + i` " +
                "& email: `ghj@yug.io` & address: `Argentina` & description `all fields`");
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contacts);
        app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
        //app.getHelperContact().pause(1500);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().iscontactAddedByName(contacts.getName()));
        logger.info("Assert --> `Contact is added by name`");
        Assert.assertTrue(app.getHelperContact().iscontactAddedByPhone(contacts.getPhone()));
        logger.info("Assert --> `Contact is added by phone`");

    }

    @Test
    public void addNewContactSuccess() throws InterruptedException {
        int i = (int) (System.currentTimeMillis() / 1000 % 3600);
        Contacts contacts = Contacts.builder()
                .name("EmmaReg"+i)
                .lastName("Cold")
                .phone("123654987741")
                .email("ghj@yug.io")
                .address("Argentina")
                .build();
        logger.info("Test data --> name: `Emma+i` & lastname: `Cold` & phone: `1236583 + i` " +
                "& email: `ghj@yug.io` & address: `Argentina`");
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contacts);
        //app.getHelperContact().pause(1500);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().iscontactAddedByName(contacts.getName()));
        logger.info("Assert --> `Contact is added by name`");
        Assert.assertTrue(app.getHelperContact().iscontactAddedByPhone(contacts.getPhone()));
        logger.info("Assert --> `Contact is added by phone`");

    }

    @Test
    public void addNewContactWrongName() {
        Contacts contacts = Contacts.builder()
                .name("")
                .lastName("Cold")
                .phone("12365854643")
                .email("ghj@yug.io")
                .address("Argentina")
                .description("empty name")
                .build();
        logger.info("Test data --> name: `` & lastname: `Cold` & phone: `12365854643` " +
                "& email: `ghj@yug.io` & address: `Argentina` & description `empty address`");
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contacts);
        //app.getHelperContact().pause(1500);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        logger.info("Assert --> `Add Page is Still Displayed`");
    }

    @Test
    public void addNewContactWrongAddress() {
        Contacts contacts = Contacts.builder()
                .name("Tony")
                .lastName("Cold")
                .phone("12365854643")
                .email("ghj@yug.io")
                .address("")
                .description("empty address")
                .build();
        logger.info("Test data --> name: `Tony` & lastname: `Cold` & phone: `12365854643` " +
                "& email: `ghj@yug.io` & address: `` & description `empty address`");
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contacts);
        //app.getHelperContact().pause(1500);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        logger.info("Assert --> `Add Page is Still Displayed`");
    }

    @Test
    public void addNewContactWrongLastName() {
        Contacts contacts = Contacts.builder()
                .name("Tony")
                .lastName("")
                .phone("12365854643")
                .email("ghj@yug.io")
                .address("Argentina")
                .description("empty last name")
                .build();
        logger.info("Test data --> name: `Tony` & lastname: `` & phone: `12365854643` " +
                "& email: `ghj@yug.io` & address: `Argentina` & description `empty last name`");
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contacts);
       // app.getHelperContact().pause(1500);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        logger.info("Assert --> `Add Page is Still Displayed`");
    }

    @Test
    public void addNewContactWrongPhone() {
        Contacts contacts = Contacts.builder()
                .name("Tony")
                .lastName("Cold")
                .phone("21154")
                .email("ghj@yug.io")
                .address("Argentina")
                .description("empty phone")
                .build();
        logger.info("Test data --> name: `Tony` & lastname: `Cold` & phone: `21154` " +
                "& email: `ghj@yug.io` & address: `Argentina` & description `empty phone`");
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contacts);
       // app.getHelperContact().pause(1500);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        logger.info("Assert --> `Add Page is Still Displayed`");
        Assert.assertTrue(app.getHelperContact()
                .isAlertPresents(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
        logger.info("Assert --> `Phone not valid: Phone number must contain only digits! And length min 10, max 15!`");
    }

    @Test
    public void addNewContactWrongEmail() {
        Contacts contacts = Contacts.builder()
                .name("Tony")
                .lastName("Cold")
                .phone("12365854643")
                .email("ghjyug.io")
                .address("Argentina")
                .description("wrong email")
                .build();
        logger.info("Test data --> name: `Tony` & lastname: `Cold` & phone: `12365854643` " +
                "& email: `ghjyug.io` & address: `Argentina` & description `wrong email`");
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contacts);
        //app.getHelperContact().pause(1500);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact()
                .isAlertPresents("Email not valid: must be a well-formed email address"));
        logger.info("Assert --> `Email not valid: must be a well-formed email address`");
    }
}
