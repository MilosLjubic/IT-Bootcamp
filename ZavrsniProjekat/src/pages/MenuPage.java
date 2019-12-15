package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage extends BasicPage {

	private By dashboard = By.cssSelector("ul#social-sidebar-menu > li:nth-of-type(1) > a");
	private By updates = By.cssSelector("ul#social-sidebar-menu > li:nth-of-type(2) > a");
	private By modules = By.cssSelector("ul#social-sidebar-menu > li:nth-of-type(3) > a");

	private By accounts = By.cssSelector("ul#social-sidebar-menu > li:nth-of-type(5) > a");
	private By accCustomers = By.cssSelector("ul#ACCOUNTS > li:nth-of-type(3) > a");

	private By tours = By.cssSelector("ul#social-sidebar-menu > li:nth-of-type(9) > a");
	private By toursAdd = By.cssSelector("ul#Tours > li:nth-of-type(2) > a");

	private By cars = By.cssSelector("ul#social-sidebar-menu > li:nth-of-type(10) > a");
	private By allCars = By.cssSelector("ul#Cars > li:nth-of-type(1) > a");
	private By carsExtras = By.cssSelector("ul#Cars > li:nth-of-type(2) > a");

	private By coupons = By.cssSelector("ul#social-sidebar-menu > li:nth-of-type(15) > a");
	private By newsletter = By.cssSelector("ul#social-sidebar-menu > li:nth-of-type(16) > a");
	private By bookings = By.cssSelector("ul#social-sidebar-menu > li:nth-of-type(17) > a");

	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getDashboard() {
		return this.driver.findElement(dashboard);
	}

	public WebElement getUpdates() {
		return this.driver.findElement(updates);
	}

	public WebElement getModules() {
		return this.driver.findElement(modules);
	}

	public WebElement getAccounts() {
		return this.driver.findElement(accounts);
	}

	public WebElement getAccCustomers() {
		return this.driver.findElement(accCustomers);
	}

	public WebElement getTours() {
		return this.driver.findElement(tours);
	}

	public WebElement getToursAdd() {
		return this.driver.findElement(toursAdd);
	}

	public WebElement getCars() {
		return this.driver.findElement(cars);
	}

	public WebElement getAllCars() {
		return this.driver.findElement(allCars);
	}

	public WebElement getCarsExtras() {
		return this.driver.findElement(carsExtras);
	}

	public WebElement getCoupons() {
		return this.driver.findElement(coupons);
	}

	public WebElement getNewsletter() {
		return this.driver.findElement(newsletter);
	}

	public WebElement getBookings() {
		return this.driver.findElement(bookings);
	}

	public void goToDashboard() {
		this.getDashboard().click();
	}

	public void goToUpdates() {
		this.getUpdates().click();
	}

	public void goToModules() {
		this.getModules().click();
	}

	public void goToAccounts() {
		this.getAccounts().click();
	}

	public void goToAccCustomers() {
		this.getAccCustomers().click();
	}

	public void goToTours() {
		this.getTours().click();
	}

	public void goToAddTours() {
		this.getToursAdd().click();
	}

	public void goToCars() {
		this.getCars().click();
	}

	public void goToAllCars() {
		this.getAllCars().click();
	}

	public void goToCarsExtras() {
		this.getCarsExtras().click();
	}

	public void goToCoupons() {
		this.getCoupons().click();
	}

	public void goToNewsletter() {
		this.getNewsletter().click();
	}

	public void goToBookings() {
		this.getBookings().click();
	}

}
