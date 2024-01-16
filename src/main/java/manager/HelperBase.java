package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelperBase {

    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(HelperBase.class);

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }



    public void click(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public boolean isElementPresent(By locator) {
        List<WebElement> list = driver.findElements(locator);
        return list.size() > 0;
    }

    public boolean isAlertPresents(String message) {
        Alert alert = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        if (alert != null && alert.getText().contains(message)) {
            //click OK
            alert.accept();
            //click cancel --> alert.dismiss();
            //type into alert --> alert.sendKeys();
            return true;
        }
        return false;
    }
    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void type(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        clearNew(element);
        if (text != null) {
            System.out.println("hello");
            element.sendKeys(text);
        }


    }


    public void clearNew(WebElement element) {
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);

    }

    public String getMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".contact-page_message__2qafk>h1"))));
        return  driver.findElement(By.cssSelector(".contact-page_message__2qafk>h1")).getText();
    }

}
