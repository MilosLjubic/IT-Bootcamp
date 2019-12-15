package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TravelCarsExtras extends BasicPage {

	private By add = By.cssSelector(".btn.btn-success.xcrud-action");
	private By name = By.name("cHRfZXh0cmFzLmV4dHJhc190aXRsZQ--");
	private By status = By.name("cHRfZXh0cmFzLmV4dHJhc19zdGF0dXM-");
	private By price = By.cssSelector("input[name='cHRfZXh0cmFzLmV4dHJhc19iYXNpY19wcmljZQ--']");
	private By addImageBtn = By.name("xcrud-attach");
	private By save = By.cssSelector(".btn.btn-primary.xcrud-action");
	private By carNameField = By.cssSelector("tr:nth-of-type(1) > td:nth-of-type(4)");
	private By remove = By.cssSelector(".xcrud-upload-container a");
	private By message = By.className("xcrud-message error");

	public TravelCarsExtras(WebDriver driver) {
		super(driver);
	}

	public WebElement getAdd() {
		return this.driver.findElement(add);
	}

	public WebElement getName() {
		return this.driver.findElement(name);
	}

	public WebElement getStatus() {
		return this.driver.findElement(status);
	}

	public WebElement getPrice() {
		return this.driver.findElement(price);
	}

	public WebElement getImageBtn() {
		return this.driver.findElement(addImageBtn);
	}

	public WebElement getSave() {
		return this.driver.findElement(save);
	}

	public WebElement getCarNameField() {
		return this.driver.findElement(carNameField);
	}

	public WebElement getRemove() {
		return this.driver.findElement(remove);
	}

	public WebElement getMessage() {
		return this.driver.findElement(message);
	}

	public void goToAdd() {
		this.getAdd().click();
	}

	public void setName(String name) {
		this.getName().sendKeys(name);
		this.getName().sendKeys(Keys.ENTER);
	}

	public void setSelect(int i) {
		Select select = new Select(this.getStatus());
		select.selectByIndex(i);
	}

	public void setPrice(String cena) {
		this.getPrice().sendKeys(cena);
		this.getPrice().sendKeys(Keys.ENTER);
	}

	public void uploadImage(String path) {
		getImageBtn().sendKeys(new File(path).getAbsolutePath());
	}

	public void goToSave() {
		this.getSave().click();
	}

	public void goToRemove() {
		this.getRemove().click();
	}

	public String getCarName() {
		return this.getCarNameField().getText();
	}

	public boolean isImageUploadedSuccessfuly() {
		try {
			return getRemove() != null;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean inputCharsInPriceField() {
		try {
			return getMessage() != null;
		} catch (Exception e) {
			return false;
		}
	}

}