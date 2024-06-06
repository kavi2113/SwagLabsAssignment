package org.example.EclipseMaySelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCheckoutForm {
	
	 public static void login(WebDriver driver) {
	        WebElement usernameField = driver.findElement(By.id("user-name"));
	        usernameField.sendKeys("standard_user");

	        WebElement passwordField = driver.findElement(By.id("password"));
	        passwordField.sendKeys("secret_sauce");

	        WebElement loginButton = driver.findElement(By.id("login-button"));
	        loginButton.click();
	    }
	 
    public static void main(String[] args) {
    	String projectDir=System.getProperty("user.dir");
		String browserDriverPath=projectDir+"\\src\\main\\resources\\browserDrivers\\"; 
		System.setProperty("webdriver.chrome.driver", browserDriverPath+"chromedriver125.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        // Login
        login(driver);

        // Add first item to cart
        WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        addToCartButton.click();

        // Go to cart
        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();

        // Checkout
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        // Fill the checkout form
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("John");
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Doe");
        WebElement postalCode = driver.findElement(By.id("postal-code"));
        postalCode.sendKeys("12345");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        // Check if the checkout process continues
        try {
            driver.findElement(By.className("summary_info"));
            System.out.println("Checkout form functionality works");
        } catch (Exception e) {
            System.out.println("Checkout form functionality failed");
        }

        driver.quit();
    }

   
}