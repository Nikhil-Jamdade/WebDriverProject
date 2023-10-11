package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragNDrop {

	public static void main(String[] args) throws InterruptedException {
		// Setup
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement from = driver.findElement(By.xpath("//a[text()=' BANK ']"));
//		WebElement from = driver.findElement(By.xpath("//div[@id='products']//li[5]"));
		WebElement to = driver.findElement(By.xpath("//ol[@id='bank']/li"));

		Actions obj = new Actions(driver);

//		obj.sendKeys(Keys.PAGE_DOWN); //this may work or not(mostly wont)
		obj.dragAndDrop(from, to).build().perform();

	}
}