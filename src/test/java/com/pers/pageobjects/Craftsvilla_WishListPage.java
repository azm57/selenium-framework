package com.pers.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.pers.fixtures.ActionsUtil;
import com.pers.utils.CustomeExceptionUtil;
import com.pers.utils.report.Log;

public class Craftsvilla_WishListPage {

	@FindBys(value = { @FindBy(xpath = ".//table[@id='wishlist-table']//tr/td//li/p/a/b") })
	List<WebElement> wishProductNames;

	@FindBys(value = { @FindBy(xpath = ".//span[@id='product-price']/b") })
	List<WebElement> wishProductPrices;

	@FindBy(xpath = ".//div[@id='main']//p[text()='You have no items in your wishlist.']")
	WebElement wishlistMessage;

//	.//table[@id='wishlist-table']//tr/td//li/p/a/b

	public void navigateToWishlist() throws Exception {
		if (!ActionsUtil.gFunc_ClickElement(ObjectLibraryWrapper.getObjCraftsvilla_HomePage().lnkWishlist)) {
			throw new CustomeExceptionUtil("Wishlist link not found");
		} else {
			Log.info("Wishlist link found and clicked successfully");
		}

	}

	public void VerifyWishlistItems() throws Exception {
		if (!wishProductNames.equals(null) && !wishProductPrices.equals(null)
				&& (wishProductNames.size() == wishProductPrices.size())) {

			for (int i = 0; i < wishProductNames.size(); i++) {
				// Validating WishlistProductName
				if (!ActionsUtil.bFunc_WaitForObjectExistance(wishProductNames.get(i))) {
					if (!ActionsUtil.bFunc_WaitForObjectExistance(wishlistMessage)) {
						throw new CustomeExceptionUtil("Wishlist Items:" + i + " and Wishlist Empty message not found");
					} else {
						Log.info("Your have no items in your wishlist message found");
					}
				} else if (ActionsUtil.gFunc_GetElementText(wishProductNames.get(i))
						.equals(Craftsvilla_ProductDetails.productDetailsMap.get("WishProductName" + i))) {
					Log.info("Product" + i + " name found in wishlist and verified successfully");
				} else {
					Log.info("Product" + i + " name not verified!!!");
					// Not sure if we have to fail the Test here

				}

				// Validating WihslistProductPrice
				if (!ActionsUtil.bFunc_WaitForObjectExistance(wishProductPrices.get(i))) {
					throw new CustomeExceptionUtil("Product" + i + " price not found in wishlist");
				} else if (ActionsUtil.gFunc_GetElementText(wishProductPrices.get(i))
						.equals(Craftsvilla_ProductDetails.productDetailsMap.get("WishProductPrice" + i))) {
					Log.info("Product" + i + " price found in wishlist and verified sucessfully");
				} else {
					Log.info("Product" + i + " price not verified!!!");
					// Not sure if we have to fail the Test here
				}

			}

		} else {
			throw new CustomeExceptionUtil("WishProduct Name or wishProduct list are empty or not equal");
		}
	}
}
