package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By accountMenu = By.xpath("//*[contains(text(),'Giriş Yap')]");
    private By loginButtonInPopup = By.xpath("//a[contains(text(),'Giriş Yap') or .//span[contains(text(),'Giriş Yap')]]");

    public void openHomePage() {
        driver.get("https://www.hepsiburada.com");
    }

    public void goToLoginPage() {
        hover(accountMenu);
        click(loginButtonInPopup);
    }
}