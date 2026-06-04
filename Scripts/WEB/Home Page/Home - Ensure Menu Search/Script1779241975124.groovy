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

// ========================
// OPEN BROWSER
// ========================
WebUI.openBrowser('')

WebUI.setViewPortSize(1920, 1080)

WebUI.enableSmartWait()

WebUI.navigateToUrl(GlobalVariable.URL)

CustomKeywords.'custom.BrowserHelper.setupBrowserWindow'()

WebUI.waitForPageLoad(30)

// ========================
// VERIFY HOMEPAGE
// ========================
WebUI.waitForElementVisible(findTestObject('WEB/Home Page/header_digibox'), 30)

WebUI.verifyElementVisible(findTestObject('WEB/Home Page/header_digibox'))

// ========================
// OPEN SEARCH
// ========================
WebUI.waitForElementClickable(findTestObject('WEB/Home Page/Search/icon-search'), 30)

WebUI.enhancedClick(findTestObject('WEB/Home Page/Search/icon-search'))

// ========================
// INPUT KEYWORD
// ========================
WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Search/field-search'), 30)

WebUI.setText(findTestObject('WEB/Home Page/Search/field-search'), 'IPHONE 11 PRO 128 GB DEEP PURPLE')

WebUI.sendKeys(findTestObject('WEB/Home Page/Search/field-search'), Keys.chord(Keys.ENTER))

// ========================
// WAIT SEARCH RESULT
// ========================
WebUI.waitForPageLoad(30)

WebUI.delay(3)

// ========================
// VERIFY PRODUCT FOUND
// ========================
WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Search/verify-product-iphone-11-pro'), 30)

WebUI.verifyElementVisible(findTestObject('WEB/Home Page/Search/verify-product-iphone-11-pro'))

// ========================
// CLOSE BROWSER
// ========================
WebUI.closeBrowser()

