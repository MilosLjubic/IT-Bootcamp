package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import pages.TitlePage;
import pages.TravelCars;
import utils.ExcelUtils;

public class TravelCarsTests extends BasicTest {
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

		MenuPage mp = new MenuPage(driver);
		mp.goToCars();
		Thread.sleep(2000);
		mp.goToAllCars();
		Thread.sleep(2000);

		TitlePage tp = new TitlePage(driver);
		Assert.assertTrue(tp.getPageTitle().contains("Cars Management"));
	}

	@Test(priority = 5)
	public void numberOfModels() throws InterruptedException {
		TravelCars tc = new TravelCars(driver);
		Assert.assertEquals(tc.numberOfDifferent(), 10);
	}

	@Test(priority = 7)
	public void numberOfRows() throws InterruptedException {
		TravelCars tc = new TravelCars(driver);
		Assert.assertEquals(tc.numberOfRows(), 30);
	}

	@Test(priority = 10)
	public void numberOfOrders() throws InterruptedException {
		TravelCars tc = new TravelCars(driver);
		Assert.assertTrue(tc.getNubmerOfOrders() > 50);
	}

	@Test(priority = 15)
	public void isUploadSuccessfull() throws InterruptedException {
		TravelCars tc = new TravelCars(driver);
		tc.goToUpload();
		Thread.sleep(2000);
		tc.goToAddBtn();
		Thread.sleep(2000);
		tc.dropImage("image\\Zastava101.png");
		Thread.sleep(2000);

		Assert.assertTrue(tc.isImageUploadedSuccessfuly());
	}

	@AfterClass
	public void quit() {
		ex.closeExcell();
	}
}
