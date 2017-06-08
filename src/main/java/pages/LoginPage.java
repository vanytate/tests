package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageInitializer {

    @FindBy(id = "email")
    private WebElement emailTextInput;

    @FindBy(id = "password")
    private WebElement passwordTextInput;

    @FindBy(id = "loginSubmit")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void inputCredsAndClickLogin(String email, String password) {
        emailTextInput.sendKeys(email);
        passwordTextInput.sendKeys(password);
        loginButton.click();
    }
}
