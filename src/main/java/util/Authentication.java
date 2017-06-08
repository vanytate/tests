package util;

import pages.HomePage;
import pages.InitPageFactory;
import pages.LoginPage;

public class Authentication {

    public void login(String email, String password) {
        HomePage homePage = InitPageFactory.init(HomePage.class);
        homePage.clickLogin();
        LoginPage loginPage = InitPageFactory.init(LoginPage.class);
        loginPage.inputCredsAndClickLogin(email, password);
    }

    public void logout() {

    }
}
