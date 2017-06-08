import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DoctorPage;

public class InformationPopUpTest {

    @BeforeMethod
    public static void delete() {
        DbUtil.execute(DbUtil.DELETE_FROM_FEEDBACKS);
    }

    @Test
    public void checkIfPopAppear() {
        DoctorPage doctorPage = Common.goToDoctorPage(Common.DOCTOR_NAME);
        doctorPage.fillInputTextArea(Common.FEEDBACK_TEXT);
        doctorPage.sendFeedback();
        Assert.assertTrue(doctorPage.isPopAppear());
//        Common.logoutPatient();
    }

    @AfterClass
    public static void destructor() {
        DbUtil.execute(DbUtil.DELETE_FROM_FEEDBACKS);
    }
}
