package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedHeaderPatientPage extends PageInitializer {

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[5]/a")
    private WebElement headerNameLink;

    @FindBy(id = "logout")
    private WebElement headerDropdownLogoutLink;

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[7]/a")
    private WebElement searchLink;

    @FindBy(id = "select_doctor_search")
    private WebElement inputDoctorName;

    @FindBy(id = "select_doctor_search_button")
    private WebElement buttonSearch;

    public LoggedHeaderPatientPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void logout() {
//        WebDriverWait wait = new WebDriverWait(webDriver, 15);
//        wait.until(
//                ExpectedConditions.not(
//                        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("informSuccess"))
//                )
//        );
        headerNameLink.click();
        headerDropdownLogoutLink.click();
    }

    public void searchDoctor(String name) {
        searchLink.click();
        inputDoctorName.sendKeys(name);
        buttonSearch.click();
    }
}
