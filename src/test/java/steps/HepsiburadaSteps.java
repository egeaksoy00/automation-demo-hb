package steps;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.Step;
import driver.DriverFactory;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchResultsPage;

public class HepsiburadaSteps {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    private String selectedProductName;

    @Step("Hepsiburada ana sayfası açılır")
    public void openHomePage() throws InterruptedException {
        homePage.openHomePage();
        Thread.sleep(3000);
    }

    @Step("Kullanıcı giriş sayfasına gider")
    public void goToLoginPage() throws InterruptedException {
        homePage.goToLoginPage();
        Thread.sleep(3000);
    }

    @Step("Kullanıcı geçerli bilgilerle login dener")
    public void loginWithValidCredentials() throws InterruptedException {
        String email = System.getenv("HB_EMAIL");
        String password = System.getenv("HB_PASSWORD");

        loginPage.login(email, password);
        Thread.sleep(3000);
    }

    @Step("Login sonucu kontrol edilir ve ana sayfaya dönülür")
    public void checkLoginResultAndReturnHome() throws InterruptedException {
        if (loginPage.isLoginErrorDisplayed()) {
            System.out.println("Login sonrası N1E2 / güvenlik hatası alındı. Ana sayfaya dönülüyor.");
        }

        homePage.openHomePage();
        Thread.sleep(3000);
    }

    @Step("Kullanıcı <keyword> araması yapar")
    public void searchProduct(String keyword) throws InterruptedException {
        homePage.searchProduct(keyword);
        Thread.sleep(3000);
    }

    @Step("Arama sonuçlarının listelendiği doğrulanır")
    public void verifySearchResults() {
        if (!searchResultsPage.areProductsListed()) {
            throw new RuntimeException("Arama sonuçları listelenmedi.");
        }
    }

    @Step("İkinci satırdaki ilk ürün seçilir")
    public void selectSecondRowFirstProduct() throws InterruptedException {
        searchResultsPage.clickSecondRowFirstProduct();
        Thread.sleep(3000);
    }

    @Step("Ürün sepete eklenir")
    public void addProductToCart() throws InterruptedException {
        selectedProductName = productPage.getProductTitle();
        System.out.println("Seçilen ürün: " + selectedProductName);

        productPage.addToCart();
        Thread.sleep(3000);
    }

    @Step("Sepete git butonuna tıklanır")
    public void goToCart() throws InterruptedException {
        productPage.goToCart();
        Thread.sleep(3000);
    }

    @Step("Eklenen ürünün sepette olduğu doğrulanır")
    public void verifyProductInCart() {
        if (cartPage.isProductInCart(selectedProductName)) {
            System.out.println("Ürün sepette doğrulandı.");
        } else {
            throw new RuntimeException("Ürün sepette bulunamadı.");
        }
    }

    @AfterScenario
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}