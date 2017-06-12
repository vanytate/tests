import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DoctorPage;
import util.DriverManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FeedbackCreateTest {

    private static WebDriver webDriver;

    @BeforeClass
    public static void delete() {
        webDriver = DriverManager.create();
        DbUtil.execute(DbUtil.DELETE_FROM_FEEDBACKS);
    }

    @Test
    public void agoToDoctorPageAndCreateFeedback() {
        DoctorPage doctorPage = Common.goToDoctorPage(webDriver, Common.DOCTOR_NAME);
        doctorPage.fillInputTextArea(Common.FEEDBACK_TEXT);
        doctorPage.sendFeedback();
        Common.logoutPatient(webDriver);
        Assert.assertTrue(doctorPage.isNotPresentFeedback());
    }

    @Test
    public void bcheckCreatingFeedback() {
        Common.goToModerationFeedbacksPageAndModerateFeedback(webDriver, true);
        Common.logoutManager(webDriver);
        Assert.assertTrue(goToDoctorPageAndCheckText());
        Common.logoutPatient(webDriver);
    }

    @AfterClass
    public void close() {
        webDriver.quit();
    }

    private boolean goToDoctorPageAndCheckText() {
        DoctorPage doctorPage = Common.goToDoctorPage(webDriver, Common.DOCTOR_NAME);
        return doctorPage.isFillWithTextFirstFeedback(Common.FEEDBACK_TEXT);
    }
}
