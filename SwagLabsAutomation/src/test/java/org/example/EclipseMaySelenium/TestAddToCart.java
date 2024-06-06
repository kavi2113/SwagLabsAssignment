package org.example.EclipseMaySelenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAddToCart {
	
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

        // Verify item is in the cart
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        if (cartBadge.getText().equals("1")) {
            System.out.println("Add to cart functionality works");
        } else {
            System.out.println("Add to cart functionality failed");
        }

        driver.quit();
    }

   
}
