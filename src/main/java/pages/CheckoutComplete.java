package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutComplete extends BasePage {

    private final Locator pageTitleElement = page.locator("[class=\"title\"]");

    public CheckoutComplete(Page page) {
        super(page);
    }

    public void validateTitle(String expectedTitle) {
        this.checkElementText(pageTitleElement, expectedTitle);
    }
}
