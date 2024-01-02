package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver driver) {
        super(driver);
    }

    public void openLoginRegistrationForm() {
        //WebElement loginTab = driver.findElement(By.xpath("//a[text()='LOGIN']"));
        //loginTab.click();

        click(By.xpath("//a[text()='LOGIN']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        //WebElement emailInput = driver.findElement(By.name("email"));
        //emailInput.click();
        //emailInput.clear();
        //emailInput.sendKeys(email);

        type(By.name("email"), email);

        //WebElement passwordInput = driver.findElement(By.xpath("//input[last()]"));
        //passwordInput.click();
        //passwordInput.clear();
        //passwordInput.sendKeys(password);

        type(By.xpath("//input[last()]"), password);
    }

    public void fillLoginRegistrationForm(User user) {
        //WebElement emailInput = driver.findElement(By.name("email"));
        //emailInput.click();
        //emailInput.clear();
        //emailInput.sendKeys(email);

        type(By.name("email"), user.getEmail());

        //WebElement passwordInput = driver.findElement(By.xpath("//input[last()]"));
        //passwordInput.click();
        //passwordInput.clear();
        //passwordInput.sendKeys(password);

        type(By.xpath("//input[last()]"), user.getPassword());
    }

    public void submitLogin() {
        click(By.xpath("//button[text()='Login']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public boolean isNoContactsHereDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions.textToBePresentInElement
                (driver.findElement(By.cssSelector(".contact-page_message__2qafk>h1")), "No Contacts here!"));
    }

    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();

    }
}


















