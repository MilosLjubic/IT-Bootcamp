package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import pages.TitlePage;
import utils.ExcelUtils;

public class AccessTests extends BasicTest {

	@Test(priority = 0)
	public void loginTest() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(500);

		ExcelUtils ex = new ExcelUtils();
		ex.setExcell("..\\ZadatakProjekat-1.dan\\excel\\Username.xlsx");
		ex.setWorkSheet(0);

		LoginPage lg = new LoginPage(driver);
		lg.signIn(ex.getDataAt(1, 0), ex.getDataAt(1, 1), false);
		Thread.sleep(500);

		TitlePage tp = new TitlePage(driver);
		String actualTitle = tp.getPageTitle();
		String expectedTitle = "Administator Login";
//		String expectedTitle = "Dashboard";
		Assert.assertEquals(actualTitle, expectedTitle);
		ex.closeExcell();

	}

	@Test(priority = 4)
	public void dashboardTest() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(500);

		MenuPage mp = new MenuPage(driver);
		mp.goToDashboard();
		Thread.sleep(500);

		TitlePage tp = new TitlePage(driver);
		String actualTitle = tp.getPageTitle();
		String expectedTitle = "Dashboard";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 5)
	public void updatesTest() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(500);

		MenuPage mp = new MenuPage(driver);
		mp.goToUpdates();
		Thread.sleep(500);

		TitlePage tp = new TitlePage(driver);
		String actualTitle = tp.getPageTitle();
		String expectedTitle = "Updates";
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Test(priority = 10)
	public void modulesTest() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(500);

		MenuPage mp = new MenuPage(driver);
		mp.goToModules();
		Thread.sleep(500);

		TitlePage tp = new TitlePage(driver);
		Assert.assertTrue(tp.getPageTitle().equals("Modules"));
	}

	@Test(priority = 12)
	public void accCustomersTest() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(500);

		MenuPage mp = new MenuPage(driver);
		mp.goToAccounts();
		Thread.sleep(500);
		mp.goToAccCustomers();
		Thread.sleep(500);

		TitlePage tp = new TitlePage(driver);
		Assert.assertTrue(tp.getPageTitle().contains("Customers"));
	}

	@Test(priority = 15)
	public void addToursTest() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(500);

		MenuPage mp = new MenuPage(driver);
		mp.goToTours();
		Thread.sleep(500);
		mp.goToAddTours();
		Thread.sleep(500);

		TitlePage tp = new TitlePage(driver);
		Assert.assertTrue(tp.getPageTitle().equals("Add Tour"));
	}

	@Test(priority = 20)
	public void allCarsTest() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(500);

		MenuPage mp = new MenuPage(driver);
		mp.goToCars();
		Thread.sleep(500);
		mp.goToAllCars();
		Thread.sleep(500);

		TitlePage tp = new TitlePage(driver);
		Assert.assertTrue(tp.getPageTitle().contains("Cars"));
	}

	@Test(priority = 22)
	public void carsExtrasTest() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(500);

		MenuPage mp = new MenuPage(driver);
		mp.goToCars();
		Thread.sleep(500);
		mp.goToCarsExtras();
		Thread.sleep(500);

		TitlePage tp = new TitlePage(driver);
		Assert.assertTrue(tp.getPageTitle().contains("Extras"));
	}

	@Test(priority = 25)
	public void couponsTest() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(500);

		MenuPage mp = new MenuPage(driver);
		mp.goToCoupons();
		Thread.sleep(500);

		TitlePage tp = new TitlePage(driver);
		Assert.assertTrue(tp.getPageTitle().contains("Coupon"));
	}

	@Test(priority = 30)
	public void newsletterTest() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(500);

		MenuPage mp = new MenuPage(driver);
		mp.goToNewsletter();
		Thread.sleep(500);

		TitlePage tp = new TitlePage(driver);
		Assert.assertTrue(tp.getPageTitle().contains("Newsletter"));
	}

	@Test(priority = 35)
	public void bookingsTest() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(500);

		MenuPage mp = new MenuPage(driver);
		mp.goToBookings();
		Thread.sleep(500);

		TitlePage tp = new TitlePage(driver);
		Assert.assertTrue(tp.getPageTitle().equals("Booking Management"));
	}
}