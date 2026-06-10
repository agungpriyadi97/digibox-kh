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

WebUI.verifyElementVisible(findTestObject('WEB/Home Page/header_digibox'))

WebUI.click(findTestObject('WEB/Registration/icon-acount'))

WebUI.setText(findTestObject('WEB/Registration/field-account'), 'agungpriyadi')

WebUI.setText(findTestObject('WEB/Registration/field-Password'), 'Laskar123456')

WebUI.click(findTestObject('WEB/Login/btn-sign in'))

WebUI.click(findTestObject('WEB/Registration/icon-acount'))

WebUI.verifyElementVisible(findTestObject('WEB/Home Page/verify-succes-acount-login'))

WebUI.click(findTestObject('WEB/Home Page/Search/icon-search'))

WebUI.setText(findTestObject('WEB/Home Page/Search/field-search'), 'IPHONE 13 PRO MAX SIERRA BLUE 128GB')

WebUI.sendKeys(findTestObject('WEB/Home Page/Search/field-search'), Keys.chord(Keys.ENTER))

WebUI.waitForPageLoad(30)

WebUI.delay(3)

WebUI.click(findTestObject('WEB/Product and Cart/Add to cart/btn_product_PHONE 13 PRO MAX SIERRA BLUE'))

WebUI.click(findTestObject('WEB/Product and Cart/Add to cart/button_Add to Cart'))

WebUI.click(findTestObject('WEB/Product and Cart/Add to cart/i_icon-cart'))

WebUI.click(findTestObject('WEB/Product and Cart/Add to cart/btn-trash'))

WebUI.click(findTestObject('WEB/Product and Cart/Add to cart/btn-confrim-yes'))

WebUI.closeBrowser()

