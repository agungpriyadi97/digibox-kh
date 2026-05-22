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

String randomFirstName = CustomKeywords.'custom.RandomData.generateRandomFirstName'()

String randomEmail = CustomKeywords.'custom.RandomData.generateRandomEmail'()

String randomLastName = CustomKeywords.'custom.RandomData.generateRandomLastName'()

String randomPhone = CustomKeywords.'custom.RandomData.generateRandomPhone'()

String randomAddress = CustomKeywords.'custom.RandomData.generateRandomAddress'()

String randomCode = CustomKeywords.'custom.RandomData.generateRandomCode'()

// Open browser
WebUI.openBrowser(GlobalVariable.URL)

// Verify homepage
WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.setText(findTestObject('Registration/field-account'), 'agungpriyadi')

WebUI.setText(findTestObject('Registration/field-Password'), 'Laskar123456')

WebUI.click(findTestObject('Login/btn-sign in'))

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.waitForElementVisible(findTestObject('Address Management/Shipping Address/btn_My Address'), 4)

WebUI.click(findTestObject('Address Management/Shipping Address/btn_My Address'))

WebUI.click(findTestObject('Address Management/Add New Address/radiobtn_Add New Address'))

WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/field_First Name'), 10)

WebUI.setText(findTestObject('Address Management/Add New Address/field_First Name'), randomFirstName)

WebUI.setText(findTestObject('Address Management/Add New Address/field_Last Name'), randomLastName)

WebUI.setText(findTestObject('Address Management/Add New Address/field_Mobile Phone'), randomPhone)

WebUI.setText(findTestObject('Address Management/Add New Address/field_E-mail'), randomEmail)

WebUI.setText(findTestObject('Address Management/Add New Address/field_Address'), randomAddress)

WebUI.click(findTestObject('Address Management/Add New Address/field_Province'))

WebUI.mouseOver(findTestObject('Address Management/Add New Address/Dropdown Province/li_Banteay Meanchey Province'))

WebUI.click(findTestObject('Address Management/Add New Address/Dropdown Province/li_Banteay Meanchey Province'))

WebUI.click(findTestObject('Address Management/Add New Address/field_Select Province'))

WebUI.mouseOver(findTestObject('Address Management/Add New Address/Dropdown Select Province/li_Ou Chrov District'))

WebUI.click(findTestObject('Address Management/Add New Address/Dropdown Select Province/li_Ou Chrov District'))

WebUI.click(findTestObject('Address Management/Add New Address/field_Districts'))

WebUI.mouseOver(findTestObject('Address Management/Add New Address/Dropdown District/li_Koub Commune'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Address Management/Add New Address/Dropdown District/li_Koub Commune'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Address Management/Add New Address/field_ZipPostal Code'), randomCode)

WebUI.click(findTestObject('Address Management/Add New Address/button_Save'))

WebUI.scrollToElement(findTestObject('Address Management/Shipping Address/lbl_Shipping Address'), 3)

// Screenshot
WebUI.takeScreenshot()

WebUI.comment('Email      : ' + randomEmail)

WebUI.comment('First Name : ' + randomFirstName)

WebUI.comment('Last Name  : ' + randomLastName)

WebUI.comment('Phone      : ' + randomPhone)

WebUI.comment('Address    : ' + randomAddress)

WebUI.comment('Code    : ' + randomCode)

// Close browser
WebUI.closeBrowser()

