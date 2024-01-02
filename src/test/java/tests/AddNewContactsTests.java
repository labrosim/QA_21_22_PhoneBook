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
        Contacts contacts = Contacts.builder()
                .name("Emma")
                .lastName("Cold")
                .phone("123654987742")
                .email("ghj@yug.io")
                .address("Argentina")
                .description("favourite")
                .build();
        Thread.sleep(3000);
        app.getHelperContact().openContactForm();
        Thread.sleep(3000);
        app.getHelperContact().fillContactForm(contacts);
        app.getHelperContact().submitSaveButton();


    }

    @Test
    public void addNewContactSuccess() throws InterruptedException {
        Contacts contacts = Contacts.builder()
                .name("Emma")
                .lastName("Cold")
                .phone("123654987741")
                .email("ghj@yug.io")
                .address("Argentina")
                .build();
        app.getHelperContact().openContactForm();
        Thread.sleep(3000);
        app.getHelperContact().fillContactForm(contacts);
        app.getHelperContact().submitSaveButton();
        Thread.sleep(3000);
    }
}
