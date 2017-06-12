package util;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.InitPageFactory;
import pages.LoginPage;

public class Authentication {

    public void login(WebDriver webDriver, String email, String password) {
        HomePage homePage = InitPageFactory.init(webDriver, HomePage.class);
        homePage.clickLogin();
        LoginPage loginPage = InitPageFactory.init(webDriver, LoginPage.class);
        loginPage.inputCredsAndClickLogin(email, password);
    }
}
