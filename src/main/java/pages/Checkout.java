package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Checkout extends BasePage {
    private final Locator continueButtonElement = page.locator("[data-test=\"continue\"]");

    private final Locator firstNameElement = page.locator("[data-test=\"firstName\"]");
    private final Locator lastNameElement = page.locator("[data-test=\"lastName\"]");
    private final Locator postalCodeElement = page.locator("[data-test=\"postalCode\"]");
    private final Locator pageTitleElement = page.locator("[class=\"title\"]");

    public Checkout(Page page) {
        super(page);
    }

    public void validateTitle(String expectedTitle) {
        this.checkElementText(pageTitleElement, expectedTitle);
    }

    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        this.typeText(firstNameElement, firstName);
        this.fillText(lastNameElement, lastName);
        this.typeText(postalCodeElement, postalCode);
        this.clickElement(continueButtonElement);
    }

    public void continueToOverview() {
        this.clickElement(continueButtonElement);
    }
}
