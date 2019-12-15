package pages;

import java.io.File;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelCars extends BasicPage {

	private By table = By.className("xcrud-row");
	private By upload = By.cssSelector("[href='https://www.phptravels.net/admin/cars/gallery/Camioneta-151']");
	private By addBtn = By.cssSelector("a.btn.btn-success");
	private By dropFiles = By.cssSelector("body > input");
	private By newRow = By.id("tr_74");

	public TravelCars(WebDriver driver) {
		super(driver);
	}

	public List<WebElement> getRow() {
		return this.driver.findElements(table);
	}

	public WebElement getUpload() {
		return this.driver.findElement(upload);
	}

	public WebElement getAddBtn() {
		return this.driver.findElement(addBtn);
	}

	public WebElement getDropFiles() {
		return this.driver.findElement(dropFiles);
	}

	public WebElement getNewRow() {
		return this.driver.findElement(newRow);
	}

	public int numberOfRows() {
		return this.getRow().size();
	}

	public void goToUpload() {
		this.getUpload().click();
	}

	public void goToAddBtn() {
		this.getAddBtn().click();
	}

	public void dropImage(String path) {
		getDropFiles().sendKeys(new File(path).getAbsolutePath());
	}

	public int numberOfDifferent() {
		HashSet<String> hs = new HashSet<String>();
		for (int i = 0; i < this.numberOfRows(); i++) {
			WebElement nameRow = this.getRow().get(i).findElements(By.tagName("td")).get(4);
			String name = nameRow.getText();
			hs.add(name);
		}
		return hs.size();
	}

	public int getNubmerOfOrders() {
		int sum = 0;
		for (int i = 0; i < this.numberOfRows(); i++) {
			WebElement orders = this.getRow().get(i).findElements(By.tagName("td")).get(9);
			sum += Integer.parseInt(orders.findElement(By.tagName("input")).getAttribute("value"));
		}
		return sum;
	}

	public boolean isImageUploadedSuccessfuly() {
		try {
			return getNewRow() != null;
		} catch (Exception e) {
			return false;
		}
	}

}
