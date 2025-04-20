package TestNGtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//Assertions
public class TestNGlaunch {
	@Test
	public void TesNGtestscript() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		SoftAssert SA = new SoftAssert();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		WebElement loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		loginbtn.click();
		// Assertion
		String expectedurlworng = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String expectedurl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		WebElement profilebtn = driver.findElement(By.xpath("//img[@alt='profile picture']/parent::span"));
		boolean btn = profilebtn.isDisplayed();
		String actualurl = driver.getCurrentUrl();
		//soft assert
		SA.assertNotEquals(actualurl, expectedurlworng);
		// Assert equals to Hard assert
		Assert.assertEquals(actualurl, expectedurl);
		// Assert notequal to
		Assert.assertNotEquals(actualurl, expectedurlworng);
		// Assert true
		Assert.assertTrue(btn);
		// Assert false
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		boolean btnl = driver.findElement(By .cssSelector("input[type='checkbox'][value='1']")).isSelected();
		Assert.assertFalse(btnl);
		//soft assert
		SA.assertAll();
	}

}
