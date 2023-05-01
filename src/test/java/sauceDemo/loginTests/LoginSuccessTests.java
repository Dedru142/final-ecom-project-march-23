package sauceDemo.loginTests;

import org.testng.annotations.Test;
import pages.LoginPage;
import sauceDemo.BaseTest;

public class LoginSuccessTests extends BaseTest {

    @Test
    public void test_01_StandardUserLogin() {
        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("standard_user", "secret_sauce");
    }

    @Test
    public void test_02_ProblemUserLogin() {
        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("problem_user", "secret_sauce");
    }
}
