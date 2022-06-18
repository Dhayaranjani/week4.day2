package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_Sortable {
	//5. Launch URL "http://www.jqueryui.com/sortable/
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		//To disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		//1. Launch URL "http://www.jqueryui.com/sortable/"
		driver.get("http://www.jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		
		Actions builder = new Actions(driver);
		//builder.dragAndDrop(item2, item5).perform();	
		
		builder.clickAndHold(item2)
		.moveToElement(item5)
		.release()
		.perform();	
		
		Thread.sleep(2000);
		driver.close();	

	}

}
