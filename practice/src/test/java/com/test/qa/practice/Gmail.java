package com.test.qa.practice;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class Gmail extends Yahoo {
	public static String baseURL = "http://www.gmail.com";
	
	
	@Test(priority=5)
	public static void gmailLogin() throws InterruptedException{
		
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("johnanaconda6@gmail.com");
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("smith#1234");
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		
		Thread.sleep(10000);
	}

}
