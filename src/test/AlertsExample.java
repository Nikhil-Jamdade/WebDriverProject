package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		WebElement button1 = driver.findElement(By.id("alertButton"));
		button1.click();

		Alert obj = driver.switchTo().alert();
		obj.accept();

		WebElement button2 = driver.findElement(By.id("confirmButton"));
		button2.click();

		Thread.sleep(1000);
		obj = driver.switchTo().alert();// This may not work(Code is correct)
		obj.dismiss();
//		driver.quit();
	}
}