package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModerationFeedbackPage extends PageInitializer {

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div/div[3]/div/label[1]")
    private WebElement approveFeedbackButton;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div/div[3]/div/label[2]")
    private WebElement rejectFeedbackButton;

    public ModerationFeedbackPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void approveFirstFeedback(boolean status) {
        if (status) {
            approveFeedbackButton.click();
        } else {
            rejectFeedbackButton.click();
        }
    }
}
