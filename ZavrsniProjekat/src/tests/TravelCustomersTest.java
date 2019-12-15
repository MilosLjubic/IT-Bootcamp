package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import pages.TitlePage;
import pages.TravelCustomers;
import utils.ExcelUtils;

public class TravelCustomersTest extends BasicTest {
	ExcelUtils ex = new ExcelUtils();

	@BeforeClass
	public void setup() throws InterruptedException {
		super.setup();
		driver.get(baseUrl);
		Thread.sleep(2000);

		ex.setExcell("..\\ZadatakProjekat-1.dan\\excel\\Username.xlsx");
		ex.setWorkSheet(0);

		LoginPage lg = new LoginPage(driver);
		lg.signIn(ex.getDataAt(1, 0), ex.getDataAt(1, 1), false);
		Thread.sleep(2000);

		TitlePage tp = new TitlePage(driver);
		String actualTitle = tp.getPageTitle();
		String expectedTitle = "Dashboard";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 0)
	public void editTest() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(500);

		MenuPage mp = new MenuPage(driver);
		mp.goToAccounts();
		Thread.sleep(500);
		mp.goToAccCustomers();
		Thread.sleep(500);

		TravelCustomers tc = new TravelCustomers(driver);

		tc.goToEdit();
		Thread.sleep(2000);

		tc.setFirstName("James");
		Thread.sleep(500);

		tc.setLastName("Harden");
		Thread.sleep(500);

		tc.setEmail("houston@nba.com");
		Thread.sleep(500);

		tc.setMobile("123456789");
		Thread.sleep(500);

		tc.setCountry("Chad");
		Thread.sleep(500);

		tc.setAddress("Address 13");
		Thread.sleep(500);

		tc.setStatus(1);
		Thread.sleep(500);

		tc.goToCheckbox();
		Thread.sleep(500);

		tc.goToSubmit();
		Thread.sleep(2000);

		tc.goToSearch();
		Thread.sleep(500);

		tc.setInputField("houston@nba.com");
		Thread.sleep(500);

		Assert.assertTrue(tc.isEditSuccessful());
	}

	@AfterClass
	public void quit() {
		ex.closeExcell();
	}
}
