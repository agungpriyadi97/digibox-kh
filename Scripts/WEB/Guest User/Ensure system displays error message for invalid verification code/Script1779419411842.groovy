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

WebUI.navigateToUrl(GlobalVariable.URL)

CustomKeywords.'custom.BrowserHelper.setupBrowserWindow'()

WebUI.waitForPageLoad(30)

// ========================
// VERIFY HOMEPAGE
// ========================
WebUI.waitForElementVisible(findTestObject('Home Page/header_digibox'), 30)

// ========================
// OPEN TRACK ORDER
// ========================
WebUI.waitForElementClickable(findTestObject('Checkout/Track Order/track your order'), 30)

WebUI.enhancedClick(findTestObject('Checkout/Track Order/track your order'))

WebUI.waitForPageLoad(30)

// ========================
// INPUT EMAIL
// ========================
WebUI.waitForElementVisible(findTestObject('Guest User/Track Your Order/txtField_Email'), 30)

WebUI.setText(findTestObject('Guest User/Track Your Order/txtField_Email'), 'agung.priyadi@gtech.digital')

// ========================
// SEND OTP
// ========================
WebUI.waitForElementClickable(findTestObject('Guest User/Track Your Order/btn_Send'), 30)

WebUI.enhancedClick(findTestObject('Guest User/Track Your Order/btn_Send'))

// Tunggu notifikasi sukses
WebUI.delay(3)

WebUI.verifyTextPresent('The verification code has been sent, please check in the mailbox.', false)

// ========================
// INPUT INVALID CODE
// ========================
WebUI.waitForElementVisible(findTestObject('Guest User/Track Your Order/txtField_Verification Code'), 30)

WebUI.clearText(findTestObject('Guest User/Track Your Order/txtField_Verification Code'))

WebUI.setText(findTestObject('Guest User/Track Your Order/txtField_Verification Code'), '999999')

// ========================
// CLICK CONTINUE
// ========================
WebUI.waitForElementClickable(findTestObject('Guest User/Track Your Order/btn_Continue'), 30)

WebUI.enhancedClick(findTestObject('Guest User/Track Your Order/btn_Continue'))

// Tunggu validasi error muncul
WebUI.delay(3)

// ========================
// VERIFY ERROR MESSAGE
// ========================
WebUI.verifyTextPresent('Verification code error.', false)

// ========================
// CLOSE BROWSER
// ========================
WebUI.closeBrowser()

