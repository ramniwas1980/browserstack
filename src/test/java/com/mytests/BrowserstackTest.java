package com.mytests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserstackTest extends BrowserStackBaseTest {

	

	@Test(priority = 1)
	public void GoogleTitleTest() {
		driver.get("https://www.google.co.in/");
		String title=driver.getTitle();
	   Assert.assertEquals(title, "Google");
	
	}

	@Test(priority = 2)
	public void gmailTitleTest() {
		driver.get("https://www.google.co.in/");
		driver.findElement(By.xpath("//a[normalize-space()='Gmail']")).click();
		String titletext=driver.getTitle();
		Assert.assertEquals(titletext, "Gmail");
	}

}
