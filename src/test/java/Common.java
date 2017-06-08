import common.HostpitalUrls;
import pages.DoctorPage;
import pages.DoctorResultSearchPage;
import pages.InitPageFactory;
import pages.LoggedHeaderPatientPage;
import pages.ManagerHeaderPage;
import pages.ManagerMainPage;
import pages.ModerationFeedbackPage;
import util.Authentication;
import util.AuthenticationCreds;
import util.DriverManager;

public class Common {

    public static final String FEEDBACK_TEXT = "Eminem is good doctor, very good!!!";
    public static final String DOCTOR_NAME = "Chester";

    public static void goToModerationFeedbacksPageAndModerateFeedback(boolean status) {
        DriverManager.webDriver.get(HostpitalUrls.HOME_PAGE);
        Authentication authentication = new Authentication();
        authentication.login(AuthenticationCreds.MANAGER_LOGIN, AuthenticationCreds.MANAGER_PASSWORD);
        ManagerMainPage managerMainPage = InitPageFactory.init(ManagerMainPage.class);
        managerMainPage.goToModerationFeedbacksPage();
        ModerationFeedbackPage moderationFeedbackPage = InitPageFactory.init(ModerationFeedbackPage.class);
        moderationFeedbackPage.approveFirstFeedback(status);
    }

    public static void logoutPatient() {
        InitPageFactory.init(LoggedHeaderPatientPage.class).logout();
    }

    public static void logoutManager() {
        InitPageFactory.init(ManagerHeaderPage.class).logout();
    }


    public static DoctorPage goToDoctorPage(String doctorName) {
        DriverManager.webDriver.get(HostpitalUrls.HOME_PAGE);
        Authentication authentication = new Authentication();
        authentication.login(AuthenticationCreds.PATIENT_LOGIN, AuthenticationCreds.PATIENT_PASSWORD);
        LoggedHeaderPatientPage header = InitPageFactory.init(LoggedHeaderPatientPage.class);
        header.searchDoctor(doctorName);
        DoctorResultSearchPage doctorResultSearchPage = InitPageFactory.init(DoctorResultSearchPage.class);
        doctorResultSearchPage.goToDoctoPage();
        return InitPageFactory.init(DoctorPage.class);
    }
}
