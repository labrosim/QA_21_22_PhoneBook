package manager;

import models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver driver) {
        super(driver);
    }

    public void openContactForm() {
        click(By.xpath("//a[text()='ADD']"));
    }

    public void fillContactForm(Contacts contacts) {
        type(By.cssSelector("[placeholder='Name']"), contacts.getName());
        type(By.cssSelector("[placeholder='Last Name']"),contacts.getLastName());
        type(By.cssSelector("[placeholder='Phone']"),contacts.getPhone());
        type(By.cssSelector("[placeholder='email']"),contacts.getEmail());
        type(By.cssSelector("[placeholder='Address']"),contacts.getAddress());
        type(By.cssSelector("[placeholder='description']"),contacts.getDescription());
    }

    public void submitSaveButton() {
        click(By.xpath("//b[text()='Save']"));
    }
}
