package pages;

public class CartPage extends BasePage {

    public boolean isProductInCart(String productName) {
        String pageSource = driver.getPageSource()
                .toLowerCase()
                .replaceAll("\\s+", " ");

        String normalizedName = productName
                .toLowerCase()
                .replaceAll("\\s+", " ");

        String shortName = normalizedName.substring(0, Math.min(40, normalizedName.length()));

        System.out.println("Sepette aranacak ürün parçası: " + shortName);

        return pageSource.contains(shortName);
    }
}