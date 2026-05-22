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

String randomEmail = CustomKeywords.'custom.RandomData.generateRandomEmail'()

String randomFirstName = CustomKeywords.'custom.RandomData.generateRandomFirstName'()

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

// Click Edit first address
TestObject editBtn = new TestObject()

editBtn.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '(//button[contains(.,\'Edit\')])[1]')

WebUI.click(findTestObject('Address Management/Shipping Address/btn_Edit'))

WebUI.waitForElementVisible(findTestObject('Address Management/Edit Address/Field_First Name'), 10)

WebUI.clearText(findTestObject('Address Management/Edit Address/Field_First Name'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Address Management/Edit Address/Field_First Name'), randomFirstName)

WebUI.clearText(findTestObject('Address Management/Edit Address/Field_Last Name'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Address Management/Edit Address/Field_Last Name'), randomLastName)

WebUI.clearText(findTestObject('Address Management/Edit Address/Field_Mobile Phone'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Address Management/Edit Address/Field_Mobile Phone'), randomPhone)

WebUI.clearText(findTestObject('Address Management/Edit Address/Field_E-mail'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Address Management/Edit Address/Field_E-mail'), randomEmail)

WebUI.clearText(findTestObject('Address Management/Edit Address/Field_Address'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Address Management/Edit Address/Field_Address'), randomAddress)

not_run: WebUI.click(findTestObject('Address Management/Add New Address/field_Province'))

not_run: WebUI.mouseOver(findTestObject('Address Management/Add New Address/Dropdown Province/li_Banteay Meanchey Province'))

not_run: WebUI.click(findTestObject('Address Management/Add New Address/Dropdown Province/li_Banteay Meanchey Province'))

not_run: WebUI.click(findTestObject('Address Management/Add New Address/field_Select Province'))

not_run: WebUI.mouseOver(findTestObject('Address Management/Add New Address/Dropdown Select Province/li_Mongkol Borei'))

not_run: WebUI.click(findTestObject('Address Management/Add New Address/Dropdown Select Province/li_Mongkol Borei'))

not_run: WebUI.click(findTestObject('Address Management/Add New Address/field_Districts'))

not_run: WebUI.mouseOver(findTestObject('Address Management/Add New Address/Dropdown District/li_Kouk Ballangk Commune'), 
    FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.click(findTestObject('Address Management/Add New Address/Dropdown District/li_Kouk Ballangk Commune'), FailureHandling.STOP_ON_FAILURE)

WebUI.clearText(findTestObject('Address Management/Edit Address/Field_ZipPostal Code'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Address Management/Edit Address/Field_ZipPostal Code'), randomCode)

WebUI.click(findTestObject('Address Management/Edit Address/button_Save'))

WebUI.scrollToElement(findTestObject('Address Management/Shipping Address/lbl_Shipping Address'), 10)

// verify updated
TestObject verifyName = new TestObject()

verifyName.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, "//*[contains(text(),'$randomFirstName')]")

WebUI.verifyElementPresent(verifyName, 10)

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

// Close browser
not_run: WebUI.closeBrowser()

