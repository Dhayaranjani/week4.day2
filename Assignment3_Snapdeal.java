package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.google.common.collect.Ordering;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3_Snapdeal {
	/*Assignment 3:
	===============
	1. Launch https://www.snapdeal.com/
	2. Go to Mens Fashion
	3. Go to Sports Shoes
	4. Get the count of the sports shoes
	5. Click Training shoes
	6. Sort by Low to High
	7. Check if the items displayed are sorted correctly
	8. Select the price range (900-1200)
	9. Filter with color Navy 
	10 verify the all applied filters 
	11.Mouse Hover on first resulting Training shoes
	12.click QuickView button
	13.Print the cost and the discount percentage
	14.Take the snapshot of the shoes.
	15.Close the current window
	16.Close the main window*/
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		
		//To disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		//1. Launch URL "https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		
		//2. Go to Mens Fashion
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]")).click();
		
		//3. Go to Sports Shoes
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		
		Thread.sleep(5000);
		//4. Get the count of the sports shoes
		String cntOfShoes = driver.findElement(By.xpath("//div[@class='child-cat-name selected']/following-sibling::div")).getText();
		System.out.println("1. Count of the Sports Shoes :" + cntOfShoes + "\n");
		
		Thread.sleep(5000);
		//5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		//Thread.sleep(1000);
		//6. Sort by Low to High
		WebElement sortByLtoH = driver.findElement(By.xpath("//span[text()='Sort by:']"));
		sortByLtoH.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[9]/div[2]/div[2]/div[3]/div[2]/ul/li[2]")).click();
		
		//7. Check if the items displayed are sorted correctly
		 Thread.sleep(5000);
		 List<WebElement> lstPrice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		 System.out.println("2. Check if the items displayed are sorted correctly");
		 System.out.println("Shoes Prices are:");
 		 System.out.println("------------------");	 
		//print the list
 		 for (WebElement myWebElement : lstPrice) {
			System.out.println(myWebElement.getText());
		 }
 		
 		 //To check if the items are sorted put it inside the List
 		 List<String> sortList = new ArrayList<String>();
 		 for (WebElement e:lstPrice) {
 			sortList.add(e.getAttribute("display-price"));
 		 }

 		 boolean bool = Ordering.natural().isOrdered(sortList);
 		 if(bool == true) {
 			 System.out.println("True: The items displayed are sorted correctly" + "\n");
 		 }else
 			 System.out.println("False: The items are not sorted correctly" + "\n");

		 //8. Select the price range (500-1200)
		 WebElement fromPrice = driver.findElement(By.name("fromVal"));
		 WebElement toPrice = driver.findElement(By.name("toVal"));
		
		 fromPrice.clear();
		 fromPrice.sendKeys("500");
		 Thread.sleep(500);
		 fromPrice.sendKeys(Keys.TAB);
		
		 toPrice.clear();
		 toPrice.sendKeys("1200");
		 Thread.sleep(500);
		 toPrice.sendKeys(Keys.TAB);
		
		 driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		
		 //9. Filter with color Navy
		 Thread.sleep(5000);
		 //driver.findElement(By.xpath("//input[@id='Color_s-Yellow']/following-sibling::label")).click();
		 driver.findElement(By.xpath("//input[@id='Color_s-Navy']/following-sibling::label")).click();
		 
		 //10 verify the all applied filters
		 Thread.sleep(5000);
		 List<WebElement> lstFilter = driver.findElements(By.xpath("//div[@class='navFiltersPill']"));
		 String filterPrice = "Price: Rs. 500 - Rs. 1200";
		 String filterColor = "Color: Navy";
		 System.out.println("3. Verify all the Filters" + "\n");
		 for (WebElement eFilter : lstFilter) {
			String filteredText = eFilter.getText();
			if(filterPrice.equals(filteredText) || filterColor.equals(filteredText))
				System.out.println("Verified : " + filteredText);
		 }

		 //11.Mouse Hover on first resulting Training shoes
		 WebElement firstResult = driver.findElement(By.xpath("//div[@class='product-tuple-image ']//a"));
		 Actions builder = new Actions(driver);
		 builder.moveToElement(firstResult).perform();		
		
		 //12.click QuickView button
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		
		 //13.Print the cost and the discount percentage
		 Thread.sleep(5000);
		 String costOfShoe = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span")).getText();
		 System.out.println("4. Cost of the Shoe is : " + costOfShoe +"\n");
		
		 Thread.sleep(5000);
		 String discntPercentage = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span/following-sibling::span")).getText();
		 System.out.println("5. Discount Percentage is : " + discntPercentage +"\n");
					
		 Thread.sleep(5000);
		 //14.Take the snapshot of the shoes.
		 File source = driver.getScreenshotAs(OutputType.FILE);
		 File destination = new File("./screenshotShoe.png");
		 FileUtils.copyFile(source, destination);
		
		//15.Close the current window
		 driver.findElement(By.xpath("//div[@class='close close1 marR10']/i")).click();
		
		Thread.sleep(2000);
		//16.Close the main window
		driver.close();		 
 		 
	}  

}
