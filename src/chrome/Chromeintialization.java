package chrome;

import org.openqa.selenium.chrome.ChromeDriver;

public class Chromeintialization {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	//	System.setProperty("webDriver.chrome.driver", "E:\\Softwares\\java\\chromedriver-win32\\chromedriver-win32");
		 ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		driver.close();
	}

}
   