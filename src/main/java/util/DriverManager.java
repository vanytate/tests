package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    public static WebDriver webDriver;

    static {
        System.setProperty("webdriver.chrome.driver","/home/george/Snapshots/Projects/IdeaProjects/TestForScheduler/src/lib/chromedriver");
        webDriver = new ChromeDriver();
    }
}
