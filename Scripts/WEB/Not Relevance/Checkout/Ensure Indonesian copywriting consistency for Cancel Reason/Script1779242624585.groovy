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

WebUI.openBrowser(GlobalVariable.URL)

CustomKeywords.'custom.BrowserHelper.setupBrowserWindow'()

WebUI.verifyElementVisible(findTestObject('WEB/Home Page/header_digibox'))

WebUI.click(findTestObject('WEB/Registration/icon-acount'))

CustomKeywords.'custom.BrowserHelper.closeFirefoxPopup'()

WebUI.setText(findTestObject('WEB/Registration/field-account'), 'agungpriyadi')

WebUI.setText(findTestObject('WEB/Registration/field-Password'), 'Laskar123456')

WebUI.click(findTestObject('WEB/Login/btn-sign in'))

WebUI.click(findTestObject('WEB/Registration/icon-acount'))

WebUI.verifyElementVisible(findTestObject('WEB/Home Page/verify-succes-acount-login'))

WebUI.click(findTestObject('WEB/Home Page/Search/icon-search'))

WebUI.setText(findTestObject('WEB/Home Page/Search/field-search'), 'Iphone 11')

WebUI.sendKeys(findTestObject('WEB/Home Page/Search/field-search'), Keys.chord(Keys.ENTER))

// ========================================
// ADD AVAILABLE PRODUCT
// ========================================
CustomKeywords.'custom.ProductHelper.addAnyAvailableProduct'()

WebUI.waitForElementPresent(findTestObject('WEB/Product and Cart/Add to cart/i_icon-cart'), 7)

WebUI.click(findTestObject('WEB/Product and Cart/Add to cart/i_icon-cart'))

WebUI.verifyElementVisible(findTestObject('WEB/Checkout/Address/Address Ship To/btn_checkout'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Checkout/Address/Address Ship To/btn_checkout'))

WebUI.click(findTestObject('WEB/Checkout/Order Summary/Online Payment - Cradit Card'))

WebUI.check(findTestObject('WEB/Checkout/Order Summary/Checkbox__I accept'))

WebUI.click(findTestObject('WEB/Checkout/Order Summary/button_Checkout_Payment'))

WebUI.waitForElementPresent(findTestObject('WEB/Checkout/Page Checkout/iframe_Credit Card'), 10)

WebUI.click(findTestObject('WEB/Checkout/Page Checkout/iframe_Credit Card'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

WebUI.setText(findTestObject('WEB/Checkout/Page Checkout/field_cardNumber'), '5156 8399 3770 6777')

WebUI.setText(findTestObject('WEB/Checkout/Page Checkout/field_cardExp'), '01/30')

WebUI.setText(findTestObject('WEB/Checkout/Page Checkout/field_cvv2'), '993')

WebUI.click(findTestObject('WEB/Checkout/Order Summary/btn-closed-pay'))

WebUI.waitForAlert(10)

String alertText = WebUI.getAlertText()

WebUI.comment(alertText)

WebUI.acceptAlert()

WebUI.waitForElementVisible(findTestObject('WEB/Checkout/Track Order/track your order'), 7)

WebUI.click(findTestObject('WEB/Checkout/Track Order/track your order'))

WebUI.click(findTestObject('WEB/Checkout/Track Order/sp-order-list-item'))

WebUI.scrollToElement(findTestObject('WEB/Checkout/Track Order/btn-cencel'), 10)

WebUI.click(findTestObject('WEB/Checkout/Track Order/btn-cencel'))

WebUI.waitForElementVisible(findTestObject('WEB/Checkout/Track Order/button_OK'), 7)

WebUI.click(findTestObject('WEB/Checkout/Track Order/button_OK'))

WebUI.waitForElementVisible(findTestObject('WEB/Checkout/Track Order/Message_Success'), 10)

WebUI.verifyElementVisible(findTestObject('WEB/Checkout/Track Order/Message_Success'))

WebUI.scrollToElement(findTestObject('WEB/Checkout/Track Order/text_order_status'), 5)

WebUI.verifyElementText(findTestObject('WEB/Checkout/Track Order/text_order_status'), 'CANCEL')

WebUI.takeScreenshot()

WebUI.closeBrowser()

