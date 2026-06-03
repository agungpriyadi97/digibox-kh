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

// ==========================
// OPEN BROWSER
// ==========================
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.waitForPageLoad(20)

// ==========================
// VERIFY HOME
// ==========================
WebUI.waitForElementVisible(findTestObject('Home Page/header_digibox'), 15)

WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

// ==========================
// NAVIGATION
// ==========================
WebUI.waitForElementClickable(findTestObject('Registration/icon-acount'), 10)

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.waitForElementClickable(findTestObject('Password/Page_Forgot Password/btn_Forgot passwords'), 10)

WebUI.click(findTestObject('Password/Page_Forgot Password/btn_Forgot passwords'))

// ==========================
// INPUT EMAIL (CI SAFE)
// ==========================
WebUI.waitForElementVisible(findTestObject('Password/Page_Forgot Password/txtField_Email'), 10)

// dibuat valid biar tidak gagal backend di CI
WebUI.setText(findTestObject('Password/Page_Forgot Password/txtField_Email'), '')

// ==========================
// EMPTY PASSWORD CASE
// ==========================
// langsung kosong (sudah default)
WebUI.waitForElementVisible(findTestObject('Password/Page_Forgot Password/txtField_New Password'), 10)

WebUI.setText(findTestObject('Password/Page_Forgot Password/txtField_New Password'), '')

WebUI.waitForElementClickable(findTestObject('Password/Page_Forgot Password/btn_Reset Password'), 10)

WebUI.click(findTestObject('Password/Page_Forgot Password/btn_Reset Password'))

// ==========================
// VALIDATION CHECK (CI SAFE)
// ==========================
WebUI.delay(2)

boolean requiredMsg = WebUI.verifyTextPresent('Required', false, FailureHandling.OPTIONAL)

WebUI.verifyEqual(requiredMsg, true)

// ==========================
// CLOSE
// ==========================
WebUI.closeBrowser()

