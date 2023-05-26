package com.hyrsite.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hyrsite.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(xpath="//img[@src=\"application/view/image/icon/opencart-logo.png\"]")
	public WebElement img;
	@FindBy(xpath="//ul[@class=\"nav navbar-nav\"]//a[@href=\"https://www.opencart.com/index.php?route=cms/feature\"]")
	public WebElement feature;
	@FindBy(xpath="//ul[@class=\"nav navbar-nav\"]//a[@href=\"https://www.opencart.com/index.php?route=cms/demo\"]")
	WebElement demo;
	@FindBy(xpath="//ul[@class=\"nav navbar-nav\"]//a[@href=\"https://www.opencart.com/index.php?route=marketplace/extension\"]")
	WebElement marketplace;
	@FindBy(xpath="//ul[@class=\"nav navbar-nav\"]//a[starts-with(text(),\"Blog\")]")
	WebElement blog;
	@FindBy(xpath="//ul[@class=\"nav navbar-nav\"]//a[starts-with(text(),\"Download\")]")
	WebElement download;
	@FindBy(xpath="//a[@href=\"#\" and @data-toggle=\"dropdown\" ]")
	WebElement resource;
	
/*	public void selectDropdownOptionByValue(String optionValue) {
        Select dropdown = new Select(resource);
        dropdown.selectByValue(optionValue);}
	*/
	
	
	@FindBy(xpath="//a[@class=\"btn btn-link navbar-btn\" ]")
	WebElement Login;
	@FindBy(xpath="//a[@class=\"btn btn-black navbar-btn\"]")
	WebElement register;
	@FindBy(xpath="//a[@class=\"btn btn-primary btn-xl\" and starts-with(text(),'Get')]")
	WebElement getStarted;
	
//INITIALIZE page object
public LoginPage() {
	PageFactory.initElements(driver, this);
	
	
} 


public String validatePageTitle() {

return driver.getTitle();
}
public HomePage loginBtn() {
	
	Login.click();
	return new HomePage();
}
public LandingPage clickFunction() {
	getStarted.click();
return new LandingPage();
}
}