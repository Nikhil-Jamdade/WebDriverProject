package test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) throws InterruptedException {

		// Setup
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();

		// Rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		System.out.println(rows.size());
		
		// Columns
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='customers']//th"));
		System.out.println(columns.size());
		
		// Specific elements
		WebElement oneData = driver.findElement(By.xpath("//table[@id='customers']//tr[3]/td[3]"));
		System.out.println("Data is: " + oneData.getText());
		
		// All elements except header
		for (int i = 2; i < rows.size(); i++) {
			List<WebElement> ColumsData = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td"));
			System.out.println(ColumsData.get(0).getText() + "\t" + ColumsData.get(1).getText() + "\t" + ColumsData.get(2).getText());
		}
		driver.quit();
	}
}