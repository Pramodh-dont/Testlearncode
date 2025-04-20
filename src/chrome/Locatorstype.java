package chrome;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locatorstype {

	public static void main(String[] arg) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		// name locator
		WebElement EmailTextbox = driver.findElement(By.name("email"));
		EmailTextbox.sendKeys("pramod");
		// enabled or not
		boolean B = EmailTextbox.isEnabled();
		System.out.println("Is textbox for email enable :" + B);
		// displayed or not
		boolean D = EmailTextbox.isDisplayed();
		System.out.println("Is textbox for password displayed :" + D);
		// tag name
		List<WebElement> AllLink = driver.findElements(By.tagName("a"));
		System.out.println(AllLink.size());
		for (int i = 0; i < AllLink.size(); i++) {
			System.out.println(AllLink.get(i).getText());
		}
		// class name
		List<WebElement> AllLinks = driver.findElements(By.className("_sv4"));
		System.out.println("size:" + AllLinks.size());
		for (int j = 0; j < AllLinks.size(); j++) {
			System.out.println(AllLinks.get(j).getText());
		}
		// Xpath
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Prmu");
		// CSS
		driver.findElement(By.cssSelector("button[value='1']")).click();
		//Take screenshot indivisually
		TakesScreenshot SC = driver;
		File image = SC.getScreenshotAs(OutputType.FILE);
		File myFile = new File("C:\\Users\\user\\eclipse-workspace\\Testing\\Screenshots\\image.png");
		FileUtils.copyFile(image, myFile);
		driver.quit();
	}
}
