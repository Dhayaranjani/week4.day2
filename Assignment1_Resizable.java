package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_Resizable {
	//1.https://jqueryui.com/resizable
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		
		//Switch to Frame
		driver.switchTo().frame(0);
		
		Thread.sleep(5000);
		//find the WebElement
		WebElement dragWebElement = driver.findElement(By.xpath("//div[@class='ui-widget-content ui-resizable']/div[3]"));
		
		//Create an Action class to perform drag
		Actions builder = new Actions(driver);
		
		Thread.sleep(5000);
		
		builder.clickAndHold(dragWebElement)
		.moveByOffset(100,200)
		.release(dragWebElement)
		.perform();
		
		//Wait and close the window
		Thread.sleep(2000);
		driver.close();

	}

}
