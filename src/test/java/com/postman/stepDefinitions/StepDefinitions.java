package com.postman.stepDefinitions;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.postman.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends CommonMethods {

	static String title;
	static List<String> dashboardTabs = new LinkedList<>();
	static List<String> dropDownList = new LinkedList<>();
	static int ddMenuNumber;
	static String mainWindow;

	@When("get page title")
	public void get_page_title() {
		title = driver.getTitle();
	}

	@Then("verify page title is {string}")
	public void verify_page_title_is(String expectedTitle) {
		Assert.assertEquals(expectedTitle, title);
	}

	@Then("verify main logo is present")
	public void verify_main_logo_is_present() {
		waitForVisibility(main.mainLogo);
		boolean mainLogoIsDisplayed = main.mainLogo.isDisplayed();
		Assert.assertTrue(mainLogoIsDisplayed);
	}

	@When("get dashboard tabs")
	public void get_dashboard_tabs() {
		for (int i = 0; i < main.dashboardTabsList.size(); i++) {
			WebElement element = main.dashboardTabsList.get(i);
			waitForVisibility(element);
			String elementText = element.getText();
			dashboardTabs.add(elementText);
		}
	}

	@Then("verify the following dashboard tabs")
	public void verify_the_following_dashboard_tabs(DataTable dashboardTabsTable) {
		List<String> expectedDashTabs = dashboardTabsTable.asList();
		Assert.assertEquals(expectedDashTabs, dashboardTabs);
	}

	@When("click Create Account Button")
	public void click_Create_Account_Button() {
		waitForClickability(main.createAccountButton);
		main.createAccountButton.click();
	}

	@Then("verify {string} message is present in Username text box")
	public void verify_message_is_present_in_Username_text_box(String usernameErrorMessage) {
		waitForVisibility(main.usernameEmptyMessage);
		String actualErrorMessage = main.usernameEmptyMessage.getText();
		Assert.assertEquals(usernameErrorMessage, actualErrorMessage);
	}

	@Then("verify {string} message is present in Email text box")
	public void verify_message_is_present_in_Email_text_box(String emailErrorMessage) {
		waitForVisibility(main.emailEmptyMessage);
		String actualErrorMessage = main.emailEmptyMessage.getText();
		Assert.assertEquals(emailErrorMessage, actualErrorMessage);
	}

	@Then("verify {string} message is present in Password text box")
	public void verify_message_is_present_in_Password_text_box(String passwordErrorMessage) {
		waitForVisibility(main.passwordEmptyMessage);
		String actualErrorMessage = main.passwordEmptyMessage.getText();
		Assert.assertEquals(passwordErrorMessage, actualErrorMessage);
	}

	@When("click Product Button")
	public void click_Product_Button() {
		waitForClickability(main.productDashboardButton);
		main.productDashboardButton.click();
	}

	@When("get the Product drop down list")
	public void get_the_Product_drop_down_list() {
		dropDownList.clear();
		for (int i = 0; i < main.productDropDownList.size(); i++) {
			WebElement element = main.productDropDownList.get(i);
			waitForVisibility(element);
			String elementText = element.getText();
			dropDownList.add(elementText);
		}
	}

	@Then("verify the following the Product drop down tabs")
	public void verify_the_following_the_Product_drop_down_tabs(DataTable dashboardProductDropDown) {
		List<String> expectedProductPropDown = dashboardProductDropDown.asList();
		Assert.assertEquals(expectedProductPropDown, dropDownList);
	}

	@When("click Use Cases Button")
	public void click_Use_Cases_Button() {
		waitForClickability(main.useCasesDashboardButton);
		main.useCasesDashboardButton.click();
	}

	@When("get the Use Cases drop down list")
	public void get_the_Use_Cases_drop_down_list() {
		dropDownList.clear();
		for (int i = 0; i < main.useCasesDropDownList.size(); i++) {
			WebElement element = main.useCasesDropDownList.get(i);
			waitForVisibility(element);
			String elementText = element.getText();
			dropDownList.add(elementText);
		}
	}

	@Then("verify the following the Use Cases drop down tabs")
	public void verify_the_following_the_Use_Cases_drop_down_tabs(DataTable dashboardUseCasesDropDown) {
		List<String> expectedProductPropDown = dashboardUseCasesDropDown.asList();
		Assert.assertEquals(expectedProductPropDown, dropDownList);
	}

	@When("enter a {string} data to the Username text box")
	public void enter_a_data_to_the_Username_text_box(String username) {
		sendText(main.usernameTextBox, username);
	}

	@When("enter a {string} data to the Email text box")
	public void enter_a_data_to_the_Email_text_box(String email) {
		sendText(main.emailTextBox, email);
	}

	@When("enter a {string} data to the Password text box")
	public void enter_a_data_to_the_Password_text_box(String password) {
		sendText(main.passwordTextBox, password);
	}

	@Then("verify that {string} is present in the empty text box")
	public void verify_that_is_present_in_the_empty_text_box(String expectedMessage) {
		waitForVisibility(main.emptyMessage);
		String actualMessage = main.emptyMessage.getText();
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("click {int} from Product drop down")
	public void click_from_Product_drop_down(Integer intDD) {
		ddMenuNumber = intDD;
		List<WebElement> productDDMenu = main.productDropDownList;
		waitForClickability(productDDMenu.get(intDD));
		productDDMenu.get(intDD).click();
	}

	@Then("verify that the page has the right {string} title")
	public void verify_that_the_page_has_the_right_title(String expectedTitle) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (ddMenuNumber >= 1 && ddMenuNumber <= 5) {
			expectedTitle += " | Postman";
		} else if (ddMenuNumber >= 7 && ddMenuNumber <= 10) {
			expectedTitle += " | Postman";
		}
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);

	}

	@When("click {int} from Use Cases drop down")
	public void click_from_Use_Cases_drop_down(Integer intDD) {
		ddMenuNumber = intDD;
		List<WebElement> useCasesDDMenu = main.useCasesDropDownList;
		waitForClickability(useCasesDDMenu.get(intDD));
		useCasesDDMenu.get(intDD).click();
	}

	@Then("verify that the new page has the right {string} title")
	public void verify_that_the_new_page_has_the_right_title(String expectedTitle) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (ddMenuNumber == 0 || ddMenuNumber == 4) {
			expectedTitle += " | Use Cases | Postman";
		} else if (ddMenuNumber >= 1 && ddMenuNumber <= 3) {
			expectedTitle += " | Postman";
		} else if (ddMenuNumber == 5) {
			expectedTitle += " | Postman";
		} else if (ddMenuNumber >= 7 && ddMenuNumber <= 8) {
			expectedTitle += " | Postman";
		}

		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@When("click Pricing Button")
	public void click_Pricing_Button() {
		waitForClickability(main.pricingDashboardButton);
		click(main.pricingDashboardButton);
	}

	@Then("verify that the Pricing page has the {string} title")
	public void verify_that_the_Pricing_page_has_the_title(String expectedTitle) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@When("click Enterprise Button")
	public void click_Enterprise_Button() {
		waitForClickability(main.enterpriseDashboardButton);
		click(main.enterpriseDashboardButton);
	}

	@Then("verify that the Enterprise page has the {string} title")
	public void verify_that_the_Enterprise_page_has_the_title(String expectedTitle) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@When("click Explore Button")
	public void click_Explore_Button() {
		mainWindow = driver.getWindowHandle();
		waitForClickability(main.exploreDashboardButton);
		click(main.exploreDashboardButton);
	}

	@Then("verify that the new Explore has the {string} title")
	public void verify_that_the_new_Explore_has_the_title(String expectedTitle) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Set<String> windows = driver.getWindowHandles();
		for (String string : windows) {
			if (!string.equalsIgnoreCase(mainWindow)) {
				driver.switchTo().window(string);
			}
		}
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@When("click Learning Center Button")
	public void click_Learning_Center_Button() {
		mainWindow = driver.getWindowHandle();
		waitForClickability(main.learningCenterDashboardButton);
		click(main.learningCenterDashboardButton);
	}

	@Then("verify that the Learning Center page has the {string} title")
	public void verify_that_the_Learning_Center_page_has_the_title(String expectedTitle) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Set<String> windows = driver.getWindowHandles();
		for (String string : windows) {
			if (!string.equalsIgnoreCase(mainWindow)) {
				driver.switchTo().window(string);
			}
		}
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@When("click Product Button again")
	public void click_Product_Button_again() {
		waitForVisibility(main.productDropDownList.get(0));
		main.pricingDashboardButton.click();
	}

	@Then("verify that the Product drop down is closed")
	public void verify_that_the_Product_drop_down_is_closed() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    Assert.assertFalse(main.productDropDownList.get(0).isDisplayed());
	}

	@When("click Use Cases Button again")
	public void click_Use_Cases_Button_again() {
		waitForVisibility(main.useCasesDropDownList.get(0));
		main.useCasesDashboardButton.click();
	}

	@Then("verify that the Use Cases drop down is closed")
	public void verify_that_the_Use_Cases_drop_down_is_closed() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertFalse(main.useCasesDropDownList.get(0).isDisplayed());
	}

}
