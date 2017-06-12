import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DoctorPage;
import util.DriverManager;

public class InformationPopUpTest {

    private WebDriver webDriver;

    @BeforeMethod
    public void delete() {
        webDriver = DriverManager.create();
        DbUtil.execute(DbUtil.DELETE_FROM_FEEDBACKS);
    }

    @Test
    public void checkIfPopAppear() {
        DoctorPage doctorPage = Common.goToDoctorPage(webDriver, Common.DOCTOR_NAME);
        doctorPage.fillInputTextArea(Common.FEEDBACK_TEXT);
        doctorPage.sendFeedback();
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("informSuccess"))
        );
        Assert.assertTrue(doctorPage.isPopUpDisplayed());
    }

    @AfterMethod
    public void destructor() {
        DbUtil.execute(DbUtil.DELETE_FROM_FEEDBACKS);
        webDriver.quit();
    }
}
