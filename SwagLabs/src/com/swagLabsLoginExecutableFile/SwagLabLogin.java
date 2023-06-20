package com.swagLabsLoginExecutableFile;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SwagLabLogin {
	
	public static WebDriver driver;

	@Given("^launch swag labs application$")
	public void applicationOpen() {
		System.setProperty("webdriver.chrome.driver", "Browser//chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		

		
		
	}
	
	@When("^login to the application with valid or invalid \"([^\"]*)\" and \"([^\"]*)\"$")  
	public void swagLabsLogin(String arg1, String arg2) {
		driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys(arg1);
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys(arg2);
		driver.findElement(By.cssSelector("input[id='login-button'][name='login-button']")).click();
	    
	}
	
	
	
	@Then ("^order a product from item list and enter valid information$")
	public void validateCheckout() {
		
		//Add item to the cart
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		
		//Go to cart
		driver.findElement(By.cssSelector("div>a[class='shopping_cart_link']")).click();
		
		//click checkout
		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
		//Enter information
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("Ria");
		driver.findElement(By.cssSelector("input[id='last-name']")).sendKeys("Singh");
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("560003");
		
		driver.findElement(By.cssSelector("input[id='continue'][name='continue']")).click();
		
		
		driver.findElement(By.xpath("//button[text()='Finish']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Back Home')]")).click();
		
	
	}
	
	@Then("^validate the homepage$")
	public void validateHomePage() throws InterruptedException{
		
		Select filter1= new Select(driver.findElement(By.cssSelector("select[class='product_sort_container']")));
		filter1.selectByVisibleText("Name (Z to A)");
		
		Select filter2= new Select(driver.findElement(By.cssSelector("select[class='product_sort_container']")));
		filter2.selectByVisibleText("Price (low to high)");
		
		Select filter3= new Select(driver.findElement(By.cssSelector("select[class='product_sort_container']")));
		filter3.selectByVisibleText("Price (high to low)");
		
		Select filter4= new Select(driver.findElement(By.cssSelector("select[class='product_sort_container']")));
		filter4.selectByVisibleText("Name (A to Z)");


		
		
		//Add item to cart
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        
		
		
		//click menu button
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		//
		driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']")).click();
		driver.findElement(By.xpath("//a[contains(@id,'reset_sidebar_link')]")).click();
		driver.findElement(By.xpath("//a[contains(@id,'about_sidebar_link')]")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//a[contains(@id,'logout_sidebar_link')]")).click();

	}
	
	
	

	

	



	
	

}
