package manager;

import com.google.common.io.Files;
import models.Contacts;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

    public boolean iscontactAddedByName(String name) {
        List<WebElement>list = driver.findElements(By.cssSelector("h2"));
        for (WebElement el:list){
            if(el.getText().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean iscontactAddedByPhone(String phone) {
        List<WebElement>list = driver.findElements(By.cssSelector("h3"));
        for (WebElement el:list){
            if(el.getText().equals(phone)){
                return true;
            }
        }
        return false;
    }

    public boolean isAddPageStillDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }

    public void getScreen(String link) {
        TakesScreenshot takesScreenshot  = (TakesScreenshot) driver;
        File tmp = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp,new File(link));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
