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

WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.setText(findTestObject('Registration/field-account'), 'agungpriyadi')

WebUI.setText(findTestObject('Registration/field-Password'), 'Laskar123456')

WebUI.click(findTestObject('Login/btn-sign in'))

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.verifyElementVisible(findTestObject('Home Page/verify-succes-acount-login'))

WebUI.click(findTestObject('Home Page/Search/icon-search'))

WebUI.click(findTestObject('Home Page/Search/field-search'))

WebUI.sendKeys(findTestObject('Home Page/Search/field-search'), Keys.chord('IPHONE 11 PRO 128 GB DEEP PURPLE', Keys.ENTER))

WebUI.verifyElementVisible(findTestObject('Home Page/Search/verify-product-iphone-11-pro'))

WebUI.click(findTestObject('Product and Cart/Add to cart/btn-product'))

WebUI.click(findTestObject('Product and Cart/Add to cart/button_Add to Cart'))

WebUI.click(findTestObject('Product and Cart/Add to cart/i_icon-cart'))

WebUI.verifyElementVisible(findTestObject('Checkout/button_Checkout'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Checkout/button_Checkout'))

WebUI.click(findTestObject('Checkout/Online Payment - WeChat'))

WebUI.check(findTestObject('Checkout/Checkbox__I accept'))

WebUI.click(findTestObject('Checkout/button_Checkout_Payment'))

WebUI.click(findTestObject('Checkout/iframe_payment_online'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Checkout/button_Approve'))

// Balik ke default content (keluar dari iframe)
WebUI.switchToDefaultContent()

WebUI.waitForElementPresent(findTestObject('Checkout/button_Continue shopping'), 10)

WebUI.verifyElementPresent(findTestObject('Checkout/button_Continue shopping'), 0)

WebUI.click(findTestObject('Checkout/button_Continue shopping'))

WebUI.waitForElementVisible(findTestObject('Registration/icon-acount'), 0)

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.waitForElementVisible(findTestObject('Checkout/div_My Orders'), 0)

WebUI.click(findTestObject('Checkout/div_My Orders'))

WebUI.click(findTestObject('Checkout/button_Order Details'))

WebUI.takeScreenshot()

