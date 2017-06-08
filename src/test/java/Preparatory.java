import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import util.DriverManager;

@RunWith(Suite.class)
@Suite.SuiteClasses( { FeedbackCreateTest.class, FeedbackTest.class, NotAvailableFeedbackTest.class  })
public class Preparatory {

    @After
    public static void tearDown() {
        DriverManager.webDriver.quit();
    }
}
