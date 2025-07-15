package com.base.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PersonalDetailsPage {
	WebDriver driver;

	@FindBy(xpath = "//ul[@class='oxd-main-menu']//li[6]")
	private WebElement myinfo;

	@FindBy(name = "firstName")
	private WebElement firstName;

	@FindBy(name = "middleName")
	private WebElement middleName;

	@FindBy(name = "lastName")
	private WebElement lastName;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement empDetailsSave;

	@FindBy(className = "oxd-userdropdown-name")
	private WebElement loggedInUser;

	public PersonalDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMyInfo() {
		myinfo.click();
	}

	public void AddEmployeeDetails() {
		
//		firstName.sendKeys(Keys.CONTROL, Keys.chord("a"));
//		firstName.sendKeys(Keys.BACK_SPACE);
		
//		Actions actions = new Actions(driver);
//		actions.click(firstName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		firstName.clear();
		firstName.sendKeys("Pal");
		
		middleName.clear();
		middleName.sendKeys("Test");
		
		lastName.clear();
		lastName.sendKeys("Yes");
				
		empDetailsSave.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		String loggedUser = loggedInUser.getText();
		
	}
}
