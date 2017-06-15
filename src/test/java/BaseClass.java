import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.DriverManager;

public abstract class BaseClass extends Object {

    protected WebDriver webDriver;

    @BeforeMethod
    public void init() {
        webDriver = DriverManager.create();
        DbUtil.execute(DbUtil.DELETE_FROM_FEEDBACKS);
    }

    @AfterMethod
    public void close() {
        webDriver.quit();
    }
}
