package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    private By productTitle = By.cssSelector("h1");
    private By addToCartButton = By.cssSelector("[data-test-id='addToCart']");
    private By goToCartButton = By.xpath("//button[normalize-space()='Sepete git']");

    public String getProductTitle() {
        return getText(productTitle);
    }

    public void addToCart() {
        System.out.println("Sepete ekle butonu aranıyor...");

        WebElement button = waitVisible(addToCartButton);

        System.out.println("Sepete ekle butonu bulundu.");

        jsClick(button);

        System.out.println("Sepete ekle butonuna tıklandı.");
    }

    public void goToCart() {
        System.out.println("Sepete git butonu aranıyor...");

        WebElement button = waitClickable(goToCartButton);

        System.out.println("Sepete git butonu bulundu.");

        jsClick(button);

        System.out.println("Sepete git butonuna tıklandı.");
    }
}