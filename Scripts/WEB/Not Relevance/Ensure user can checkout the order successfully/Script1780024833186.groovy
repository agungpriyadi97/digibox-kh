import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

// ========================================
// OPEN BROWSER
// ========================================
WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

// ========================================
// VERIFY HOME
// ========================================
WebUI.verifyElementVisible(findTestObject('WEB/Home Page/header_digibox'))

// ========================================
// LOGIN
// ========================================
WebUI.click(findTestObject('WEB/Registration/icon-acount'))

CustomKeywords.'custom.BrowserHelper.closeFirefoxPopup'()

WebUI.setText(findTestObject('WEB/Registration/field-account'), GlobalVariable.username)

WebUI.setEncryptedText(findTestObject('WEB/Registration/field-Password'), GlobalVariable.password)

WebUI.click(findTestObject('WEB/Login/btn-sign in'))

// ========================================
// VERIFY LOGIN
// ========================================
WebUI.click(findTestObject('WEB/Registration/icon-acount'))

WebUI.verifyElementVisible(findTestObject('WEB/Home Page/verify-succes-acount-login'))

// ========================================
// SEARCH PRODUCT
// ========================================
WebUI.click(findTestObject('WEB/Home Page/Search/icon-search'))

WebUI.setText(findTestObject('WEB/Home Page/Search/field-search'), 'iphone 11')

WebUI.sendKeys(findTestObject('WEB/Home Page/Search/field-search'), Keys.chord(Keys.ENTER))

// ========================================
// ADD AVAILABLE PRODUCT
// ========================================
CustomKeywords.'custom.ProductHelper.addAnyAvailableProduct'()

// ========================================
// OPEN CART
// ========================================
WebUI.waitForElementPresent(findTestObject('WEB/Product and Cart/Add to cart/i_icon-cart'), 10)

WebUI.click(findTestObject('WEB/Product and Cart/Add to cart/i_icon-cart'))

// ========================================
// CHECKOUT
// ========================================
WebUI.verifyElementVisible(findTestObject('WEB/Checkout/Address/Address Ship To/btn_checkout'))

WebUI.click(findTestObject('WEB/Checkout/Address/Address Ship To/btn_checkout'))

WebUI.click(findTestObject('WEB/Checkout/Order Summary/Online Payment - WeChat'))

// Accept terms
WebUI.check(findTestObject('WEB/Checkout/Order Summary/Checkbox__I accept'))

WebUI.click(findTestObject('WEB/Checkout/Order Summary/button_Checkout_Payment'))

WebUI.waitForElementPresent(findTestObject('WEB/Checkout/Order Summary/iframe_payment_online'), 7)

// Payment iframe
WebUI.click(findTestObject('WEB/Checkout/Order Summary/iframe_payment_online'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

WebUI.click(findTestObject('WEB/Checkout/Order Summary/button_Approve'))

WebUI.delay(10)

WebUI.waitForElementPresent(findTestObject('WEB/Checkout/Order Summary/button_Continue shopping'), 10)

WebUI.verifyElementPresent(findTestObject('WEB/Checkout/Order Summary/button_Continue shopping'), 0)

WebUI.click(findTestObject('WEB/Checkout/Order Summary/button_Continue shopping'))

// ========================================
// PAYMENT METHOD
// ========================================
//WebUI.click(findTestObject('WEB/Checkout/Order Summary/Online Payment - Cradit Card'))
//
//WebUI.check(findTestObject('WEB/Checkout/Order Summary/Checkbox__I accept'))
//
//WebUI.click(findTestObject('WEB/Checkout/Order Summary/button_Checkout_Payment'))
//
//WebUI.click(findTestObject('WEB/Checkout/Page Checkout/iframe_Credit Card'), FailureHandling.STOP_ON_FAILURE)
//
//WebUI.setText(findTestObject('WEB/Checkout/Page Checkout/field_cardNumber'), '5156 8399 3770 6777')
//
//WebUI.delay(2)
//
//TestObject expiry = findTestObject('WEB/Checkout/Page Checkout/field_cardExp')
//
//WebUI.click(expiry)
//
//WebUI.sendKeys(expiry, '0')
//
//WebUI.sendKeys(expiry, '4')
//
//WebUI.sendKeys(expiry, '3')
//
//WebUI.sendKeys(expiry, '0')
//
//WebUI.delay(2)
//
//WebUI.setText(findTestObject('WEB/Checkout/Page Checkout/field_cvv2'), '993')
//
//WebUI.delay(10)
//
//WebUI.waitForElementClickable(findTestObject('WEB/Checkout/Order Summary/button_Pay (2)'), 20)
//
//WebUI.delay(2)
//
//WebUI.takeScreenshot()
//
//WebUI.click(findTestObject('WEB/Checkout/Order Summary/button_Pay (2)'))
//
//// ========================================
//// VERIFY SUCCESS
//// ========================================
//WebUI.waitForElementPresent(findTestObject('WEB/Checkout/Order Summary/button_Continue shopping'), 15)
//
//WebUI.click(findTestObject('WEB/Checkout/Order Summary/button_Continue shopping'))
// ========================================
// TRACK ORDER
// ========================================
WebUI.waitForElementVisible(findTestObject('WEB/Checkout/Track Order/track your order'), 10)

WebUI.click(findTestObject('WEB/Checkout/Track Order/track your order'))

WebUI.click(findTestObject('WEB/Checkout/button_Order Details'))

WebUI.scrollToElement(findTestObject('WEB/Checkout/Track Order/verify-order list'), 10)

// ========================================
// SCREENSHOT
// ========================================
WebUI.takeScreenshot()

// ========================================
// CLOSE
// ========================================
WebUI.closeBrowser()

