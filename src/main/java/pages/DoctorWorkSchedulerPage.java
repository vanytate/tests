package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoctorWorkSchedulerPage extends PageInitializer {

    @FindBy(xpath = "//*[@id=\"scheduler_here\"]/div[4]/div[3]/div[1]")
    //*[@id="scheduler_here"]/div[4]/div[3]/div[1]
    private WebElement event;

    public DoctorWorkSchedulerPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void doubleClickEvent() {
        Actions action = new Actions(webDriver);
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 345);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(event));
        action.doubleClick(event).perform();
    }
}
