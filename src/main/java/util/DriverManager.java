package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    static {
        System.setProperty("webdriver.chrome.driver","/home/george/Snapshots/Projects/IdeaProjects/TestForScheduler/src/lib/chromedriver");
    }

    public static WebDriver create() {
        return new ChromeDriver();
    }
}
