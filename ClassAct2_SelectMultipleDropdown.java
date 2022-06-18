package week4.day2;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassAct2_SelectMultipleDropdown {
	//1. Launch http://www.leafground.com/pages/Dropdown.html
	// -->  Select multiple options from Select your programs dropdowns
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		//To disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		//1. Launch URL "http://www.leafground.com/pages/Dropdown.html");
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement Selenium = driver.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[text()='Selenium']"));
		WebElement Appium = driver.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[text()='Appium']"));
		
		Actions builder = new Actions(driver);
		
		builder.keyDown(Keys.CONTROL)
		.click(Selenium)
		.click(Appium)
		.keyUp(Keys.CONTROL)
		.perform();
	}

}
