package com.pers.pageobjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pers.fixtures.ActionsUtil;
import com.pers.utils.Browser;
import com.pers.utils.CustomeExceptionUtil;
import com.pers.utils.ExcelUtil;
import com.pers.utils.report.Log;

public class Craftsvilla_HomePage {
	public String strCategory;
	public String strsubcat;
	public String strCatgoryXpath;
	public String strSubCatXpath;

	WebDriver driver = Browser.getDriver();

	@FindBy(xpath = "/html/body/div[1]/nav[2]/div[1]/div[3]/a[1]/i")
	List<WebElement> lnkHomePge;;

	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	List<WebElement> btnSign;

//	@FindBy(xpath = strCatgoryXpath)
//	WebElement lnkCategory;
//
//	@FindBy(xpath = ".//nav[@id='mega-menu']/div/ul//a[text()='LEHENGA ']/parent::li//a[text()='Festival']")
//	WebElement lnkSubCategory;

	@FindBy(xpath = ".//a[@id='cart-url-desktop']/span[text()='Cart ']")
	WebElement lnkCart;

	@FindBy(xpath = ".//a[@href='/wishlist/']/i")
	WebElement lnkWishlist;

	public void Login() throws Exception {

		if (!ActionsUtil.gFunc_ClickElement(lnkHomePge.get(0))) {
			throw new CustomeExceptionUtil("HomePage link not found");
		} else {
			Log.info("Home Page Link found and clicked successfully");
		}

		Set<String> s = driver.getWindowHandles();
		System.out.println(s);
		Iterator<String> I1 = s.iterator();
		driver.switchTo().window(I1.next());
		System.out.println(driver.getTitle());
		// Enter email
		if (!ActionsUtil.gFunc_SendText(txtEmail, ExcelUtil.objTestDataMap.get("Login_Email"))) {
			throw new CustomeExceptionUtil("Email Field not found");
		} else {
			Log.info("Email entered successfully");
		}

		// Enter Password
		if (!ActionsUtil.gFunc_SendText(txtPassword, ExcelUtil.objTestDataMap.get("Login_Password"))) {
			throw new CustomeExceptionUtil("Password Field not found");
		} else {
			Log.info("Password entered successfully");
		}

		if (!ActionsUtil.gFunc_ClickElement(btnSign.get(0))) {
			throw new CustomeExceptionUtil("SignIn Button not found");
		} else {
			Log.info("SignIn button found and clicked successfully");
		}
	}

	// @SuppressWarnings("finally")
	public void NavToProdCat() throws Exception {
		try {
			strCategory = ExcelUtil.objTestDataMap.get("Prod_Cat");
			strCatgoryXpath = ".//nav[@id='mega-menu']/div/ul//a[contains(text(),'" + strCategory + "')]";
			WebElement lnkCategory = driver.findElement(By.xpath(strCatgoryXpath));

			strsubcat = ExcelUtil.objTestDataMap.get("Prod_Sub_Cat");
			strSubCatXpath = ".//nav[@id='mega-menu']/div/ul//a[contains(text(),'" + strCategory + "')]";
			WebElement lnkSubCat = driver.findElement(By.xpath(strSubCatXpath));

			if (!ActionsUtil.MoveMousetoElement(lnkCategory)) {
				throw new CustomeExceptionUtil("Product Category" + strCategory + " not found");
			} else {
				Log.info("Clicked on Product Category successfully");
			}

			if (!ActionsUtil.gFunc_ClickElement(lnkSubCat)) {
				throw new CustomeExceptionUtil("Product Sub Category" + strsubcat + " not found");
			} else {
				Log.info("Clicked on Product Sub Category successfully");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// throw new CustomeExceptionUtil("Object not found");
		}
	}

}