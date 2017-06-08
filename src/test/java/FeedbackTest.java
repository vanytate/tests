import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DoctorPage;

@RunWith(Suite.class)
@Suite.SuiteClasses( { FeedbackCreateTest.class, NotAvailableFeedbackTest.class  })
public class FeedbackTest {

    @BeforeMethod
    public void delete() {
        DbUtil.execute(DbUtil.DELETE_FROM_FEEDBACKS);
    }

    @Test
    public void checkIfItsNotVisibleBlockedFeedback() {
        DoctorPage doctorPage = Common.goToDoctorPage(Common.DOCTOR_NAME);
        doctorPage.fillInputTextArea(Common.FEEDBACK_TEXT);
        doctorPage.sendFeedback();
        Common.logoutPatient();
        Common.goToModerationFeedbacksPageAndModerateFeedback(false);
        Common.logoutManager();
        doctorPage = Common.goToDoctorPage(Common.DOCTOR_NAME);
        Common.logoutPatient();
        Assert.assertTrue(doctorPage.isNotPresentFeedback());
    }

    @Test
    public void checkIfItsNotAvailableSendButtonIfFeedbackIsBlocked() {
        DoctorPage doctorPage = Common.goToDoctorPage(Common.DOCTOR_NAME);
        doctorPage.fillInputTextArea(Common.FEEDBACK_TEXT);
        doctorPage.sendFeedback();
        Common.logoutPatient();
        Common.goToModerationFeedbacksPageAndModerateFeedback(false);
        Common.logoutManager();
        doctorPage = Common.goToDoctorPage(Common.DOCTOR_NAME);
        Common.logoutManager();
        Assert.assertTrue(doctorPage.isNotPresentSendFeedbackButton());
    }

    @AfterClass
    public static void closeBrowser() {
//        DriverManager.webDriver.quit();
    }
}
