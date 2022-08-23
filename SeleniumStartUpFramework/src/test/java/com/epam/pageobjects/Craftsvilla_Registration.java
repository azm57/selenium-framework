package com.epam.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.fixtures.ActionsUtil;
import com.epam.utils.Browser;
import com.epam.utils.CustomeExceptionUtil;
import com.epam.utils.ExcelUtil;
import com.epam.utils.report.Log;

public class Craftsvilla_Registration {
	
	WebDriver driver = Browser.getDriver();
	
	@FindBy(xpath=".//div[@class='modal-dialog']//a[@id='register-hover']")
		WebElement lnkRegister;
	
	@FindBy(xpath=".//div[@class='modal-dialog']//*[@id='firstname']")
		WebElement txtFirstName;
	 
	@FindBy(xpath=".//div[@class='modal-dialog']//*[@id='lastname']")
		WebElement txtLastName;
	 
	@FindBy(xpath=".//div[@class='modal-dialog']//*[@id='telephone']")
		WebElement txtTelephone;
	 
	@FindBy(xpath=".//div[@class='modal-dialog']//*[@id='email_address']")
		WebElement txtEmail;
	
	@FindBy(xpath=".//div[@class='modal-dialog']//*[@id='password']")
		WebElement txtPassword;
	
	@FindBy(xpath=".//div[@class='modal-dialog']//*[@id='confirmation']")
		WebElement txtPasswordConf;
	
	@FindBy(xpath=".//div[@class='modal-dialog']//*[@id='register-header']")
		WebElement btnRegister;
	
	@FindBy(xpath="//ul[@class='messages']//span[text()='Thank you for registering with Craftsvilla.com.']")
	WebElement SuccessfulRegistrationMsg;
	
	@FindBy(xpath="	//ul[@class='messages']//span")
	WebElement ErrorMsg;


	public void UserRegistration() throws Exception{
		
		//Click on Signin Link 
		if (!ActionsUtil.gFunc_ClickElement(ObjectLibraryWrapper.getObjCraftsvilla_HomePage().lnkHomePge.get(0))){
			throw new CustomeExceptionUtil("SignIn link not found");
		}
		else{Log.info("SignIn Link found and clicked successfully"); }
		
		//Click on Register Link
		if (!ActionsUtil.gFunc_ClickElement(lnkRegister)){
			throw new CustomeExceptionUtil("Register link not found");
		}
		else{Log.info("REgister Link found and clicked successfully"); }
		
		//Enter FirstName
		if (!ActionsUtil.gFunc_SendText(txtFirstName,ExcelUtil.objTestDataMap.get("Reg_FirstName"))){
			throw new CustomeExceptionUtil("Firtst Name field not found");
		}
		else{Log.info("First Name entered successfully"); }
		
		//Enter  LastName
		if (!ActionsUtil.gFunc_SendText(txtLastName,ExcelUtil.objTestDataMap.get("Reg_LastName"))){
			throw new CustomeExceptionUtil("Last Name field not found");
		}
		else{Log.info("Last Name entered successfully"); }
		
		//Enter MobileNo
		if (!ActionsUtil.gFunc_SendText(txtTelephone,ExcelUtil.objTestDataMap.get("Reg_MobileNo"))){
			throw new CustomeExceptionUtil("Telephone field not found");
		}
		else{Log.info("Telephone entered successfully"); }
		
		
		//Enter Email
		String strEmailID;
		if(ExcelUtil.objTestDataMap.get("Reg_EmailID").equals("Random")){
			int intRndValue = (int) (Math.random() * 100000);
			strEmailID = "sampledemo_" + intRndValue  +"@demo.com";
		} 
		else{  strEmailID =ExcelUtil.objTestDataMap.get("Reg_EmailID");	}
			
	
		if (!ActionsUtil.gFunc_SendText(txtEmail,strEmailID)){
			throw new CustomeExceptionUtil("Email field not found");
		}
		else{Log.info("Email entered successfully"); }
		
		
		//Enter Password
		if (!ActionsUtil.gFunc_SendText(txtPassword,ExcelUtil.objTestDataMap.get("Reg_Password"))){
			throw new CustomeExceptionUtil("Password field not found");
		}
		else{Log.info("Password entered successfully"); }
		
		//Enter Confirmation Password
		if (!ActionsUtil.gFunc_SendText(txtPasswordConf,ExcelUtil.objTestDataMap.get("Reg_Conf_Password"))){
			throw new CustomeExceptionUtil("Confirmation Password field not found");
		}
		else{Log.info("confirmation password entered successfully"); }
		
		//CLick on Register Button
		if (!ActionsUtil.gFunc_ClickElement(btnRegister)){
			throw new CustomeExceptionUtil("Register button not found");
		}
		else{Log.info("Register button found and clicked successfully");}
	}
	 
	public void VerifySuccessfulRegistration() throws Exception{
		//Verify Successful Registration Message
				if (!ActionsUtil.bFunc_WaitForObjectExistance(SuccessfulRegistrationMsg)){
					String strErrorMsg = ActionsUtil.gFunc_GetElementText(ErrorMsg);
					Log.info("Error displayed :" + strErrorMsg);
					throw new CustomeExceptionUtil("Registration not Successful: " + strErrorMsg);
				}
				else{Log.info("Registration successfully"); }
	}
	
	
}