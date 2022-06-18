package week4.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*1. Launch https://erail.in
2. Enter From as MS
3. Enter To as MDU
4. Deselect sortOnDate checkbox
5. Get the train names and ensure they are not duplicated*/
public class ClassActivity1_Erail {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//1. Launch https://erail.in
		driver.get("https://erail.in");
		driver.manage().window().maximize();
		
		//2. Enter From as MS
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("MS");
		Thread.sleep(500);
		fromStation.sendKeys(Keys.TAB);
		
		//3. Enter To as MDU
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("MDU");
		Thread.sleep(500);
		toStation.sendKeys(Keys.TAB);

		Thread.sleep(5000);
		//4. Deselect sortOnDate checkbox
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		//5. Get the train names
		int rowSize = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr")).size();
		//This will print all the Train Names
		/*for (int i = 1; i <= rowSize; i++) {
			WebElement myEleTrainList = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+ i + "]//td[2]"));
			String trainNames = myEleTrainList.getText();
			System.out.println(trainNames);
		}*/
		
		//In order to check whether there is duplicate, put it in the List
		List<String> lstTrainNames = new ArrayList<String>();
		System.out.println("   Train List    ");
		System.out.println("===========================");
		Thread.sleep(5000);
		
		for (int i = 1; i <= rowSize; i++) {
			WebElement myEleTrainList = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+ i + "]//td[2]/a"));
			String trainNames = myEleTrainList.getText();
			lstTrainNames.add(trainNames);
			System.out.println(trainNames);
		}
		System.out.println("===========================");

		//Now convert the List into Set to remove duplicates				
		Set<String> mySetofTrain = new HashSet<String>(lstTrainNames);
		
		Thread.sleep(5000);
		//Compare both the list's size and print the result
		if(mySetofTrain.size() == lstTrainNames.size())
		{
			System.out.println("Result: There is no Duplicate in the Train List");
		}else
		{
			System.out.println("Result: Duplicates found");
		}
		
	}
}
