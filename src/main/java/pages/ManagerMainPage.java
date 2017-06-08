package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerMainPage extends PageInitializer {

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[4]/a")
    private WebElement actionsDropdown;

    @FindBy(xpath = "//*[@id=\"dropdawn\"]/li[3]/a")
    private WebElement moderationFeedbacksLink;

    public void goToModerationFeedbacksPage() {
        actionsDropdown.click();
        moderationFeedbacksLink.click();
    }

    public ManagerMainPage(WebDriver webDriver) {
        super(webDriver);
    }
}
