package TestNGtest;

import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class FewAnotationsTestNG {
	// groups & depends
	@Test(priority = 1, groups = "login")
	public void loginamar() {
		System.out.println("Amar loggedIn");
	}
	@Test(priority = 1, groups = "login")
	public void loginpammy() {
		System.out.println("pammy loggedIn");
	}
	@Test(priority = 1, groups = "login")
	public void loginpramod() {
		System.out.println("pramod loggedIn");
	}
	@Test(priority = 2, groups = "logout", dependsOnMethods = "loginamar")
	public void logoutamar() {
		System.out.println("amar loggedOut");
	}
	@Test(priority = 2, groups = "logout", dependsOnMethods = "loginpammy")
	public void logoutpammy() {
		System.out.println("pammy loggedOut");
	}
	// skiping due to loginpramod method is failing
	@Test(priority = 2, groups = "logout", dependsOnMethods = "loginpramod")
	public void logoutpramodh() {
		System.out.println("pramodh loggedOut");
	}
}
