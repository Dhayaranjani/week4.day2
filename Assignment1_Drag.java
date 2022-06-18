package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_Drag {
	//2.http://www.leafground.com/pages/drag.html
	public static void main(String[] args) throws InterruptedException {
		// Drag Elements 
		//===============
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement dropEle = driver.findElement(By.id("draggable"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(dropEle, 100, 100).perform();
		
		int x = dropEle.getLocation().getX();
		int y = dropEle.getLocation().getY();
		System.out.println("X is : " + x);
		System.out.println("Y is : " + y);
		
		Thread.sleep(5000);
		driver.close();
	}

}
