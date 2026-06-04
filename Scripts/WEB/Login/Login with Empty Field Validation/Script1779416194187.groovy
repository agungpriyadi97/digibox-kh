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

// ====================================
// OPEN BROWSER
// ====================================
WebUI.openBrowser('')

CustomKeywords.'custom.BrowserHelper.setupBrowserWindow'()

WebUI.setViewPortSize(1920, 1080)

WebUI.navigateToUrl(GlobalVariable.URL)

// ====================================
// VERIFY HOMEPAGE
// ====================================
WebUI.waitForElementVisible(findTestObject('WEB/Home Page/header_digibox'), 15)

WebUI.verifyElementVisible(findTestObject('WEB/Home Page/header_digibox'))

// ====================================
// OPEN LOGIN PAGE
// ====================================
WebUI.click(findTestObject('WEB/Registration/icon-acount'))

// ====================================
// EMPTY USERNAME & PASSWORD
// ====================================
WebUI.setText(findTestObject('WEB/Registration/field-account'), '')

WebUI.setText(findTestObject('WEB/Registration/field-Password'), '')

// ====================================
// CLICK SIGN IN
// ====================================
WebUI.click(findTestObject('WEB/Login/btn-sign in'))

// ====================================
// WAIT RESPONSE
// ====================================
WebUI.delay(2)

// ====================================
// VERIFY STILL ON LOGIN PAGE
// ====================================
WebUI.verifyElementVisible(findTestObject('WEB/Login/btn-sign in'), FailureHandling.STOP_ON_FAILURE)

// ====================================
// LOG
// ====================================
WebUI.comment('Login validation with empty username and password executed')

// ====================================
// CLOSE BROWSER
// ====================================
WebUI.closeBrowser()

