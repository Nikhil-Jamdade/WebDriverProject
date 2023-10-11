package test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignup {

	public static void main(String[] args) throws InterruptedException {

		// Launch chrome and open Facebook login page
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		// Maximize browser
		driver.manage().window().maximize();

		// Create new account
		WebElement create = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		create.click();
		Thread.sleep(1000);

		// Firstname
		WebElement Fname = driver.findElement(By.xpath("//input[@name='firstname']"));
		Fname.sendKeys("Shri");

		// Lastname
		WebElement Lname = driver.findElement(By.xpath("//input[@name='lastname']"));
		Lname.sendKeys("Ram");

		// Email
		WebElement email = driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']"));
		email.sendKeys("abc@mail.com");

		// Re-email
		WebElement Email = driver.findElement(By.xpath("//input[@aria-label='Re-enter email address']"));
		Email.sendKeys("abc@mail.com");

		// Password
		WebElement password = driver.findElement(By.xpath("//input[@id='password_step_input']"));
		password.sendKeys("Abcd@1234");

		// Day
		WebElement defday = driver.findElement(By.xpath("//select[@aria-label='Day']/option[@selected='1']"));
		System.out.println("Default day: " + defday.getText());

		WebElement day = driver.findElement(By.xpath("//select[@aria-label='Day']"));
		Select dday = new Select(day);
		dday.selectByValue("19");
		// dday.selectByVisibleText("19");

		// Month
		WebElement defmon = driver.findElement(By.xpath("//select[@aria-label='Month']/option[@selected='1']"));
		System.out.println("Default day: " + defmon.getText());

		WebElement mon = driver.findElement(By.xpath("//select[@aria-label='Month']"));
		Select mmon = new Select(mon);
		mmon.selectByValue("3");
		// mmon.selectByVisibleText("Mar");

		// Year
		WebElement defyear = driver.findElement(By.xpath("//select[@aria-label='Year']/option[@selected='1']"));
		System.out.println("Default day: " + defyear.getText());

		WebElement year = driver.findElement(By.xpath("//select[@aria-label='Year']"));
		Select yyear = new Select(year);
		yyear.selectByValue("1997");
		// yyear.selectByVisibleText("1997");

		// Gender
//		WebElement gen = driver.findElement(By.xpath("//label[text()='Male']"));
//		WebElement gen = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
//		gen.click();

		// Gender input via console
		String Gender = "Custom";
		String genderXpath = "//label[text()='Placeholder']";
		String newXpath = genderXpath.replace("Placeholder", Gender);
		System.out.println("New Xpath: " + newXpath);

		WebElement genderElem = driver.findElement(By.xpath(newXpath));
		genderElem.click();

		// Custom - experiment
		WebElement pronoun = driver.findElement(By.xpath("//select[@aria-label='Select your pronoun' and @name='preferred_pronoun']"));
		Select ppronoun = new Select(pronoun);
		ppronoun.selectByValue("2");

		WebElement OptGender = driver.findElement(By.xpath("//input[@name='custom_gender']"));
		OptGender.sendKeys("Alpha");

		// All months
		List<WebElement> list = driver.findElements(By.xpath("//select[@aria-label='Month']/option"));
		for (WebElement value : list) {
			System.out.println("All months: " + value.getText());
		}

		// Signup
		WebElement Signup = driver.findElement(By.xpath("//button[@name='websubmit']"));
		Signup.click();

		// Close
		driver.quit();
	}
}