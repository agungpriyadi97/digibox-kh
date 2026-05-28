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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Generate random data
String randomEmail = CustomKeywords.'custom.RandomData.generateRandomEmail'()

String randomFirstName = CustomKeywords.'custom.RandomData.generateRandomFirstName'()

String randomLastName = CustomKeywords.'custom.RandomData.generateRandomLastName'()

String randomPhone = CustomKeywords.'custom.RandomData.generateRandomPhone'()

String randomAddress = CustomKeywords.'custom.RandomData.generateRandomAddress'()

String randomCode = CustomKeywords.'custom.RandomData.generateRandomCode'()

// Open browser
WebUI.openBrowser('')

CustomKeywords.'custom.BrowserHelper.setupBrowserWindow'()

WebUI.delay(2)

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

// Verify homepage
WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

// Search product
WebUI.click(findTestObject('Home Page/Search/icon-search'))

WebUI.sendKeys(findTestObject('Home Page/Search/field-search'), Keys.chord('IPHONE 12 PRO MAX 128GB GOLD', Keys.ENTER))

WebUI.verifyElementVisible(findTestObject('Home Page/Search/verify-product-iphone-12 -pro'))

WebUI.click(findTestObject('Product and Cart/Add to cart/btn-product - IPHONE 12 PRO MAX 128GB GOLD'))

WebUI.click(findTestObject('Product and Cart/Add to cart/button_Add to Cart'))

WebUI.waitForElementPresent(findTestObject('Product and Cart/Add to cart/i_icon-cart'), 10)

// Open cart
WebUI.click(findTestObject('Product and Cart/Add to cart/i_icon-cart'))

// Checkout
WebUI.verifyElementVisible(findTestObject('Checkout/Address/Address Ship To/btn_checkout'))

WebUI.click(findTestObject('Checkout/Address/Address Ship To/btn_checkout'))

// Input guest email
WebUI.waitForElementVisible(findTestObject('Checkout/Checkout guest/field_email'), 10)

WebUI.setText(findTestObject('Checkout/Checkout guest/field_email'), randomEmail)

// Continue
WebUI.click(findTestObject('Checkout/Checkout guest/btn_continue'))

// Fill address form with random data
WebUI.waitForElementVisible(findTestObject('Checkout/Address/Address Ship To/field_First Name'), 10)

WebUI.setText(findTestObject('Checkout/Address/Address Ship To/field_First Name'), randomFirstName)

WebUI.setText(findTestObject('Checkout/Address/Address Ship To/field_Last Name'), randomLastName)

WebUI.setText(findTestObject('Checkout/Address/Address Ship To/field_mobile phone'), randomPhone)

WebUI.setText(findTestObject('Checkout/Address/Address Ship To/field_Address'), randomAddress)

WebUI.setText(findTestObject('Checkout/Address/Address Ship To/input_ZipPostal Code'), randomCode)

WebUI.click(findTestObject('Checkout/Address/Address Ship To/input_Province'))

WebUI.click(findTestObject('Checkout/Address/Address Ship To/li_Phnom Penh Capital_Province'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Checkout/Address/Address Ship To/input_Select Province'))

WebUI.click(findTestObject('Checkout/Address/Address Ship To/li_Khan Chamkar Mon_Select_Province'))

WebUI.click(findTestObject('Checkout/Address/Address Ship To/input_Districts'))

WebUI.click(findTestObject('Checkout/Address/Address Ship To/li_Sangkat Tonle Basak_Districts'))

WebUI.click(findTestObject('Checkout/Address/Address Ship To/btn-save'))

// Select payment
WebUI.click(findTestObject('Checkout/Order Summary/Online Payment - WeChat'))

// Accept terms
WebUI.check(findTestObject('Checkout/Order Summary/Checkbox__I accept'))

WebUI.click(findTestObject('Checkout/Order Summary/button_Checkout_Payment'))

WebUI.waitForElementPresent(findTestObject('Checkout/Order Summary/iframe_payment_online'), 7)

// Payment iframe
WebUI.click(findTestObject('Checkout/Order Summary/iframe_payment_online'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

WebUI.click(findTestObject('Checkout/Order Summary/button_Approve'))

WebUI.waitForElementPresent(findTestObject('Checkout/Order Summary/button_Continue shopping'), 10)

WebUI.verifyElementPresent(findTestObject('Checkout/Order Summary/button_Continue shopping'), 0)

WebUI.click(findTestObject('Checkout/Order Summary/button_Continue shopping'))

// Logs for report
WebUI.comment('Email      : ' + randomEmail)

WebUI.comment('First Name : ' + randomFirstName)

WebUI.comment('Last Name  : ' + randomLastName)

WebUI.comment('Phone      : ' + randomPhone)

WebUI.comment('Address    : ' + randomAddress)

WebUI.comment('Code    : ' + randomCode)

// Screenshot
WebUI.takeScreenshot()

// Close browser
WebUI.closeBrowser()

