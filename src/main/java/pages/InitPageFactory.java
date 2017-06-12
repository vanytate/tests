package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.DriverManager;

public class InitPageFactory {

    public static <T> T init(WebDriver webDriver, Class<T> page) {
        return PageFactory.initElements(webDriver, page);
    }
}
