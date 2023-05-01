package sauceDemo;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

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

    }
}
