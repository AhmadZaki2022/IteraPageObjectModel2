package com.pages.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignupPageTest extends BaseTest {
	//WebDriver driver;

	
	@Test (priority=1)
	public void verifySignupFormTitle()  {
		driver.findElement(By.xpath("//a[normalize-space()='Sign Up']")).click();
		String expectedTitle = "Add new user";
		String actualTitle =  driver.findElement(By.xpath("//h2[normalize-space()='Add new user']")).getText();

		if(expectedTitle.equals(expectedTitle) ) {
			System.out.println("The page title equals the expected title:  " + actualTitle);
		}else {
			System.out.println("The page title is NOT EQUAL--> " + actualTitle);
		}
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test (priority=3)
	public void SignupFormWithValidData() {
		//driver.findElement(By.xpath("//a[normalize-space()='Sign Up']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Emran");
		driver.findElement(By.xpath("//input[@id='Surname']")).sendKeys("Mehrwarz");
		driver.findElement(By.xpath("//input[@id='E_post']")).sendKeys("1234 Main st");
		driver.findElement(By.xpath("//input[@id='Mobile']")).sendKeys("12345451232");
		driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("u$ern@me1");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@id='submit']")).click();

		String expectedValidation = "Registration Successful";
		String actualValidation = driver.findElement(By.xpath("//label[normalize-space()='Registration Successful']")).getText();
		if(actualValidation.equals(expectedValidation))
		{
			System.out.println("The validation message is equals to the expected validation -->  " + actualValidation);
		}else {
			System.out.println("The validation message is NOT EQUAL to the expected validation -->" + actualValidation);
		}
	}

	@Test (priority = 4)
	public void SignupFormWithExixtingUsername() {
		driver.findElement(By.xpath("//a[normalize-space()='Sign Up']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Sayed");
		driver.findElement(By.xpath("//input[@id='Surname']")).sendKeys("Jan");
		driver.findElement(By.xpath("//input[@id='E_post']")).sendKeys("1234 Main st");
		driver.findElement(By.xpath("//input[@id='Mobile']")).sendKeys("21345451232");
		driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("u$ern@me");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("password1");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("password1");
		driver.findElement(By.xpath("//input[@id='submit']")).click();

		String expectedError = "Username already exist";
		String actualError = driver.findElement(By.xpath("//label[normalize-space()='Username already exist']")).getText();

		if(actualError.equals(expectedError)) {
			System.out.println("The message is AS EXPECTED '" + actualError);
		}else {
			System.out.println("The Error message is NOT EQUAL to the expected Error --> " + actualError);
		}
	}

	@Test (priority=5)
	public void SignupFormWithBlankFirstName() {
		driver.findElement(By.xpath("//a[normalize-space()='Sign Up']")).click();

		//driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='Surname']")).sendKeys("Jan");
		driver.findElement(By.xpath("//input[@id='E_post']")).sendKeys("1234 Main st");
		driver.findElement(By.xpath("//input[@id='Mobile']")).sendKeys("21345451232");
		driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("u$ern@me");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("password1");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("password1");
		driver.findElement(By.xpath("//input[@id='submit']")).click();

		String expectedMessage = "Please enter first name";
		String actualMessage = driver.findElement(By.xpath("//span[@id='FirstName-error']")).getText();

		if( expectedMessage == actualMessage ) {
			System.out.println("The message is AS EXPECTED '" + actualMessage + "'.");
		}else {
			System.out.println("The message '" + actualMessage +"' is NOT AS EXPECTED '" + expectedMessage + "'.");
		}
	}

	@Test (priority=6)
	public void SignupFormWithBlankSurname() {
		driver.findElement(By.xpath("//a[normalize-space()='Sign Up']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Emran");
		//	driver.findElement(By.xpath("//input[@id='Surname']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='E_post']")).sendKeys("1234 Main st");
		driver.findElement(By.xpath("//input[@id='Mobile']")).sendKeys("21345451232");
		driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("u$ern@me");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("password1");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("password1");
		driver.findElement(By.xpath("//input[@id='submit']")).click();

		String expectedMessage = "Please enter surname";
		String actualMessage = driver.findElement(By.xpath("//span[@id='Surname-error']")).getText();

		if( expectedMessage == actualMessage ) {
			System.out.println("The message is AS EXPECTED '" + actualMessage + "'.");
		}else {
			System.out.println("The message '" + actualMessage +"' is NOT AS EXPECTED '" + expectedMessage + "'.");
		}
	}

	@Test (priority=7)
	public void SignupFormWithBlankFirstNameAndSurname() {
		driver.findElement(By.xpath("//a[normalize-space()='Sign Up']")).click();

		//		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("");
		//		driver.findElement(By.xpath("//input[@id='Surname']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='E_post']")).sendKeys("1234 Main st");
		driver.findElement(By.xpath("//input[@id='Mobile']")).sendKeys("21345451232");
		driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("u$ern@me");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("password1");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("password1");
		driver.findElement(By.xpath("//input[@id='submit']")).click();

		String expectedMessage1 = "Please enter first name";
		String actualMessage1 = driver.findElement(By.xpath("//span[@id='FirstName-error']")).getText();
		String expectedMessage2 = "Please enter surname";
		String actualMessage2 = driver.findElement(By.xpath("//span[@id='Surname-error']")).getText();

		if( expectedMessage1 == actualMessage1 ) {
			System.out.println("The message is AS EXPECTED '" + actualMessage1 + "'.");
		}else {
			System.out.println("The message '" + actualMessage1 +"' is NOT AS EXPECTED '" + expectedMessage1 + "'.");
		}

		if( expectedMessage2 == actualMessage2 ) {
			System.out.println("The message is AS EXPECTED '" + actualMessage2 + "'.");
		}else {
			System.out.println("The message '" + actualMessage2 +"' is NOT AS EXPECTED '" + expectedMessage2 + "'.");
		}
	}

	

}
