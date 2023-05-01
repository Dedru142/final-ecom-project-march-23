package sauceDemo.loginTests;

import org.testng.annotations.Test;
import pages.LoginPage;
import sauceDemo.BaseTest;

public class FailedTests extends BaseTest {
    @Test
    public void test_01_lockedOutUser() {
        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("locked_out_user", "secret_sauce");
        loginPage.validateLoginErrorMessage("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void test_02_noUsernameLogin() {
        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("", "secret_sauce");
        loginPage.validateLoginErrorMessage("Epic sadface: Username is required");
    }
}