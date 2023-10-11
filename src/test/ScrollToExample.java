package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollToExample {

	public static void main(String[] args) throws InterruptedException {
		// Setup
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		WebElement scrollTo = driver.findElement(By.xpath("//h2[text()='HTML Exercises']"));

		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("arguments[0].scrollIntoView();", scrollTo);
		Thread.sleep(2000);
		// scroll up
		obj.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		Thread.sleep(2000);

		driver.quit();
	}
}