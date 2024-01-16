package manager;

import com.google.common.io.Files;
import models.Contacts;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver driver) {
        super(driver);
    }

    public void openContactForm() {
        click(By.xpath("//a[text()='ADD']"));
    }

    public void fillContactForm(Contacts contacts) {
        type(By.cssSelector("[placeholder='Name']"), contacts.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contacts.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contacts.getPhone());
        type(By.cssSelector("[placeholder='email']"), contacts.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contacts.getAddress());
        type(By.cssSelector("[placeholder='description']"), contacts.getDescription());
    }
    public void saveContact() {
        click(By.cssSelector(".add_form__2rsm2>button"));
    }
//    public void submitSaveButton() {
//        click(By.xpath("//b[text()='Save']"));
//    }

    public boolean iscontactAddedByName(String name) {
        List<WebElement> list = driver.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean iscontactAddedByPhone(String phone) {
        List<WebElement> list = driver.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAddPageStillDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }

    public void getScreen(String link) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File tmp = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp, new File(link));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int removeOneContact() {
        int before = countOfContacts();
        logger.info("Number of contacts list before remove is --->" + before);
        removeContact();

        int after = countOfContacts();
        logger.info("Number of contacts list after remove is --->" + after);
        return before - after;
    }

    private void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[text()='Remove']"));
        pause(1000);
    }

    private int countOfContacts() {
        //return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        List<WebElement> list = driver.findElements(By.cssSelector(".contact-item_card__2SOIM"));
        int res = list.size();
        return res;
    }

    public void removeAllContacts() {
        while (driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() != 0) {
            removeContact();
        }
    }

    public void provideContacts() {
        if (countOfContacts() < 3) {
            for (int i = 0; i < 3; i++) {
                //addNewContact
                addOneContact();
            }
        }
    }

    private void addOneContact() {
        int i = new Random().nextInt(1000) + 1000;
        Contacts contact = Contacts.builder()
                .name("Garry" + i)
                .lastName("Potter")
                .address("Hogw")
                .email("harry" + i + "@gmail.com")
                .phone("55588999" + i)
                .description("Friend")


                .build();

        openContactForm();
        fillContactForm(contact);
        saveContact();
        pause(1000);
    }

}
