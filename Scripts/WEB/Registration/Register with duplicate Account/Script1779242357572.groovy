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

// setup window FIRST (biar tidak ganggu load state)
CustomKeywords.'custom.BrowserHelper.setupBrowserWindow'()

WebUI.navigateToUrl(GlobalVariable.URL)

// ==========================
// VERIFY HOME PAGE
// ==========================
WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

// ==========================
// OPEN ACCOUNT MENU
// ==========================
WebUI.click(findTestObject('Registration/icon-acount'))

// handle popup kalau muncul (safe call)
CustomKeywords.'custom.BrowserHelper.closeFirefoxPopup'()

// ==========================
// GO TO REGISTER PAGE
// ==========================
WebUI.click(findTestObject('Registration/btn-create-new-account'))

// ==========================
// INPUT DATA
// ==========================
WebUI.setText(findTestObject('Registration/field-Email'), 'agungpriyadi@gmail.com')
WebUI.setText(findTestObject('Registration/field-account'), 'agungpriyadi')
WebUI.setText(findTestObject('Registration/field-Password'), 'Laskar123456')

// ==========================
// SUBMIT REGISTER
// ==========================
WebUI.click(findTestObject('Registration/btn-sign-up'))

// stabilizer ringan (cukup untuk CI kamu yang sebelumnya sukses)
WebUI.delay(2)

// ==========================
// VERIFY DUPLICATE ERROR
// ==========================
boolean isDuplicateShown = WebUI.verifyTextPresent(
    'Duplicated-unknown-error.',
    false,
    FailureHandling.OPTIONAL
)

if (!isDuplicateShown) {
    WebUI.takeScreenshot()
    WebUI.verifyFail("Duplicate account message NOT shown")
}

// ==========================
// EVIDENCE
// ==========================
WebUI.takeScreenshot()

// ==========================
// CLOSE
// ==========================
WebUI.closeBrowser()