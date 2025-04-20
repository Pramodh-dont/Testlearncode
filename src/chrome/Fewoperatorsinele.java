package chrome;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Fewoperatorsinele {

	public static void main(String[] arg) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless");
		ChromeDriver driver = new ChromeDriver(options);
		// To handle checkbox
		driver.get("https://the-internet.herokuapp.com"); // Child locator

		driver.findElement(By.linkText("Checkboxes")).click();
		WebElement CB = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
		// take screenshot
		capturescreenshot(driver, "Checkbox before checked image");
		// enabled or not
		boolean B = CB.isEnabled();
		System.out.println("Is checkbox is enabled :" + B);
		// displayed or not
		boolean D = CB.isDisplayed();
		System.out.println("Is check is displayed :" + D);
		CB.click();
		capturescreenshot(driver, "Checkbox after checked image");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		// iframehandle
		driver.findElement(By.linkText("Frames")).click();
		driver.findElement(By.linkText("iFrame")).click();
		driver.findElement(By.xpath("//div[@aria-label='Close']/parent::button")).click();
		driver.switchTo().frame(0);
		WebElement IFE = driver.findElement(By.xpath("//body[@aria-label='Rich Text Area. Press ALT-0 for help.']"));
		String TIFE = IFE.getText();
		System.out.println("content is :" + TIFE);
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		// nested iFrames
		driver.findElement(By.linkText("Nested Frames")).click();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		// JS alert handle
		driver.navigate().back();
		Thread.sleep(5000);
		driver.findElement(By.linkText("JavaScript Alerts")).click();
		WebElement Alert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		Alert.click();
		Thread.sleep(5000);
		Alert AlertBox = driver.switchTo().alert();
		String AlertText = AlertBox.getText();
		System.out.println("Alert text is :" + AlertText);
		Thread.sleep(5000);
		AlertBox.accept();
		Thread.sleep(5000);
		capturescreenshot(driver, "Alert disappear image");
		// radio buttons
		driver.get("https://practice.expandtesting.com/radio-buttons");
		WebElement Basket = driver.findElement(By.xpath("//input[@value='basketball']"));
		Thread.sleep(6000);
		Basket.click();
		// Dropdown
		driver.get("https://practice.expandtesting.com/dropdown");
		WebElement DDE = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select Selectopt = new Select(DDE);
		Selectopt.selectByValue("1");
		Thread.sleep(5000);
		// window handler
		driver.get("https://practice.expandtesting.com/windows");
		String PWN = driver.getWindowHandle();
		driver.findElement(By.linkText("Click Here"));
		Set<String> AllTab = driver.getWindowHandles();
		for (String s : AllTab) {
			if (!s.equals(PWN)) {
				driver.switchTo().window(s);
			}
		}
		driver.findElement(By.linkText("Home")).click();
		Actions actions = new Actions(driver);
		// right click
		actions.contextClick().build().perform();
		// double click
		actions.doubleClick().build().perform();
		// drag and drop
		Thread.sleep(5000);
		driver.get("https://practice.expandtesting.com/drag-and-drop");
		WebElement Drag = driver.findElement(By.id("column-a"));
		WebElement Drop = driver.findElement(By.id("column-b"));
		Thread.sleep(5000);
		actions.dragAndDrop(Drag, Drop).build().perform();
		Thread.sleep(5000);
		// move mouse over
		driver.get("https://www.flipkart.com");
		WebElement ME = driver.findElement(By.xpath("//a[@title='Login']"));
		actions.moveToElement(ME).build().perform();
		Thread.sleep(5000);
		driver.get("https://practice.expandtesting.com/");
		capturescreenshot(driver, "login button mouse over");
		Thread.sleep(5000);
		driver.quit();

	}

	public static void capturescreenshot(ChromeDriver driver, String FileName) {
		TakesScreenshot SC = driver;
		File image = SC.getScreenshotAs(OutputType.FILE);
		File myFile = new File("C:\\Users\\user\\eclipse-workspace\\Testing\\Screenshots\\" + FileName + ".png");
		try {
			FileUtils.copyFile(image, myFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
