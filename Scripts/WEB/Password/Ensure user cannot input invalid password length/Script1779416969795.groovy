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

// =========================
// OPEN BROWSER
// =========================
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.URL)

// penting untuk CI
WebUI.waitForPageLoad(20)

// =========================
// VERIFY HOME PAGE
// =========================
WebUI.waitForElementVisible(findTestObject('Home Page/header_digibox'), 15)

WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

// =========================
// NAVIGATE TO FORGOT PASSWORD
// =========================
WebUI.waitForElementClickable(findTestObject('Registration/icon-acount'), 10)

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.waitForElementClickable(findTestObject('Password/Page_Forgot Password/btn_Forgot passwords'), 10)

WebUI.click(findTestObject('Password/Page_Forgot Password/btn_Forgot passwords'))

// =========================
// INPUT EMAIL
// =========================
def email = 'agung.priyadi@gtech.digital'

WebUI.waitForElementVisible(findTestObject('Password/Page_Forgot Password/txtField_Email'), 10)

WebUI.setText(findTestObject('Password/Page_Forgot Password/txtField_Email'), email)

// =========================
// SEND VALIDATION CODE
// =========================
WebUI.waitForElementClickable(findTestObject('Password/Page_Forgot Password/btn_Send validation code to email'), 10)

WebUI.click(findTestObject('Password/Page_Forgot Password/btn_Send validation code to email'))

// =========================
// VALIDATION MESSAGE (CI SAFE)
// =========================
WebUI.delay(2)

boolean successMsgShown = WebUI.verifyTextPresent('Validation code sent successfully!', false, FailureHandling.OPTIONAL)

if (!(successMsgShown)) {
    WebUI.takeScreenshot()

    WebUI.comment('Validation success message NOT found')

    WebUI.verifyFail('Send validation code failed or message not shown')
}

// =========================
// INPUT VALIDATION CODE
// =========================
WebUI.waitForElementVisible(findTestObject('Password/Page_Forgot Password/txtField_Validation Code'), 10)

WebUI.setText(findTestObject('Password/Page_Forgot Password/txtField_Validation Code'), '123456')

// =========================
// INPUT INVALID PASSWORD
// =========================
WebUI.waitForElementVisible(findTestObject('Password/Page_Forgot Password/txtField_New Password'), 10)

WebUI.setText(findTestObject('Password/Page_Forgot Password/txtField_New Password'), '123')

// =========================
// CLICK RESET PASSWORD
// =========================
WebUI.waitForElementClickable(findTestObject('Password/Page_Forgot Password/btn_Reset Password'), 10)

WebUI.click(findTestObject('Password/Page_Forgot Password/btn_Reset Password'))

// =========================
// ERROR VALIDATION (CI SAFE - FIXED)
// =========================
WebUI.delay(2)

boolean errorShown = WebUI.verifyTextPresent('Password length is 6-20 digits', false, FailureHandling.OPTIONAL)

WebUI.verifyEqual(errorShown, true)

// =========================
// CLEANUP
// =========================
WebUI.closeBrowser()

