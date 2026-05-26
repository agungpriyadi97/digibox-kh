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

// Open browser
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

// Verify homepage
WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.setText(findTestObject('Registration/field-account'), 'agungpriyadi')

WebUI.setText(findTestObject('Registration/field-Password'), 'Laskar123456')

WebUI.click(findTestObject('Login/btn-sign in'))

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.verifyElementVisible(findTestObject('Home Page/verify-succes-acount-login'))

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
WebUI.waitForElementVisible(findTestObject('Checkout/Address/Address Ship To/btn_checkout'), 10)

WebUI.click(findTestObject('Checkout/Address/Address Ship To/btn_checkout'))

WebUI.click(findTestObject('Checkout/Order Summary/Online Payment - Cradit Card'))

WebUI.check(findTestObject('Checkout/Order Summary/Checkbox__I accept'))

WebUI.click(findTestObject('Checkout/Order Summary/button_Checkout_Payment'))

WebUI.waitForElementPresent(findTestObject('Checkout/Page Checkout/iframe_Credit Card'), 10)

// Payment iframe
WebUI.click(findTestObject('Checkout/Page Checkout/iframe_Credit Card'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

WebUI.setText(findTestObject('Checkout/Page Checkout/field_cardNumber'), '5156 8399 3770 6777')

WebUI.setText(findTestObject('Checkout/Page Checkout/field_cardExp'), '0130')

WebUI.setText(findTestObject('Checkout/Page Checkout/field_cvv2'), '993')

WebUI.click(findTestObject('Checkout/Order Summary/btn-closed-pay'))

WebUI.waitForAlert(10)

String alertText = WebUI.getAlertText()

WebUI.comment(alertText)

WebUI.acceptAlert()

WebUI.waitForElementVisible(findTestObject('Checkout/Track Order/track your order'), 0)

WebUI.click(findTestObject('Checkout/Track Order/track your order'))

WebUI.click(findTestObject('Checkout/Track Order/sp-order-list-item'))

WebUI.scrollToElement(findTestObject('Checkout/Track Order/text_order_status'), 7)

WebUI.verifyElementText(findTestObject('Checkout/Track Order/text_order_status'), 'WAIT')

// Screenshot
WebUI.takeScreenshot()

// Close browser
WebUI.closeBrowser()

