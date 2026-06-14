package tests;

import driver.DriverFactory;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchResultsPage;

public class TestHomePage {

    public static void main(String[] args) {

        try {
            HomePage homePage = new HomePage();
            LoginPage loginPage = new LoginPage();
            SearchResultsPage searchResultsPage = new SearchResultsPage();
            ProductPage productPage = new ProductPage();
            CartPage cartPage = new CartPage();

            String email = System.getenv("HB_EMAIL");
            String password = System.getenv("HB_PASSWORD");

            homePage.openHomePage();
            Thread.sleep(3000);

            homePage.goToLoginPage();
            Thread.sleep(3000);

            loginPage.login(email, password);
            Thread.sleep(3000);

            if (loginPage.isLoginErrorDisplayed()) {
                System.out.println("Login sonrası N1E2 / güvenlik hatası alındı. Ana sayfaya dönülüyor.");
            }

            homePage.openHomePage();
            Thread.sleep(3000);

            homePage.searchProduct("bilgisayar");
            Thread.sleep(3000);

            if (!searchResultsPage.areProductsListed()) {
                throw new RuntimeException("Arama sonuçları listelenmedi.");
            }

            searchResultsPage.clickSecondRowFirstProduct();
            Thread.sleep(3000);

            String selectedProductName = productPage.getProductTitle();
            System.out.println("Seçilen ürün: " + selectedProductName);

            productPage.addToCart();
            Thread.sleep(3000);

            productPage.goToCart();
            Thread.sleep(3000);

            if (cartPage.isProductInCart(selectedProductName)) {
                System.out.println("Ürün sepette doğrulandı.");
            } else {
                throw new RuntimeException("Ürün sepette bulunamadı.");
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            DriverFactory.quitDriver();
        }
    }
}