package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoctorHomePage extends PageInitializer {

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[5]/a")
    private WebElement workSchedulerLink;

    public DoctorHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickToWorkSchedulerLink() {
        workSchedulerLink.click();
    }
}
