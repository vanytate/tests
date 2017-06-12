import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DoctorPage;
import util.DriverManager;

public class FeedbackTest {

    private WebDriver webDriver;

    @BeforeMethod
    public void delete() {
        webDriver = DriverManager.create();
        DbUtil.execute(DbUtil.DELETE_FROM_FEEDBACKS);
    }

    @Test
    public void checkIfItsNotVisibleBlockedFeedback() {
        DoctorPage doctorPage = Common.goToDoctorPage(webDriver, Common.DOCTOR_NAME);
        doctorPage.fillInputTextArea(Common.FEEDBACK_TEXT);
        doctorPage.sendFeedback();
        Common.logoutPatient(webDriver);
        Common.goToModerationFeedbacksPageAndModerateFeedback(webDriver, false);
        Common.logoutManager(webDriver);
        doctorPage = Common.goToDoctorPage(webDriver, Common.DOCTOR_NAME);
        Common.logoutPatient(webDriver);
        Assert.assertTrue(doctorPage.isNotPresentFeedback());
    }

    @Test
    public void checkIfItsNotAvailableSendButtonIfFeedbackIsBlocked() {
        DoctorPage doctorPage = Common.goToDoctorPage(webDriver, Common.DOCTOR_NAME);
        doctorPage.fillInputTextArea(Common.FEEDBACK_TEXT);
        doctorPage.sendFeedback();
        Common.logoutPatient(webDriver);
        Common.goToModerationFeedbacksPageAndModerateFeedback(webDriver, false);
        Common.logoutManager(webDriver);
        doctorPage = Common.goToDoctorPage(webDriver, Common.DOCTOR_NAME);
        Common.logoutPatient(webDriver);
        Assert.assertTrue(doctorPage.isNotPresentSendFeedbackButton());
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.quit();
    }
}
