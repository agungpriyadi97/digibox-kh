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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

String randomFirstName = CustomKeywords.'custom.RandomData.generateRandomFirstName'()

String randomEmail = CustomKeywords.'custom.RandomData.generateRandomEmail'()

String randomLastName = CustomKeywords.'custom.RandomData.generateRandomLastName'()

String randomPhone = CustomKeywords.'custom.RandomData.generateRandomPhone'()

String randomAddress = CustomKeywords.'custom.RandomData.generateRandomAddress'()

String randomCode = CustomKeywords.'custom.RandomData.generateRandomCode'()

// Open browser
WebUI.openBrowser(GlobalVariable.URL)

CustomKeywords.'custom.BrowserHelper.setupBrowserWindow'()

// Verify homepage
WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.setText(findTestObject('Registration/field-account'), 'agungpriyadi')

WebUI.setText(findTestObject('Registration/field-Password'), 'Laskar123456')

WebUI.click(findTestObject('Login/btn-sign in'))

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.click(findTestObject('Address Management/Shipping Address/btn_My Address'))

WebUI.click(findTestObject('Address Management/Add New Address/div_Add New Address'))

WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/field_First Name'), 0)

WebUI.setText(findTestObject('Address Management/Add New Address/field_First Name'), randomFirstName)

WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/field_Last Name'), 0)

WebUI.setText(findTestObject('Address Management/Add New Address/field_Last Name'), randomLastName)

WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/field_Mobile Phone'), 0)

WebUI.setText(findTestObject('Address Management/Add New Address/field_Mobile Phone'), randomPhone)

WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/field_E-mail'), 0)

WebUI.setText(findTestObject('Address Management/Add New Address/field_E-mail'), randomEmail)

WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/field_Address'), 0)

WebUI.setText(findTestObject('Address Management/Add New Address/field_Address'), randomAddress)

WebUI.click(findTestObject('Address Management/Add New Address/dropdown_Province'))

WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/Dropdown Province/li_Banteay Meanchey Province'), 
    0)

WebUI.click(findTestObject('Address Management/Add New Address/Dropdown Province/li_Banteay Meanchey Province'))

WebUI.click(findTestObject('Address Management/Add New Address/dropdown_Select Province'))

WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/Dropdown Select Province/li_Paoy Paet Municipality'), 
    0)

WebUI.click(findTestObject('Address Management/Add New Address/Dropdown Select Province/li_Paoy Paet Municipality'), FailureHandling.STOP_ON_FAILURE)

// ================= DISTRICT =================
WebUI.click(findTestObject('Address Management/Add New Address/dropdown_Districts'))

WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/Dropdown District/li_Sangkat Kandal'), 10)

WebUI.click(findTestObject('Address Management/Add New Address/Dropdown District/li_Sangkat Kandal'))

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

