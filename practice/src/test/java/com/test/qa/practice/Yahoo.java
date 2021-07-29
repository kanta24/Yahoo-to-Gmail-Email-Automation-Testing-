package com.test.qa.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Yahoo extends DriverSetup{
	
	public static String baseURL = "https://www.yahoo.com";
	public static String actualText = "Hello";
	public static String expectedText;
	
	@BeforeTest
	public static void YahooTest() throws InterruptedException{
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		driver.findElement(By.xpath("//a[@class='_yb_199f6']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("s.kanta24@yahoo.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='login-passwd']")).sendKeys("saka1234");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
		Thread.sleep(1000);
	}


	@Test(priority=1)
	public static void validateLogin() throws InterruptedException{
		element = driver.findElement(By.xpath("//span[@role='presentation']"));
		String user = element.getText();
		if(user.equals("Kanta")) {
			AssertJUnit.assertTrue(true);
		}else {
			AssertJUnit.fail();
		}
	}
	
	
	@Test(priority=2)
	public static void sendMail() throws InterruptedException{
		driver.findElement(By.xpath("//a[contains(@class,'_yb_b4xff')][normalize-space()='Mail']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[normalize-space()='Compose']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='message-to-field']")).sendKeys("johnanaconda6@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Hello");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label='Message body']//div")).sendKeys("Hello World");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[normalize-space()='Send']")).click();
		Thread.sleep(1000);
	}
	
	@Test (priority=3)
	public static void validateSendMail() throws InterruptedException{
		
		driver.findElement(By.xpath("//a[@class='W_6D6F C_Z281SGl D_F u_b']")).click();
		expectedText = driver.findElement(By.xpath("//span[@data-test-id='message-group-subject-text']")).getText();
		if (expectedText.equalsIgnoreCase(actualText)) {
			System.out.println("Successfully send message");
			Assert.assertTrue(true);
		} else {
			System.out.println("There will be problem.Try another way");
			Assert.assertTrue(false);
		}
	}

	
	@Test(priority=4)
	public static void logOutYahoo() throws InterruptedException{
		Actions action = new Actions(driver);
	
        action.clickAndHold(driver.findElement(By.xpath("//label[@id='ybarAccountMenuOpener']"))).build().perform();
		driver.findElement(By.xpath("//a[@class='_yb_tdi30 _yb_po6e2 _yb_m78yl _yb_16g61 _yb_1delc']")).click();
		Thread.sleep(3000);
	} 

}







