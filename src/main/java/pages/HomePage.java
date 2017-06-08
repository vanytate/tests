package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageInitializer {

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[4]/a")
    private WebElement loginLink;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickLogin() {
        loginLink.click();
    }
}
