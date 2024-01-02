package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;

    HelperUser helperUser;
    HelperContact helperContact;


    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://telranedu.web.app/");
        helperUser = new HelperUser(driver);
        helperContact = new HelperContact(driver);

    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperContact getHelperContact() {
        return helperContact;
    }

    public void stop(){
        driver.quit();
    }
}
