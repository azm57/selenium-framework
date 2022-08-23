package com.epam.pageobjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.epam.fixtures.ActionsUtil;
import com.epam.utils.Browser;
import com.epam.utils.CustomeExceptionUtil;
import com.epam.utils.report.Log;

public class Craftsvilla_Cart {
	
	WebDriver driver = Browser.getDriver();

	@FindBy(xpath="//span[text()='Cart ']")
	WebElement lnkCart;
	
	@FindBy(xpath=".//*[@id='proccedToCheckoutBtn']")
	WebElement btnProceedToCheckOut;
	
	@FindBys(value = { @FindBy(xpath = "//div[@check-out='']//div[@class='cart-details-cont']/div[1]") })
	List<WebElement> productNames;

	@FindBys(value = { @FindBy(xpath = "//div[@check-out='']//div[@class='cart-details-cont']/div[4]/div") })
	List<WebElement> productPrices;

	@FindBy(xpath = "//div[text()='YOUR CART IS EMPTY']")
	WebElement YourCartisEmptyMessage;
	

	public void navigateToCart() throws Exception {
		if(!ActionsUtil.gFunc_ClickElement(lnkCart)){
			throw new CustomeExceptionUtil("Cart link not found");
		} else {
			Log.info("Cart link is found and clicked successfully");
		}
		
	}


	
	public void verifyCartItems() throws Exception {
// added now
		Thread.sleep(5000);
		if (!productNames.equals(null) && !productPrices.equals(null)
				&& (productNames.size() == productPrices.size())) {
			for (int i = 0; i < productNames.size(); i++) {
				// Validating ProductName
				if (!ActionsUtil.bFunc_WaitForObjectExistance(productNames.get(i))) {
					if (!ActionsUtil.bFunc_WaitForObjectExistance(YourCartisEmptyMessage)) {
						throw new CustomeExceptionUtil("Cart Items:" + i + " as well as Cart Empty message not found");
					} else {
					Log.info("Your Cart is empty message found");
					}
				} else if (ActionsUtil.gFunc_GetElementText(productNames.get(i)).toString()
						.equalsIgnoreCase(Craftsvilla_ProductDetails.productDetailsMap.get("ProductName" + i).toString())) {
					Log.info("Product" + i + " name found and verified successfully");
				} else {
									
					Log.info("Product" + i + " name not verified!!!");
					//Not sure if we have to fail the Test here
				}

				// Validating ProductPrice
				if (!ActionsUtil.bFunc_WaitForObjectExistance(productPrices.get(i))) {
					throw new CustomeExceptionUtil("Product" + i + " price not found");
				} else if (ActionsUtil.gFunc_GetElementText(productPrices.get(i))
						.equals(Craftsvilla_ProductDetails.productDetailsMap.get("ProductPrice" + i))) {
					Log.info("Product" + i + " price found and verified sucessfully");
				} else {
					Log.info("Product" + i + " price not verified!!!");
					//Not sure if we have to fail the Test here
				}
			}

		} else {
			throw new CustomeExceptionUtil("Product Names and Product Prices are empty or not equal");
		}
		System.out.println("Test Completed!##############");
	}
	
	
}