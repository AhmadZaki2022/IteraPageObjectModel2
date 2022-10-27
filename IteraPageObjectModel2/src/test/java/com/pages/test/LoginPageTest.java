package com.pages.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
	
	@Test
	//public void loginForm() {
		

		public void completeFormValidInformation() {
			//driver.findElement(By.xpath("//a[normalize-space()='Sign Up']")).click();
			driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Adam");
			driver.findElement(By.xpath("//input[@id='Surname']")).sendKeys("Hawa");
			driver.findElement(By.xpath("//input[@id='E_post']")).sendKeys("Ah@gmail.com");
			driver.findElement(By.xpath("//input[@id='Mobile']")).sendKeys("555");
			driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("Ahmad");
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Example@123");

			driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Example@123");
			driver.findElement(By.xpath("//input[@id='submit']")).click();
		}
	}


