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

CustomKeywords.'custom.BrowserHelper.setupBrowserWindow'()

WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

WebUI.click(findTestObject('Registration/icon-acount'))

CustomKeywords.'custom.BrowserHelper.closeFirefoxPopup'()

WebUI.click(findTestObject('Registration/btn-create-new-account'))

WebUI.setText(findTestObject('Registration/field-Email'), 'salahemailgmail.com')

WebUI.setText(findTestObject('Registration/field-account'), '')

WebUI.setText(findTestObject('Registration/field-Password'), '')

WebUI.click(findTestObject('Registration/btn-sign-up'))

WebUI.verifyElementText(findTestObject('Registration/verify-Email'), 'Please enter a valid email address')

WebUI.verifyElementText(findTestObject('Registration/verify-required'), 'Required')

WebUI.takeScreenshot()

WebUI.setText(findTestObject('Registration/field-Email'), 'agung.priyadi@gtech.digital')

WebUI.setText(findTestObject('Registration/field-account'), 'agungpriyadi')

WebUI.setText(findTestObject('Registration/field-Password'), 'Las')

WebUI.click(findTestObject('Registration/btn-sign-up'))

WebUI.verifyElementText(findTestObject('Registration/verify-length'), 'Password length is 6-20 digits')

WebUI.takeScreenshot()

WebUI.closeBrowser()

