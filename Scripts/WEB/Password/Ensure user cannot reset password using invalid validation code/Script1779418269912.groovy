import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.webui.driver.DriverFactory

// ==========================
// OPEN BROWSER
// ==========================

WebUI.openBrowser('')

// stabil untuk headless & non-headless
if (DriverFactory.getExecutedBrowser().getName().contains('HEADLESS')) {
    WebUI.setViewPortSize(1920,1080)
} else {
    WebUI.maximizeWindow()
}

WebUI.enableSmartWait()

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.waitForPageLoad(10)


// ==========================
// VERIFY HOME
// ==========================

WebUI.waitForElementVisible(
	findTestObject('Home Page/header_digibox'),
	15
)

WebUI.verifyElementVisible(
	findTestObject('Home Page/header_digibox')
)


// ==========================
// FORGOT PASSWORD
// ==========================

WebUI.click(
	findTestObject('Registration/icon-acount')
)

WebUI.click(
	findTestObject('Password/Page_Forgot Password/btn_Forgot passwords')
)


// ==========================
// INPUT EMAIL
// ==========================

WebUI.waitForElementVisible(
	findTestObject('Password/Page_Forgot Password/txtField_Email'),
	10
)

WebUI.setText(
	findTestObject('Password/Page_Forgot Password/txtField_Email'),
	'agungpriyadi'
)

WebUI.click(
	findTestObject('Password/Page_Forgot Password/btn_Send validation code to email'),
	FailureHandling.STOP_ON_FAILURE
)


// ==========================
// VERIFY SUCCESS SEND CODE
// ==========================

WebUI.waitForElementVisible(
	findTestObject('Password/Page_Forgot Password/msg_ValidationCodeSuccess'),
	10
)

WebUI.verifyElementText(
	findTestObject('Password/Page_Forgot Password/msg_ValidationCodeSuccess'),
	'Validation code sent successfully!'
)


// ==========================
// INPUT INVALID CODE
// ==========================

WebUI.waitForElementVisible(
	findTestObject('Password/Page_Forgot Password/txtField_Validation Code'),
	10
)

WebUI.setText(
	findTestObject('Password/Page_Forgot Password/txtField_Validation Code'),
	'123456'
)

WebUI.setText(
	findTestObject('Password/Page_Forgot Password/txtField_New Password'),
	'Laskar123456'
)

WebUI.click(
	findTestObject('Password/Page_Forgot Password/btn_Reset Password')
)


// ==========================
// VERIFY INVALID CODE
// ==========================

// kasih delay kecil supaya toast / error muncul
WebUI.delay(3)

// verify text dengan optional biar bisa debug
boolean invalidCode =
	WebUI.verifyTextPresent(
		'Invalid code',
		false,
		FailureHandling.OPTIONAL
	)

if (invalidCode) {

	println('SUCCESS - Invalid code message muncul')

} else {

	println('FAILED - Invalid code message tidak muncul')

	WebUI.takeScreenshot()
}


// ==========================
// SCREENSHOT
// ==========================

WebUI.takeScreenshot()


// ==========================
// CLOSE
// ==========================

WebUI.closeBrowser()