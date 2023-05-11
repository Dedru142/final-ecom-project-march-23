package sauceDemo.checkoutTests;

import org.testng.annotations.Test;
import pages.*;
import sauceDemo.BaseTest;

public class CheckoutSuccessTests extends BaseTest {

    @Test
    public void test_01_standardUserCheckout() {
        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(page);
        productsPage.assertEqualsPageUrl("https://www.saucedemo.com/inventory.html");
        productsPage.validateTitle("Products");
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
        checkout.fillCheckoutForm("user", "name", "123");

        CheckoutOverview checkoutOverview = new CheckoutOverview(page);
        checkoutOverview.assertThatPageUrl("https://www.saucedemo.com/checkout-step-two.html");
        checkoutOverview.validateTitle("Checkout: Overview");
    }

    @Test
    public void test_02_performanceGlitchUserCheckout() {
        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("performance_glitch_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(page);
        productsPage.assertEqualsPageUrl("https://www.saucedemo.com/inventory.html");
        productsPage.validateTitle("Products");
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
        checkout.fillCheckoutForm("user", "name", "123");

        CheckoutOverview checkoutOverview = new CheckoutOverview(page);
        checkoutOverview.assertThatPageUrl("https://www.saucedemo.com/checkout-step-two.html");
        checkoutOverview.validateTitle("Checkout: Overview");
    }
}
