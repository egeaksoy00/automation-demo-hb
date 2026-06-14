package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage {

    private By productLinks = By.cssSelector("a[href*='-p-']");

    public boolean areProductsListed() {
        return waitVisible(productLinks).isDisplayed();
    }

    public void clickSecondRowFirstProduct() {
        List<WebElement> products = driver.findElements(productLinks);

        if (products.size() < 5) {
            throw new RuntimeException("Yeterli ürün bulunamadı.");
        }

        WebElement secondRowFirstProduct = products.get(4);
        jsClick(secondRowFirstProduct);

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
    }
    
}