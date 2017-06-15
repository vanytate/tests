package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoctorPage extends PageInitializer {

    @FindBy(id = "input-feedback")
    private WebElement inputTextArea;

    @FindBy(id = "sendFeedback")
    private WebElement sendFeedbackButton;

    @FindBy(xpath = "/html/body/section/div/div[2]/div[4]/div/div/div/div[2]")
    @Getter
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
        return webDriver.findElements(By.xpath("/html/body/section/div/div[2]/div[3]/div/div/div/div[2]")).size() == 0;
    }

    public boolean isNotPresentSendFeedbackButton() {
        return webDriver.findElements(By.id("sendFeedback")).size() == 0;
    }

    public boolean isPopUpDisplayed() {
        return webDriver.findElement(By.id("informSuccess")).isDisplayed();
    }
}
