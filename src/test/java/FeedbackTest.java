import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DoctorPage;

public class FeedbackTest extends BaseClass {

    @Test
    public void checkIfItsNotVisibleBlockedFeedback() {
        DoctorPage doctorPage = getDoctorPage();
        Assert.assertTrue(doctorPage.isNotPresentFeedback());
    }

    @Test
    public void agoToDoctorPageAndCreateFeedback() {
        DoctorPage doctorPage = Common.goToDoctorPage(webDriver, Common.DOCTOR_NAME);
        doctorPage.fillInputTextArea(Common.FEEDBACK_TEXT);
        doctorPage.sendFeedback();
        Assert.assertFalse(doctorPage.isNotPresentFeedback());
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
        Assert.assertTrue(doctorPage.isPopUpDisplayed(),"uuu");
    }

    @Test
    public void checkIfItsNotAvailableSendButtonIfFeedbackIsBlocked() {
        DoctorPage doctorPage = getDoctorPage();
        Assert.assertTrue(doctorPage.isNotPresentSendFeedbackButton());
    }

    private DoctorPage getDoctorPage() {
        DoctorPage doctorPage = Common.goToDoctorPage(webDriver, Common.DOCTOR_NAME);
        doctorPage.fillInputTextArea(Common.FEEDBACK_TEXT);
        doctorPage.sendFeedback();
        Common.logoutPatient(webDriver);
        Common.goToModerationFeedbacksPageAndModerateFeedback(webDriver, false);
        Common.logoutManager(webDriver);
        doctorPage = Common.goToDoctorPage(webDriver, Common.DOCTOR_NAME);
        Common.logoutPatient(webDriver);
        return doctorPage;
    }
}
