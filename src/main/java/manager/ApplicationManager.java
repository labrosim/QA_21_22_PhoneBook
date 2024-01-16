package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    //WebDriver driver;
    EventFiringWebDriver driver;

    HelperUser helperUser;
    HelperContact helperContact;


    public void init(){
        //driver = new ChromeDriver();
        driver = new EventFiringWebDriver(new ChromeDriver());
        logger.info("All tests run in Chrome Browser");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://telranedu.web.app/");
        logger.info("The link ----> "+driver.getCurrentUrl());
        helperUser = new HelperUser(driver);
        helperContact = new HelperContact(driver);
        driver.register(new ListenerWD());

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
