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

import custom.RandomData as RandomData

// generate random data
String randomEmail = CustomKeywords.'custom.RandomData.generateRandomEmail'()
String randomUsername = CustomKeywords.'custom.RandomData.generateRandomUsername'()

WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.click(findTestObject('Registration/btn-create-new-account'))

WebUI.setText(findTestObject('Registration/field-Email'), randomEmail)

WebUI.setText(findTestObject('Registration/field-account'), randomUsername)

WebUI.setText(findTestObject('Registration/field-Password'), 'Laskar123456')

WebUI.click(findTestObject('Registration/btn-sign-up'))

WebUI.comment("Email used: " + randomEmail)
WebUI.comment("Username used: " + randomUsername)

WebUI.takeScreenshot()

WebUI.closeBrowser()
