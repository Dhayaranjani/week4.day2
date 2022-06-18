package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
/* Class Activity 2:-
1. Launch https://www.snapdeal.com/
2. Hover on Men and click on Shirts
3. Hover on first resulting shirt and click on Quick View*/
public class ClassActivity2_Snapdeal {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		//To disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		//1. Launch URL ""http://www.snapdeal.com"
		driver.get("http://www.snapdeal.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//2. Hover on Men and click on Shirts
		WebElement mensFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		WebElement mensShirt = driver.findElement(By.xpath("//span[text()='Shirts']"));
		
		//Create an object for the Action class
		Actions builder = new Actions(driver);
		
		builder.moveToElement(mensFashion)
		.pause(1000)
		.click(mensShirt)
		.perform();
		
		Thread.sleep(2000);
		
		//3. Hover on first resulting shirt and click on Quick View*/
		
		WebElement firstShirt = driver.findElement(By.xpath("//div[@class='product-tuple-image ']"));
		builder.moveToElement(firstShirt).perform();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		
		Thread.sleep(5000);
		driver.close();
	}

}
