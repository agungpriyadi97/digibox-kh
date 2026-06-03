import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

String randomEmail = CustomKeywords.'custom.RandomData.generateRandomEmail'()

String randomFirstName = CustomKeywords.'custom.RandomData.generateRandomFirstName'()

String randomLastName = CustomKeywords.'custom.RandomData.generateRandomLastName'()

String randomPhone = CustomKeywords.'custom.RandomData.generateRandomPhone'()

String randomAddress = CustomKeywords.'custom.RandomData.generateRandomAddress'()

String randomCode = CustomKeywords.'custom.RandomData.generateRandomCode'()

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
// LOGIN
// ========================
WebUI.waitForElementClickable(findTestObject('Registration/icon-acount'), 30)

WebUI.enhancedClick(findTestObject('Registration/icon-acount'))

WebUI.waitForElementVisible(findTestObject('Registration/field-account'), 30)

WebUI.setText(findTestObject('Registration/field-account'), 'agungpriyadi')

WebUI.setText(findTestObject('Registration/field-Password'), 'Laskar123456')

WebUI.waitForElementClickable(findTestObject('Login/btn-sign in'), 30)

WebUI.enhancedClick(findTestObject('Login/btn-sign in'))

WebUI.waitForPageLoad(30)

// ========================
// OPEN MY ADDRESS
// ========================
WebUI.waitForElementClickable(findTestObject('Registration/icon-acount'), 30)

WebUI.enhancedClick(findTestObject('Registration/icon-acount'))

WebUI.waitForElementClickable(findTestObject('Address Management/Shipping Address/btn_My Address'), 30)

WebUI.enhancedClick(findTestObject('Address Management/Shipping Address/btn_My Address'))

WebUI.waitForPageLoad(30)

// ========================
// CLICK EDIT
// ========================
WebUI.waitForElementClickable(findTestObject('Address Management/Shipping Address/btn_Edit'), 30)

WebUI.scrollToElement(findTestObject('Address Management/Shipping Address/btn_Edit'), 5)

WebUI.enhancedClick(findTestObject('Address Management/Shipping Address/btn_Edit'))

// ========================
// EDIT FORM
// ========================
WebUI.waitForElementVisible(findTestObject('Address Management/Edit Address/Field_First Name'), 30)

WebUI.clearText(findTestObject('Address Management/Edit Address/Field_First Name'))

WebUI.setText(findTestObject('Address Management/Edit Address/Field_First Name'), randomFirstName)

WebUI.clearText(findTestObject('Address Management/Edit Address/Field_Last Name'))

WebUI.setText(findTestObject('Address Management/Edit Address/Field_Last Name'), randomLastName)

WebUI.clearText(findTestObject('Address Management/Edit Address/Field_Mobile Phone'))

WebUI.setText(findTestObject('Address Management/Edit Address/Field_Mobile Phone'), randomPhone)

WebUI.clearText(findTestObject('Address Management/Edit Address/Field_E-mail'))

WebUI.setText(findTestObject('Address Management/Edit Address/Field_E-mail'), randomEmail)

WebUI.clearText(findTestObject('Address Management/Edit Address/Field_Address'))

WebUI.setText(findTestObject('Address Management/Edit Address/Field_Address'), randomAddress)

WebUI.clearText(findTestObject('Address Management/Edit Address/Field_ZipPostal Code'))

WebUI.setText(findTestObject('Address Management/Edit Address/Field_ZipPostal Code'), randomCode)

// ========================
// SAVE
// ========================
WebUI.scrollToElement(findTestObject('Address Management/Edit Address/button_Save'), 5)

WebUI.waitForElementClickable(findTestObject('Address Management/Edit Address/button_Save'), 30)

WebUI.enhancedClick(findTestObject('Address Management/Edit Address/button_Save'))

WebUI.waitForPageLoad(30)

// ========================
// VERIFY UPDATED
// ========================
WebUI.scrollToElement(findTestObject('Address Management/Shipping Address/lbl_Shipping Address'), 5)

TestObject verifyName = new TestObject('verifyName')

verifyName.addProperty('xpath', ConditionType.EQUALS, "//*[contains(text(),'$randomFirstName')]")

WebUI.verifyElementPresent(verifyName, 30)

WebUI.comment('Email      : ' + randomEmail)

WebUI.comment('First Name : ' + randomFirstName)

WebUI.comment('Last Name  : ' + randomLastName)

WebUI.comment('Phone      : ' + randomPhone)

WebUI.comment('Address    : ' + randomAddress)

WebUI.comment('Code       : ' + randomCode)

// ========================
// CLOSE BROWSER
// ========================
WebUI.closeBrowser()

