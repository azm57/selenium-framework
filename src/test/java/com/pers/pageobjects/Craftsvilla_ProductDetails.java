package com.pers.pageobjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.pers.fixtures.ActionsUtil;
import com.pers.utils.Browser;
import com.pers.utils.CustomeExceptionUtil;
import com.pers.utils.report.Log;

public class Craftsvilla_ProductDetails {

	WebDriver driver = Browser.getDriver();

	@FindBy(xpath = "//div[@class='product_description col-xs-12']/h1")
	WebElement txtProductName;

	@FindBy(xpath = "//div[@class='col-xs-12 price_container nopadding']//span[@itemprop='price']")
	WebElement txtProductPrice;

	@FindBy(xpath = "//div[@id='addtocart']")
	WebElement btnAddToCart;

	@FindBy(xpath = "//div[@id='productpagesuccessmsg']")
	WebElement txtCartMessage;

	@FindBys(value = { @FindBy(xpath = "//div[@class='wishlist']/div[@class='wishlist-icon icon']") })
	List<WebElement> lnkWishProducts;

	@FindBys(value = { @FindBy(xpath = ".//div[@id='listProducts']//div[@class='prod-image-container']/a") })
	List<WebElement> lnkProductImages;

	@FindAll(value = {
			@FindBy(xpath = ".//div[@id='listProducts']//div[@class='prod-details-container col-xs-12']/a[1]/div") })
	List<WebElement> lnkProducts;

	public static HashMap<String, String> productDetailsMap = new HashMap<String, String>();

	public void addProductsToCart() throws Exception {

		if (!lnkProducts.equals(null)) {
			for (int i = 0; i < 4; i++) {
				// click on Product link
				if (!ActionsUtil.gFunc_ClickElement(lnkProducts.get(i))) {
					throw new CustomeExceptionUtil("Product: " + i + " not found");
				} else {
					Log.info("Product: " + i + " found and clicked successfully");
				}

				// get the Product details and save to map
				if (!ActionsUtil.bFunc_WaitForObjectExistance(txtProductName)
						|| (!ActionsUtil.bFunc_WaitForObjectExistance(txtProductPrice))) {
					throw new CustomeExceptionUtil("Product: " + i + " Name or Price not found");
				} else {
					String strProductName = ActionsUtil.gFunc_GetElementText(txtProductName);
					String strProductPrice = ActionsUtil.gFunc_GetElementText(txtProductPrice);
					productDetailsMap.put("ProductName" + i, strProductName);
					productDetailsMap.put("ProductPrice" + i, strProductPrice);

					Log.info("Product: " + i + "Name, Price found and saved successfully");
				}

				// Click on Add To Cart Button
				if (!ActionsUtil.gFunc_ClickElement(btnAddToCart)) {
					throw new CustomeExceptionUtil("Add To Cart Button not Found");
				} else {
					Log.info("Product: " + i + "is added to cart Successfully");
				}

				// validate "Your Product is added to Cart Message"
				if (!ActionsUtil.bFunc_WaitForObjectExistance(txtCartMessage)) {
					throw new CustomeExceptionUtil("Added to cart success Message is not found");
				} else if (ActionsUtil.gFunc_GetElementText(txtCartMessage)
						.equals("Product has been successfully added to your cart.")) {
					Log.info("Add to Cart Success Message is displayed");
				} else {
					throw new CustomeExceptionUtil("Cart Message is found but not equal");

				}
				Browser.getDriver().navigate().back();
				Thread.sleep(3000);
			}
		} else {
			throw new CustomeExceptionUtil("Products are not found");
		}
	}

	public void addProductsToWishlist() throws Exception {

		if (!(lnkProductImages.equals(null) && !(lnkWishProducts.equals(null)))) {
			for (int i = 0; i < 4; i++) {
				// Mouse hover to Product Image, mouse hover to wish icon and
				if (!ActionsUtil.bFunc_WaitForObjectExistance(lnkProductImages.get(i))) {
					throw new CustomeExceptionUtil("Product: " + i + "Image link not found");
				} else {
					ActionsUtil.MoveMousetoElement(lnkProductImages.get(i));
					if (ActionsUtil.MoveToAndMouseClick(lnkWishProducts.get(i))) {
						Log.info("Product: " + i + " found and clicked successfully");
					} else {
						throw new CustomeExceptionUtil("Product: " + i + "Wish link not found");
					}
				}

				// Get the wished Product details into a Map
				if (!ActionsUtil.bFunc_WaitForObjectExistance(txtProductName)
						|| (!ActionsUtil.bFunc_WaitForObjectExistance(txtProductPrice))) {
					throw new CustomeExceptionUtil("Product: " + i + " Name or Price not found");
				} else {
					String strProductName = ActionsUtil.gFunc_GetElementText(txtProductName);
					String strProductPrice = ActionsUtil.gFunc_GetElementText(txtProductPrice);
					productDetailsMap.put("WishProductName" + i, strProductName);
					productDetailsMap.put("WishProductPrice" + i, strProductPrice);

					Log.info("Wished Product: " + i + "Name, Price found and saved successfully");
				}

				// ###########################################################
				// Wised Message has to be validated
			}
		}
	}
}
