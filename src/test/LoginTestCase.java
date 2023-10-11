package test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) throws InterruptedException {

		// Launch chrome and open website
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");

		// Maximize browser
		driver.manage().window().maximize();

		// Print title
		System.out.println("Title: " + driver.getTitle());

		// All links on that page
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("All links: " + Links.size());

		// Click on Login button
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		Thread.sleep(1000);

		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		// Print the link on console
		String location = LoginLink.getAttribute("href");
		System.out.println("The link: " + location);
		LoginLink.click();

		// All links on that page
		List<WebElement> Linkss = driver.findElements(By.tagName("a"));
		System.out.println("All linkss: " + Linkss.size());
		
		//Print all links on console
		for (WebElement linkss : Linkss) {
			System.out.println(linkss.getAttribute("href"));
		}

		// Enter username
		WebElement username = driver.findElement(By.name("user_login"));
		username.sendKeys("abc@mail.com");
		// username.sendKeys("nikhiljamdade05@gmail.com");

		// Enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Abcd@1234");
		// password.sendKeys("G!xXer@12");

		// Click on remember me
		WebElement remember = driver.findElement(By.className("rememberMe"));
		remember.click();
		WebElement remember1 = driver.findElement(By.className("rememberMe"));
		remember1.click();

		// Login
		WebElement login = driver.findElement(By.name("btn_login"));
		login.click();

		// Validate login
		WebElement error = driver.findElement(By.className("error_msg"));
		String errorMsg = error.getText();
		System.out.println("Error: " + errorMsg);
		String ExpError = "The email or password you have entered is invalid.";
		if (error.isDisplayed() && errorMsg.equals(ExpError)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		// Close browser
		driver.quit();
	}
}