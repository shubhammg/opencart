package com.hyrsite.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hyrsite.qa.base.TestBase;

public class LandingPage extends TestBase{
	@FindBy(xpath="//input[@type=\"text\" and @name='email']")
	public WebElement email;
	
	@FindBy(xpath="//input[@type=\"password\" and @name='password']")
	WebElement password;
    @FindBy(xpath="//button[@class=\"btn btn-primary btn-lg hidden-xs\"]")
    WebElement login;
	
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}


	public void loginBtn() {
		login.click();
	}
}
