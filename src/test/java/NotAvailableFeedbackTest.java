import common.HostpitalUrls;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DoctorPage;
import pages.DoctorResultSearchPage;
import pages.InitPageFactory;
import pages.LoggedHeaderPatientPage;
import util.Authentication;
import util.AuthenticationCreds;

import static org.hamcrest.core.Is.is;


public class NotAvailableFeedbackTest extends BaseClass {

    private static final String PATIENT_LOGIN = "patient.sf@hospitals.ua";
    private static final String PATIETN_PASSWORD = "1111";
    private static final String DOCTOR_NAME = "Chester";

    @BeforeMethod
    public void insert() {
        DbUtil.execute(DbUtil.INSERT_INTO_FEEDBACKS);
    }

    @Test
    public void checkFeedbacks() {
        DoctorPage doctorPage = goToDoctorPage(AuthenticationCreds.PATIENT_LOGIN, AuthenticationCreds.PATIENT_PASSWORD);
        Assert.assertFalse(doctorPage.isNotPresentSendFeedbackButton());
        logoutPatient();
    }

    @Test
    public void checkFeedbacksAvailable() {
        DoctorPage doctorPage = goToDoctorPage(PATIENT_LOGIN, PATIETN_PASSWORD);
        Assert.assertTrue(doctorPage.isNotPresentSendFeedbackButton());
        logoutPatient();
    }

    @Test
    public void checkCreatingFeedback() {
        Common.goToModerationFeedbacksPageAndModerateFeedback(webDriver, true);
        Common.logoutManager(webDriver);
        DoctorPage doctorPage = Common.goToDoctorPage(webDriver, Common.DOCTOR_NAME);
//        Assert.assertTrue(doctorPage.isFillWithTextFirstFeedback(Common.FEEDBACK_TEXT));
        org.junit.Assert.assertThat(doctorPage.getFirstFeedback().getText(), is(Common.FEEDBACK_TEXT));
    }

    private DoctorPage goToDoctorPage(String login, String password) {
        webDriver.get(HostpitalUrls.HOME_PAGE);
        Authentication authentication = new Authentication();
        authentication.login(webDriver, login, password);
        LoggedHeaderPatientPage header = InitPageFactory.init(webDriver, LoggedHeaderPatientPage.class);
        header.searchDoctor(DOCTOR_NAME);
        DoctorResultSearchPage doctorResultSearchPage = InitPageFactory.init(webDriver, DoctorResultSearchPage.class);
        doctorResultSearchPage.goToDoctoPage();
        return InitPageFactory.init(webDriver, DoctorPage.class);
    }

    private void logoutPatient() {
        InitPageFactory.init(webDriver, LoggedHeaderPatientPage.class).logout();
    }
}
