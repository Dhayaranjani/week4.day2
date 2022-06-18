package week4.day2;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_Drop {
	//3.http://www.leafground.com/pages/drop.html
	public static void main(String[] args) throws InterruptedException {
		//1. Drag and Drop
		//=================
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drop.html");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement dragMe = driver.findElement(By.id("draggable"));
		WebElement dropMe = driver.findElement(By.id("droppable"));

		//Create an object for Actions class called builder
		Actions builder = new Actions(driver);
		Thread.sleep(5000);
		builder.dragAndDrop(dragMe, dropMe).perform();
		
		Thread.sleep(5000);
		driver.close();	

	}

}
