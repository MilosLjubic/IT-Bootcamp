package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TravelCustomers extends BasicPage {

	private By editBtn = By.cssSelector("tbody [class='xcrud-row xcrud-row-1']:nth-of-type(2) [title='Edit']");
	private By firstname = By.cssSelector("input[name='fname']");
	private By lastname = By.cssSelector("input[name='lname']");
	private By email = By.name("email");
	private By mobile = By.name("mobile");
	private By country = By.cssSelector("select[name='country']");
	private By address = By.cssSelector("input[name='address1']");
	private By status = By.name("status");
	private By checkbox = By.className("checkbox");
	private By submit = By.cssSelector(".panel-footer .btn-primary");
	private By search = By.className("xcrud-search-toggle");
	private By inputField = By.className("xcrud-searchdata");
	private By table = By.className("xcrud-list table table-striped table-hover");

	public TravelCustomers(WebDriver driver) {
		super(driver);
	}

	public WebElement getEditBtn() {
		return this.driver.findElement(editBtn);
	}

	public WebElement getFirstName() {
		return this.driver.findElement(firstname);
	}

	public WebElement getLastName() {
		return this.driver.findElement(lastname);
	}

	public WebElement getEmail() {
		return this.driver.findElement(email);
	}

	public WebElement getMobile() {
		return this.driver.findElement(mobile);
	}

	public WebElement getCountry() {
		return this.driver.findElement(country);
	}

	public WebElement getAddress() {
		return this.driver.findElement(address);
	}

	public WebElement getStatus() {
		return this.driver.findElement(status);
	}

	public WebElement getCheckbox() {
		return this.driver.findElement(checkbox);
	}

	public WebElement getSubmit() {
		return this.driver.findElement(submit);
	}

	public WebElement getSerch() {
		return this.driver.findElement(search);
	}

	public WebElement getInputField() {
		return this.driver.findElement(inputField);
	}

	public List<WebElement> getRow() {
		return this.driver.findElements(table);
	}

	public void goToEdit() {
		this.getEditBtn().click();
	}

	public void setFirstName(String name) {
		this.getFirstName().clear();
		this.getFirstName().sendKeys(name);
	}

	public void setLastName(String name) {
		this.getLastName().clear();
		this.getLastName().sendKeys(name);
	}

	public void setEmail(String mail) {
		this.getEmail().clear();
		this.getEmail().sendKeys(mail);
	}

	public void setMobile(String number) {
		this.getMobile().clear();
		this.getMobile().sendKeys(number);
	}

	public void setCountry(String country) {
		this.getCountry().sendKeys(country);
	}

	public void setAddress(String address) {
		this.getAddress().clear();
		this.getAddress().sendKeys(address);
	}

	public void setStatus(int i) {
		Select select = new Select(this.getStatus());
		select.selectByIndex(i);
	}

	public void goToCheckbox() {
		this.getCheckbox().click();
	}

	public void goToSubmit() {
		this.getSubmit().click();
	}

	public void goToSearch() {
		this.getSerch().click();
	}

	public void setInputField(String text) {
		this.getInputField().click();
		this.getInputField().sendKeys(text);
		this.getInputField().sendKeys(Keys.ENTER);
	}

	public int numberOfRows() {
		return this.getRow().size();
	}

	public boolean isEditSuccessful() {
		return numberOfRows() == 1;
	}
}
