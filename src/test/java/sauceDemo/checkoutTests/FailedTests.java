package sauceDemo.checkoutTests;

import org.testng.annotations.Test;
import pages.Checkout;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;
import sauceDemo.BaseTest;

public class FailedTests extends BaseTest {

    @Test
    public void test_01_noFirstnameUserCheckout() {
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
        checkout.fillCheckoutForm("", "name", "123");
        checkout.validateCheckoutErrorMessage("Error: First Name is required");
    }

    @Test
    public void test_02_noLastnameUserCheckout() {
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
        checkout.fillCheckoutForm("user", "", "123");
        checkout.validateCheckoutErrorMessage("Error: Last Name is required");
    }

    @Test
    public void test_03_noPostalCodeUserCheckout() {
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
        checkout.fillCheckoutForm("user", "name", "");
        checkout.validateCheckoutErrorMessage("Error: Postal Code is required");
    }

}
