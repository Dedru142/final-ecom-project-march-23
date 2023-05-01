package sauceDemo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeMethod
    protected void setupTest() {
        System.out.println("Opening browser...");
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome")
        );
        page = browser.newPage();
    }

    @AfterMethod
    protected void tearDown() {
        System.out.println("Closing browser...");
        page.waitForTimeout(2000);
        page.close();
        browser.close();
        playwright.close();
    }
}
