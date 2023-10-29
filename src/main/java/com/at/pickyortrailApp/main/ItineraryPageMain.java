 package com.at.pickyortrailApp.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ItineraryPageMain extends Baseclass {

	public void itineraryCreation() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Next']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Next']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Next']")).click();
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id =
		// 'android:id/content']")).click(); //close
		 Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.ImageView")).click(); // Start planning
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Europe']")).click(); // Select Europe
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Feb']")).click(); // select date
		driver.findElement(By.xpath("//android.widget.TextView[@text = '30']")).click(); // select date
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Bengaluru, BLR']")).click(); // skip flight
		driver.findElement(By.xpath("//android.widget.TextView[@text = '6-9 days']")).click(); // duration days
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Couple']")).click(); // pax count
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Amsterdam']")).click(); // city selection
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Done! Build Itinerary']")).click(); // Done
		driver.findElement(By.xpath("//android.widget.EditText[@text = 'Mobile number']")).sendKeys("9176089970");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Continue']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@text = 'Name']")).click();// Continue
		driver.findElement(By.xpath("//android.widget.EditText[@text = 'Name']")).sendKeys("Lee");
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Continue']")).click(); // Continue
		
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'English']")).click();
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='textInput']")).click(); // xpath("//android.view.ViewGroup[@id='inputSlotView']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='textInput']")).sendKeys("666666");
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Verify']")).click();

		Thread.sleep(10000);

		WebElement validate = driver.findElement(By.xpath("//android.widget.TextView[@text='Proceed to book']"));
		if (validate.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Login Successfull! and Itinerary Created successfully!");
		} else {
			Assert.assertTrue(false);
			System.out.println("Login Successfull! and Itinerary creation failed!!");
		}

		Thread.sleep(5000);

	}
}
