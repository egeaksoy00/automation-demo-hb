package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends BasePage {

    private By loginButton = By.xpath("//span[contains(text(),'Giriş Yap')]");

    private By searchBox = By.cssSelector("input[type='text']");


    public void openHomePage() {
        driver.get("https://www.hepsiburada.com");
    }


    public void clickLoginButton() {
        click(loginButton);
    }


    public void searchProduct(String product) {
        type(searchBox, product);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
    }
}