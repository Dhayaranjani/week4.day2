package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_Nykaa {
/*Assignment 2:
=============
1) Go to https://www.nykaa.com/
2) Mouseover on Brands and Search L'Oreal Paris
3) Click L'Oreal Paris
4) Check the title contains L'Oreal Paris(Hint-GetTitle)
5) Click sort By and select customer top rated
6) Click Category and click Hair->Click haircare->Shampoo
7) Click->Concern->Color Protection
8)check whether the Filter is applied with Shampoo
9) Click on L'Oreal Paris Colour Protect Shampoo
10) GO to the new window and select size as 175ml
11) Print the MRP of the product
12) Click on ADD to BAG
13) Go to Shopping Bag 
14) Print the Grand Total amount
15) Click Proceed
16) Click on Continue as Guest
17) Check if this grand total is the same in step 14
18) Close all windows
 * */
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		//To disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		//1. Launch URL "https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		//2) Mouseover on Brands 
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		
		//Create an Action class
		Actions builder = new Actions(driver);
		
		//Hover on Brands
		builder.moveToElement(brands).perform();
		Thread.sleep(5000);
		//3) Search L'Oreal Paris and Click 
		WebElement brandSearch = driver.findElement(By.id("brandSearchBox"));
		brandSearch.sendKeys("L'Oreal Paris");
		brandSearch.click();
		
		Thread.sleep(5000);
		//4) Check the title contains L'Oreal Paris
		driver.findElement(By.xpath("(//a[text()=\"L'Oreal Paris\"])[1]")).click();
		Thread.sleep(5000);
		
		//5) Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']/parent::div/following-sibling::div")).click();
		Thread.sleep(5000);

		//6) Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		//7) Click->Concern->Color Protection
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();	
		
		Thread.sleep(5000);
		//8)check whether the Filter is applied with Shampoo
		boolean chkFilter = driver.findElement(By.xpath("//span[text()='Filters Applied']/following::span[text()='Shampoo']")).isDisplayed();
		if(chkFilter == true) {
			System.out.println("1. Success. Checked the filter: It applied with Shampoo" + "\n");
		}else
			System.out.println("1. Failed. No Filter Found" + "\n");
		
		//9) Click on L'Oreal Paris Colour Protect Shampoo
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"]")).click();
		System.out.println("2. Clicked on : L'Oreal Paris Colour Protect Shampoo" + "\n");
		
		//10) GO to the new window and select size as 175ml
		//Get the number of windows
		Set<String> windowHandles = driver.getWindowHandles();
		//Convert set to List
		List<String> windows = new ArrayList<String>(windowHandles);
		String newWindow = windows.get(1);
		//switch to new window
		driver.switchTo().window(newWindow);
		
		//Select size as 175ml 
		Thread.sleep(5000);
		driver.findElement(By.xpath("//select[@title='SIZE']//option[text()='175ml']")).click();
		System.out.println("3. Selected the dropdown size as : 175ml" + "\n");
		
		Thread.sleep(5000);
		//11) Print the MRP of the product
		String mrpOfShampoo = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println("4. The MRP of the Shampoo is : " + mrpOfShampoo + "\n");
		
		Thread.sleep(5000);
		//12) Click on ADD to BAG
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		System.out.println("5. Clicked : ADD to BAG" + "\n");
		
		Thread.sleep(5000);
		//13) Go to Shopping Bag 
		driver.findElement(By.xpath("//span[@class='cart-count']/parent::button")).click();
		System.out.println("6. Clicked : Go to Shopping Bag " + "\n");
		
		Thread.sleep(5000);
		//14) Print the Grand Total amount
		driver.switchTo().frame(0);
		String grandTotal = driver.findElement(By.xpath("//div[@class='first-col']/div[@class='value']")).getText();
		System.out.println("7. The Grand Total Amount is :" + grandTotal + "\n");
		
		Thread.sleep(5000);
		//15) Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		//get out of the all the frame
		System.out.println("8. Clicked on : Proceed button in the frame." + "\n");
		driver.switchTo().defaultContent();
				
		Thread.sleep(5000);
		//16) Click on Continue as Guest
		driver.findElement(By.xpath("//button[text() = 'CONTINUE AS GUEST']")).click();
		System.out.println("9. Clicked on : Continue as Guest button"  + "\n");
		
		Thread.sleep(5000);
		//17) Check if this grand total is the same in step 14
		String finalGrandTotal = driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div[@class='value']")).getText();
		System.out.println("10. The Final Grand Total Amount is :" + finalGrandTotal + "\n");
		if(finalGrandTotal.contains(grandTotal)) {
			System.out.println("11. Success. Both the Grand Total Amount's are Same."+ "\n");
		}else
			System.out.println("11. Failed. No there is difference in Grand Total Amount."+ "\n");
		
		//18) Close all windows	
		driver.quit();
		}

}
