package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class YourCartPage extends BasePage {

    private final Locator pageTitleElement = page.locator("[class=\"title\"]");
    private final Locator checkoutElement = page.locator("[data-test=\"checkout\"]");

    public YourCartPage(Page page) {
        super(page);
    }

    public void validateTitle(String expectedTitle) {
        this.checkElementText(pageTitleElement, expectedTitle);
    }

    public void continueToCheckout() {
        this.clickElement(checkoutElement);
    }

}
