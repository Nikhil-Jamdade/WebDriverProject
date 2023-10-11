package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsExample {

	public static void main(String[] args) throws InterruptedException {
		// Setup
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		WebElement newTab = driver.findElement(By.id("tabButton"));
		String ParentWin = driver.getWindowHandle();
		System.out.println("Parent win: " + ParentWin);
		newTab.click();
		Thread.sleep(1000);

		Set<String> AllWin = driver.getWindowHandles();
		String childWin = "";

		for (String win : AllWin) {
			System.out.println("Win ID: " + win);
			if (!win.equals(ParentWin)) {
				childWin = win;
			}
		}
		System.out.println("Child Win: " + childWin);
		Thread.sleep(1000);

		driver.switchTo().window(childWin);

		WebElement ChildHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println("Child1 Header: " + ChildHeader.getText());

		// This will quit only the current window(child window)
		driver.close();
		Thread.sleep(1000);

		System.out.println();
		
		driver.switchTo().window(ParentWin);

		WebElement ChildWin2 = driver.findElement(By.xpath("//button[@id='windowButton']"));
		ChildWin2.click();
		Thread.sleep(1000);

		AllWin = driver.getWindowHandles();

		for (String win : AllWin) {
			System.out.println("Win ID: " + win);
			if (!win.equals(ParentWin)) {
				childWin = win;
			}
		}
		System.out.println("Child Win: " + childWin);
		driver.switchTo().window(childWin);
		ChildHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println("Child2 Header: " + ChildHeader.getText());

		driver.close();
	}
}