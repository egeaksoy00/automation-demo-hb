package tests;

import driver.DriverFactory;
import pages.HomePage;

public class TestHomePage {

    public static void main(String[] args) {

        try {
            HomePage homePage = new HomePage();

            homePage.openHomePage();

            Thread.sleep(3000);

            homePage.goToLoginPage();

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            DriverFactory.quitDriver();
        }
    }
}