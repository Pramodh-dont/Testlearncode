package TestNGtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
// ignore,priority,enable = false, invocation count annotations
public class PriorityAttribute {
	ChromeDriver driver;

	@Test(priority = -1)
	public void login() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		WebElement loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		loginbtn.click();
		Thread.sleep(1000);
	}

	@Test(priority = 2)
	public void operators() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Leave']")).click();
	}

	@Test(priority = 3)
	public void logoutropdown() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[text()='manda user']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// exclude the TC
	@Test(priority = 4, enabled = false)
	public void logout() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}

	// exclude the TC
	@Ignore
	@Test(priority = 4)
	public void CloseBrowser() {
		driver.quit();
	}
	
	@Test(priority = 5)
	public void quitBrowser() {
		driver.quit();
	}

	@Test //(invocationCount = 2)
	public void logininvokeMulti() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		WebElement loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		loginbtn.click();
		Thread.sleep(1000);
	}

}
