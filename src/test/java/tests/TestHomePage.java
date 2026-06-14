package tests;

import driver.DriverFactory;
import pages.HomePage;
import pages.LoginPage;

public class TestHomePage {

    public static void main(String[] args) {

    	try {
    	    HomePage homePage = new HomePage();
    	    LoginPage loginPage = new LoginPage();

    	    String email = System.getenv("HB_EMAIL");
    	    String password = System.getenv("HB_PASSWORD");

    	    //kontrol için
    	    System.out.println("EMAIL = " + System.getenv("HB_EMAIL"));
    	    System.out.println("PASSWORD = " + System.getenv("HB_PASSWORD"));
    	    
    	    homePage.openHomePage();

    	    Thread.sleep(3000);

    	    homePage.goToLoginPage();

    	    Thread.sleep(3000);

    	    loginPage.login(email, password);

    	    Thread.sleep(5000);

    	} catch (Exception e) {
    	    e.printStackTrace();
    	}finally {
            DriverFactory.quitDriver();
        }
    }
}