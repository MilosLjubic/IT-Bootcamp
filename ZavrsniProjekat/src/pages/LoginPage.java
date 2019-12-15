package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasicPage {

	private By email = By.name("email");
	private By password = By.name("password");
	private By checkbox = By.className("checkbox");
	private By forgetPass = By.id("link-forgot");
	private By loginBtn = By.cssSelector("button[type='submit']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void setEmail(String email) {
		this.driver.findElement(this.email).sendKeys(email);
	}

	public void setPassword(String password) {
		this.driver.findElement(this.password).sendKeys(password);
	}

	public void clickOnCheckbox() {
		this.driver.findElement(this.checkbox).click();
	}

	public void clickOnForgetPass() {
		this.driver.findElement(this.forgetPass).click();
	}

	public void clickOnLoginBtn() {
		this.driver.findElement(this.loginBtn).click();
	}

	public void signIn(String email, String password, boolean checkbox) {
		this.setEmail(email);
		this.setPassword(password);
		if (checkbox == false) {
			this.clickOnCheckbox();
		}
		this.clickOnLoginBtn();
	}
}
