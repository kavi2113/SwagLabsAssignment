package org.example.EclipseMaySelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class TestLogin {
	
	 public static void login(WebDriver driver, String username, String password) {
	        WebElement usernameField = driver.findElement(By.id("user-name"));
	        usernameField.sendKeys(username);

	        WebElement passwordField = driver.findElement(By.id("password"));
	        passwordField.sendKeys(password);

	        WebElement loginButton = driver.findElement(By.id("login-button"));
	        loginButton.click();

	        try {
	            driver.findElement(By.className("inventory_list"));
	            System.out.println("Login successful");
	        } catch (Exception e) {
	            System.out.println("Login failed");
	        }

	        // Go back to the login page for the next test
	        driver.get("https://www.saucedemo.com/");
	    }
    public static void main(String[] args) {
    	
    	String projectDir=System.getProperty("user.dir");
		String browserDriverPath=projectDir+"\\src\\main\\resources\\browserDrivers\\"; 
		System.setProperty("webdriver.chrome.driver", browserDriverPath+"chromedriver125.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        // Test with valid credentials
        login(driver, "standard_user", "secret_sauce");

        // Test with invalid credentials
        login(driver, "standard_user", "wrong_password");

        driver.quit();
    }

   
}