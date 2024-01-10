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

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contacts);
        app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
        //app.getHelperContact().pause(1500);
        app.getHelperContact().submitSaveButton();

        Assert.assertTrue(app.getHelperContact().iscontactAddedByName(contacts.getName()));
        Assert.assertTrue(app.getHelperContact().iscontactAddedByPhone(contacts.getPhone()));

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
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contacts);
        //app.getHelperContact().pause(1500);
        app.getHelperContact().submitSaveButton();
        Assert.assertTrue(app.getHelperContact().iscontactAddedByName(contacts.getName()));
        Assert.assertTrue(app.getHelperContact().iscontactAddedByPhone(contacts.getPhone()));

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

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contacts);
        //app.getHelperContact().pause(1500);
        app.getHelperContact().submitSaveButton();

        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
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

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contacts);
        //app.getHelperContact().pause(1500);
        app.getHelperContact().submitSaveButton();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
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

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contacts);
       // app.getHelperContact().pause(1500);
        app.getHelperContact().submitSaveButton();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());

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

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contacts);
       // app.getHelperContact().pause(1500);
        app.getHelperContact().submitSaveButton();
        Assert.assertTrue(app.getHelperContact().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact()
                .isAlertPresents(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
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

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contacts);
        //app.getHelperContact().pause(1500);
        app.getHelperContact().submitSaveButton();
        Assert.assertTrue(app.getHelperContact()
                .isAlertPresents("Email not valid: must be a well-formed email address"));
    }
}
