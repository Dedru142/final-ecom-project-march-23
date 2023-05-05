package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutOverview extends BasePage {

    private final Locator finishButtonElement = page.locator("[data-test=\"finish\"]");
    private final Locator pageTitleElement = page.locator("[class=\"title\"]");

    public CheckoutOverview(Page page) {
        super(page);
    }

    public void validateTitle(String expectedTitle) {
        this.checkElementText(pageTitleElement, expectedTitle);
    }

    public void finishOverview() {
        this.clickElement(finishButtonElement);
    }

}
