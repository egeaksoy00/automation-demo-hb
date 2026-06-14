package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By emailInput = By.id("txtUserName");
    private By passwordInput = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");

    public void enterEmail(String email) {
        type(emailInput, email);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }
    public void login(String email, String password) {
        if (email == null || password == null) {
            throw new RuntimeException("HB_EMAIL veya HB_PASSWORD environment variable olarak tanımlı değil.");
        }

        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}