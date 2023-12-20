package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void type(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        if(text != null){
            element.sendKeys(text);
        }
    }

    public void click(By locator){
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public boolean isElementPresent(By locator){
        List<WebElement> list = driver.findElements(locator);
        return list.size() > 0;
    }

    public boolean isAlertPresents(String message) {
        Alert alert = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        if(alert != null && alert.getText().contains(message)){
            //click OK
            alert.accept();
            //click cancel --> alert.dismiss();
            //type into alert --> alert.sendKeys();
            return true;
        }
        return false;
    }
}
