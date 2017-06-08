package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoctorResultSearchPage extends PageInitializer {

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/div[1]/div[1]/div/div[1]/a")
    private WebElement firstResultSearch;

    public DoctorResultSearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void goToDoctoPage() {
        firstResultSearch.click();
    }
}
