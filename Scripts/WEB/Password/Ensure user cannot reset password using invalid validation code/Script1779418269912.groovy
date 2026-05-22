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

WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.click(findTestObject('Password/Page_Forgot Password/btn_Forgot passwords'))

WebUI.setText(findTestObject('Password/Page_Forgot Password/txtField_Email'), 'agungpriyadi')

WebUI.click(findTestObject('Password/Page_Forgot Password/btn_Send validation code to email'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Password/Page_Forgot Password/msg_ValidationCodeSuccess'), 10)

WebUI.verifyElementText(findTestObject('Password/Page_Forgot Password/msg_ValidationCodeSuccess'), 'Validation code sent successfully!')

WebUI.setText(findTestObject('Password/Page_Forgot Password/txtField_Validation Code'), '123456')

WebUI.setText(findTestObject('Password/Page_Forgot Password/txtField_New Password'), 'Laskar123456')

WebUI.click(findTestObject('Password/Page_Forgot Password/btn_Reset Password'))

WebUI.verifyTextPresent('Invalid code', false)

WebUI.takeScreenshot()

