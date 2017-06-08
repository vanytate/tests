package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.DriverManager;

public class DoctorPage extends PageInitializer {

    @FindBy(id = "input-feedback")
    private WebElement inputTextArea;

    @FindBy(id = "sendFeedback")
    private WebElement sendFeedbackButton;

    @FindBy(xpath = "/html/body/section/div/div[2]/div[3]/div/div/div/div[2]")
    private WebElement firstFeedback;

    public DoctorPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillInputTextArea(String text) {
        inputTextArea.sendKeys(text);
    }

    public void sendFeedback() {
        sendFeedbackButton.click();
    }

    public boolean isFillWithTextFirstFeedback(String text) {
        return firstFeedback.isDisplayed() && text.equals(firstFeedback.getText());
    }

    public boolean isNotPresentFeedback() {
        return DriverManager.webDriver.findElements(By.xpath("/html/body/section/div/div[2]/div[3]/div/div/div/div[2]")).size() == 0;
    }

    public boolean isNotPresentSendFeedbackButton() {
        return DriverManager.webDriver.findElements(By.id("sendFeedback")).size() == 0;
    }

    public boolean isPopAppear() {
        return DriverManager.webDriver.findElement(By.xpath("//*[contains(text(), 'Feedback is saved')]")).isDisplayed();
    }
}
