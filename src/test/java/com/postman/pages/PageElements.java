package com.postman.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.postman.testbase.PageInitializer;

public class PageElements extends PageInitializer{
	
	@FindBy(xpath = "//a[starts-with(@class, 'Header__NavBarItem-sc-59e0yl-3 hBtOWV nav-link')]")
	public List<WebElement> dashboardTabsList;
	
	@FindBy(xpath = "//img[starts-with(@class, 'Header__Brand')]")
	public WebElement mainLogo;
	
	@FindBy(xpath = "//button[text() = 'Create Account']")
	public WebElement createAccountButton;
	
	@FindBy(xpath = "(//div[starts-with(@class , 'testSignUpForm__Invalid-y2sn5o-8 edIqCi inline-errormsg')])[1]")
	public WebElement usernameEmptyMessage;
	
	@FindBy(xpath = "(//div[starts-with(@class , 'testSignUpForm__Invalid-y2sn5o-8 edIqCi inline-errormsg')])[2]")
	public WebElement emailEmptyMessage;
	
	@FindBy(xpath = "(//div[starts-with(@class , 'testSignUpForm__Invalid-y2sn5o-8 edIqCi inline-errormsg')])[3]")
	public WebElement passwordEmptyMessage;
	
	@FindBy(xpath = "//div[starts-with(@class , 'testSignUpForm__Invalid-y2sn5o-8 edIqCi inline-errormsg')]")
	public WebElement emptyMessage;
	
	@FindBy(xpath = "//a[text()='Product']")
	public WebElement productDashboardButton;
	
	@FindBy(xpath = "//a[@class='dropdown-item']")
	public List<WebElement> productDropDownList;
	
	@FindBy(xpath = "//a[text()='Use Cases']")
	public WebElement useCasesDashboardButton;
	
	@FindBy(xpath = "//a[@class='Header__DropDownItem-sc-59e0yl-8 irjXev dropdown-item']")
	public List<WebElement> useCasesDropDownList;
	
	@FindBy(xpath = "//a[text()='Pricing']")
	public WebElement pricingDashboardButton;
	
	@FindBy(xpath = "//a[text()='Enterprise']")
	public WebElement enterpriseDashboardButton;
	
	@FindBy(xpath = "//a[text()='Explore']")
	public WebElement exploreDashboardButton;
	
	@FindBy(xpath = "//a[text()='Learning Center']")
	public WebElement learningCenterDashboardButton;
	
	@FindBy(css = "input#sdkUsername")
	public WebElement usernameTextBox;
	
	@FindBy(css = "input#sdkEmail")
	public WebElement emailTextBox;
	
	@FindBy(css = "input#sdkPassword")
	public WebElement passwordTextBox;
	

	public PageElements() {
		PageFactory.initElements(driver, this);
	}
	
}