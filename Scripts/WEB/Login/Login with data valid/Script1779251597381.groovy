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
WebUI.waitForElementVisible(findTestObject('Home Page/header_digibox'), 30)

WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

// ========================
// OPEN LOGIN POPUP
// ========================
WebUI.waitForElementClickable(findTestObject('Registration/icon-acount'), 30)

WebUI.enhancedClick(findTestObject('Registration/icon-acount'))

// ========================
// INPUT VALID ACCOUNT
// ========================
WebUI.waitForElementVisible(findTestObject('Registration/field-account'), 30)

WebUI.setText(findTestObject('Registration/field-account'), 'agungpriyadi')

WebUI.setText(findTestObject('Registration/field-Password'), 'Laskar123456')

// ========================
// CLICK SIGN IN
// ========================
WebUI.waitForElementClickable(findTestObject('Login/btn-sign in'), 30)

WebUI.enhancedClick(findTestObject('Login/btn-sign in'))

// ========================
// WAIT LOGIN PROCESS
// ========================
WebUI.waitForPageLoad(30)

WebUI.delay(5)

// ========================
// OPEN ACCOUNT MENU
// ========================
WebUI.waitForElementClickable(findTestObject('Registration/icon-acount'), 30)

WebUI.enhancedClick(findTestObject('Registration/icon-acount'))

// ========================
// VERIFY LOGIN SUCCESS
// ========================
WebUI.waitForElementVisible(findTestObject('Home Page/verify-succes-acount-login'), 30)

WebUI.verifyElementVisible(findTestObject('Home Page/verify-succes-acount-login'))

WebUI.comment('Login success verified')

// ========================
// CLOSE BROWSER
// ========================
WebUI.closeBrowser()

