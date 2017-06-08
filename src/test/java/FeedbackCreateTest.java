import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DoctorPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FeedbackCreateTest {

    @BeforeClass
    public static void delete() {
        DbUtil.execute(DbUtil.DELETE_FROM_FEEDBACKS);
    }

    @Test
    public void agoToDoctorPageAndCreateFeedback() {
        DoctorPage doctorPage = Common.goToDoctorPage(Common.DOCTOR_NAME);
        doctorPage.fillInputTextArea(Common.FEEDBACK_TEXT);
        doctorPage.sendFeedback();
        Common.logoutPatient();
        Assert.assertTrue(doctorPage.isNotPresentFeedback());
    }

    @Test
    public void bcheckCreatingFeedback() {
        Common.goToModerationFeedbacksPageAndModerateFeedback(true);
        Common.logoutManager();
        Assert.assertTrue(goToDoctorPageAndCheckText());
    }

    private boolean goToDoctorPageAndCheckText() {
        DoctorPage doctorPage = Common.goToDoctorPage(Common.DOCTOR_NAME);
        return doctorPage.isFillWithTextFirstFeedback(Common.FEEDBACK_TEXT);
    }
}
