package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerHeaderPage extends PageInitializer {

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[5]/a")
    private WebElement headerName;

    @FindBy(id = "logout")
    private WebElement logoutLink;

    public ManagerHeaderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void logout() {
        headerName.click();
        logoutLink.click();
    }
}
