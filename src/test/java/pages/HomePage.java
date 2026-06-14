package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private By accountMenu = By.xpath("//*[contains(text(),'Giriş Yap')]");
    private By loginButtonInPopup = By.xpath("//a[contains(text(),'Giriş Yap') or .//span[contains(text(),'Giriş Yap')]]");
    private By acceptCookieButton = By.id("hb-accept-all");
    
    
    public void openHomePage() {
        driver.get("https://www.hepsiburada.com");
    }

    public void goToLoginPage() {
        hover(accountMenu);
        click(loginButtonInPopup);
    }
    public void acceptCookiesIfVisible() {
        System.out.println("Cookie aranıyor...");

        if (isElementVisible(acceptCookieButton, 3)) {
            System.out.println("Cookie bulundu.");

            jsClick(waitVisible(acceptCookieButton));
            System.out.println("Cookie click edildi.");
        } else {
            System.out.println("Cookie görünmedi, devam ediliyor.");
        }
    }
}