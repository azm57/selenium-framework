package com.pers.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.pers.utils.Browser;

public class ObjectLibraryWrapper {

	public static Craftsvilla_HomePage getObjCraftsvilla_HomePage() {
		return PageFactory.initElements(Browser.getDriver(), Craftsvilla_HomePage.class);
	}

	public static Craftsvilla_Registration getObjCraftsvilla_Registration() {
		return PageFactory.initElements(Browser.getDriver(), Craftsvilla_Registration.class);
	}

	public static Craftsvilla_Cart getObjCraftsvilla_Cart() {
		return PageFactory.initElements(Browser.getDriver(), Craftsvilla_Cart.class);
	}

	public static Craftsvilla_ProductDetails getobjCraftsvilla_ProductDetails() {
		return PageFactory.initElements(Browser.getDriver(), Craftsvilla_ProductDetails.class);
	}

	public static Craftsvilla_WishListPage getobjCraftsvilla_wishlistPage() {
		return PageFactory.initElements(com.pers.utils.Browser.getDriver(), Craftsvilla_WishListPage.class);

	}

	public static Rediff_HomePage getobjRediff_HomePage() {
		return PageFactory.initElements(com.pers.utils.Browser.getDriver(), Rediff_HomePage.class);

	}

}
