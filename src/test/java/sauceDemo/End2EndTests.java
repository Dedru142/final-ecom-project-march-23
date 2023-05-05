package sauceDemo;

import org.testng.annotations.Test;
import pages.*;

public class End2EndTests extends BaseTest {
    @Test
    public void test_01_buyItemsTest() {
        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(page);
        productsPage.assertEqualsPageUrl("https://www.saucedemo.com/inventory.html");
        productsPage.validateTitle("Products");
        productsPage.sortItems("Price (low to high)");
        productsPage.sortItems("Name (Z to A)");
        productsPage.sortItems(1);
        productsPage.chooseItem("Sauce Labs Backpack");
        productsPage.validateAddedItems("1");
        productsPage.chooseItem("Sauce Labs Onesie");
        productsPage.validateAddedItems("2");
        productsPage.continueToCart();

        YourCartPage yourCartPage = new YourCartPage(page);
        yourCartPage.assertThatPageUrl("https://www.saucedemo.com/cart.html");
        yourCartPage.validateTitle("Your Cart");
        yourCartPage.continueToCheckout();

        Checkout checkout = new Checkout(page);
        checkout.assertEqualsPageUrl("https://www.saucedemo.com/checkout-step-one.html");
        checkout.validateTitle("Checkout: Your Information");
        checkout.fillCheckoutForm("user", "asd", "123");

        CheckoutOverview checkoutOverview = new CheckoutOverview(page);
        checkoutOverview.assertThatPageUrl("https://www.saucedemo.com/checkout-step-two.html");
        checkoutOverview.validateTitle("Checkout: Overview");
        checkoutOverview.finishOverview();

        CheckoutComplete checkoutComplete = new CheckoutComplete(page);
        checkoutComplete.assertEqualsPageUrl("https://www.saucedemo.com/checkout-complete.html");
        checkoutComplete.validateTitle("Checkout: Complete!");

    }
}
