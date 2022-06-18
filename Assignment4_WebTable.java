package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_WebTable {
/*4 Assignment for Webtable :
==================
1.http://www.leafground.com/pages/table.html 
1. Get the count of number of columns
2. Get the count of number of rows
3. Get the progress value of 'Learn to interact with Elements'
4. Check the vital task for the least completed progress.*/
//2.http://www.leafground.com/pages/sorttable.html
//*Note the instructions(pseudocode) are given below the  table given in the application*/
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		//driver.manage().window().maximize();
		
		//1. Get the count of number of columns		
		int colSize = driver.findElements(By.xpath("//table//tr//th")).size();
		System.out.println("1. The number of columns present is :" + colSize + "\n");
		
		//2. Get the count of number of rows
		int rowSize = driver.findElements(By.xpath("//table//tr")).size();
		System.out.println("2. The number of Rows present is :" + rowSize + "\n");
		
		//3. Get the progress value of 'Learn to interact with Elements'
		String myString = "Learn to interact with Elements : ";
		String myProgress1 = driver.findElement(By.xpath("//table//tr[3]/td[2]")).getText();
		String myProgress2 = driver.findElement(By.xpath("//table//tr[4]/td[2]")).getText();
		String myProgress3 = driver.findElement(By.xpath("//table//tr[5]/td[2]")).getText();
		System.out.println("3. Print the Progress Value:");
		System.out.println("1)" + myString + myProgress1 + "\n");
		System.out.println("2)" + myString + myProgress2 + "\n");
		System.out.println("3)" + myString + myProgress3 + "\n");
		
		//4. Check the vital task for the least completed progress.
		driver.findElement(By.xpath("//table//tr[6]/td[3]")).click();
		System.out.println("4. The vital task for least is checkbox");
		
	}

}
