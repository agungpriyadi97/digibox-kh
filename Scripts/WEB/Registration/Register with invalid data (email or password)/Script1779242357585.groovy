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

// ==========================
// OPEN BROWSER
// ==========================
WebUI.openBrowser('')

CustomKeywords.'custom.BrowserHelper.setupBrowserWindow'()

WebUI.navigateToUrl(GlobalVariable.URL)

// ==========================
// VERIFY HOME PAGE
// ==========================
WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

// ==========================
// OPEN REGISTER
// ==========================
WebUI.click(findTestObject('Registration/icon-acount'))
CustomKeywords.'custom.BrowserHelper.closeFirefoxPopup'()

WebUI.click(findTestObject('Registration/btn-create-new-account'))

// ==========================
// SCENARIO 1: INVALID EMAIL + EMPTY FIELDS
// ==========================
WebUI.setText(findTestObject('Registration/field-Email'), 'salahemailgmail.com')
WebUI.setText(findTestObject('Registration/field-account'), '')
WebUI.setText(findTestObject('Registration/field-Password'), '')

WebUI.click(findTestObject('Registration/btn-sign-up'))

WebUI.delay(2)

// VALIDATE EMAIL ERROR
boolean emailError = WebUI.verifyTextPresent(
    'Please enter a valid email address',
    false,
    FailureHandling.OPTIONAL
)

// VALIDATE REQUIRED ERROR
boolean requiredError = WebUI.verifyTextPresent(
    'Required',
    false,
    FailureHandling.OPTIONAL
)

if (!emailError || !requiredError) {
    WebUI.takeScreenshot()
    WebUI.verifyFail("Validation error (email/required) not displayed properly")
}

WebUI.takeScreenshot()

// ==========================
// SCENARIO 2: PASSWORD LENGTH VALIDATION
// ==========================
WebUI.setText(findTestObject('Registration/field-Email'), 'agung.priyadi@gtech.digital')
WebUI.setText(findTestObject('Registration/field-account'), 'agungpriyadi')
WebUI.setText(findTestObject('Registration/field-Password'), 'Las')

WebUI.click(findTestObject('Registration/btn-sign-up'))

WebUI.delay(2)

boolean passwordLengthError = WebUI.verifyTextPresent(
    'Password length is 6-20 digits',
    false,
    FailureHandling.OPTIONAL
)

if (!passwordLengthError) {
    WebUI.takeScreenshot()
    WebUI.verifyFail("Password length validation not shown")
}

WebUI.takeScreenshot()

// ==========================
// CLOSE
// ==========================
WebUI.closeBrowser()
