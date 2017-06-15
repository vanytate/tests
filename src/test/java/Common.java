import common.HostpitalUrls;
import org.openqa.selenium.WebDriver;
import pages.DoctorPage;
import pages.DoctorResultSearchPage;
import pages.InitPageFactory;
import pages.LoggedHeaderPatientPage;
import pages.ManagerHeaderPage;
import pages.ManagerMainPage;
import pages.ModerationFeedbackPage;
import util.Authentication;
import util.AuthenticationCreds;

public class Common {

    public static final String FEEDBACK_TEXT = "Eminem is good doctor, very good!!!";
    public static final String DOCTOR_NAME = "Chester";

    public static void goToModerationFeedbacksPageAndModerateFeedback(WebDriver webDriver, boolean status) {
        login(webDriver, AuthenticationCreds.MANAGER_LOGIN, AuthenticationCreds.MANAGER_PASSWORD);
        ManagerMainPage managerMainPage = InitPageFactory.init(webDriver, ManagerMainPage.class);
        managerMainPage.goToModerationFeedbacksPage();
        ModerationFeedbackPage moderationFeedbackPage = InitPageFactory.init(webDriver, ModerationFeedbackPage.class);
        moderationFeedbackPage.approveFirstFeedback(status);
    }

    public static void logoutPatient(WebDriver webDriver) {
        InitPageFactory.init(webDriver, LoggedHeaderPatientPage.class).logout();
    }

    public static void logoutManager(WebDriver webDriver) {
        InitPageFactory.init(webDriver, ManagerHeaderPage.class).logout();
    }

    public static DoctorPage goToDoctorPage(WebDriver webDriver, String doctorName) {
        login(webDriver, AuthenticationCreds.PATIENT_LOGIN, AuthenticationCreds.PATIENT_PASSWORD);
        LoggedHeaderPatientPage header = InitPageFactory.init(webDriver, LoggedHeaderPatientPage.class);
        header.searchDoctor(doctorName);
        DoctorResultSearchPage doctorResultSearchPage = InitPageFactory.init(webDriver, DoctorResultSearchPage.class);
        doctorResultSearchPage.goToDoctoPage();
        return InitPageFactory.init(webDriver, DoctorPage.class);
    }

    private static void login(WebDriver webDriver, String login, String password) {
        webDriver.get(HostpitalUrls.HOME_PAGE);
        Authentication authentication = new Authentication();
        authentication.login(webDriver, login, password);
    }
}
