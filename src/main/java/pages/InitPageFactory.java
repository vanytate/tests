package pages;

import org.openqa.selenium.support.PageFactory;
import util.DriverManager;

public class InitPageFactory {

    public static <T> T init(Class<T> page) {
        return PageFactory.initElements(DriverManager.webDriver, page);
    }
}
