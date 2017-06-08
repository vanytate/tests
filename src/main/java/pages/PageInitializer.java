package pages;

import org.openqa.selenium.WebDriver;

public abstract class PageInitializer {

    WebDriver webDriver;

    public PageInitializer(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
