package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import pages.LoginPage;
import pages.MenuPage;
import pages.TitlePage;
import pages.TravelCarsExtras;
import utils.ExcelUtils;

public class TravelCarsExtrasTests extends BasicTest {
	ExcelUtils ex = new ExcelUtils();

	@BeforeClass
	public void setupClass() throws InterruptedException {
		super.setup();
		driver.get(baseUrl);
		Thread.sleep(2000);

		ex.setExcell("..\\ZadatakProjekat-1.dan\\excel\\Username.xlsx");
		ex.setWorkSheet(0);

		LoginPage lg = new LoginPage(driver);
		lg.signIn(ex.getDataAt(1, 0), ex.getDataAt(1, 1), false);
		Thread.sleep(2000);

		TitlePage tp = new TitlePage(driver);
		Assert.assertTrue(tp.getPageTitle().contains("Dashboard"));
	}

	@BeforeMethod
	public void setupMethod() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(2000);

		MenuPage mp = new MenuPage(driver);
		mp.goToCars();
		Thread.sleep(2000);
		mp.goToCarsExtras();
		Thread.sleep(2000);

		TravelCarsExtras tce = new TravelCarsExtras(driver);
		tce.goToAdd();
		Thread.sleep(2000);

		TitlePage tp = new TitlePage(driver);
		Assert.assertTrue(tp.getPageTitle().contains("Extras"));
	}

	@Test(priority = 5)
	public void addExtras() throws InterruptedException {
		TravelCarsExtras tce = new TravelCarsExtras(driver);

		tce.setName("Nova Kola");
		Thread.sleep(2000);
		tce.setSelect(1);
		Thread.sleep(2000);
		tce.setPrice("1983");
		Thread.sleep(2000);
		tce.goToSave();
		Thread.sleep(2000);

		Assert.assertTrue(tce.getCarName().contains("Nova"));
	}

	@Test(priority = 10)
	public void uploadPicture() throws Exception {
		TravelCarsExtras tce = new TravelCarsExtras(driver);

		tce.setName("Nova Kola");
		Thread.sleep(2000);
		tce.setSelect(1);
		Thread.sleep(2000);
		tce.setPrice("1983");
		Thread.sleep(2000);
		tce.uploadImage("image\\Zastava101.png");
		Thread.sleep(2000);

		Assert.assertTrue(tce.isImageUploadedSuccessfuly());
	}

	@Test(priority = 10)
	public void inputCharsInPrice() throws Exception {
		TravelCarsExtras tce = new TravelCarsExtras(driver);

		tce.setName("Nova Kola");
		Thread.sleep(2000);
		tce.setSelect(1);
		Thread.sleep(2000);
		tce.setPrice("asdasfsdf");
		Thread.sleep(2000);

		Assert.assertFalse(tce.inputCharsInPriceField());
	}

	@AfterClass
	public void quit() {
		ex.closeExcell();
	}

}