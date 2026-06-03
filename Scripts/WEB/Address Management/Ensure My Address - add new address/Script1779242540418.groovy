import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

String randomFirstName = CustomKeywords.'custom.RandomData.generateRandomFirstName'()

String randomEmail = CustomKeywords.'custom.RandomData.generateRandomEmail'()

String randomLastName = CustomKeywords.'custom.RandomData.generateRandomLastName'()

String randomPhone = CustomKeywords.'custom.RandomData.generateRandomPhone'()

String randomAddress = CustomKeywords.'custom.RandomData.generateRandomAddress'()

String randomCode = CustomKeywords.'custom.RandomData.generateRandomCode'()

// Open Browser
WebUI.openBrowser('')

WebUI.setViewPortSize(1920, 1080)

WebUI.navigateToUrl(GlobalVariable.URL)

CustomKeywords.'custom.BrowserHelper.setupBrowserWindow'()

// Verify Homepage
WebUI.waitForPageLoad(30)

WebUI.waitForElementVisible(findTestObject('Home Page/header_digibox'), 30)

// Login
WebUI.waitForElementClickable(findTestObject('Registration/icon-acount'), 30)

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.waitForElementVisible(findTestObject('Registration/field-account'), 30)

WebUI.setText(findTestObject('Registration/field-account'), 'agungpriyadi')

WebUI.waitForElementVisible(findTestObject('Registration/field-Password'), 30)

WebUI.setText(findTestObject('Registration/field-Password'), 'Laskar123456')

WebUI.waitForElementClickable(findTestObject('Login/btn-sign in'), 30)

WebUI.click(findTestObject('Login/btn-sign in'))

WebUI.waitForPageLoad(30)

// Open My Address
WebUI.waitForElementClickable(findTestObject('Registration/icon-acount'), 30)

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.waitForElementClickable(findTestObject('Address Management/Shipping Address/btn_My Address'), 30)

WebUI.click(findTestObject('Address Management/Shipping Address/btn_My Address'))

// Add New Address
WebUI.waitForElementClickable(findTestObject('Address Management/Add New Address/div_Add New Address'), 30)

WebUI.click(findTestObject('Address Management/Add New Address/div_Add New Address'))

// First Name
WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/field_First Name'), 30)

WebUI.setText(findTestObject('Address Management/Add New Address/field_First Name'), randomFirstName)

// Last Name
WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/field_Last Name'), 30)

WebUI.setText(findTestObject('Address Management/Add New Address/field_Last Name'), randomLastName)

// Phone
WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/field_Mobile Phone'), 30)

WebUI.setText(findTestObject('Address Management/Add New Address/field_Mobile Phone'), randomPhone)

// Email
WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/field_E-mail'), 30)

WebUI.setText(findTestObject('Address Management/Add New Address/field_E-mail'), randomEmail)

// Address
WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/field_Address'), 30)

WebUI.setText(findTestObject('Address Management/Add New Address/field_Address'), randomAddress)

// Province
WebUI.waitForElementClickable(findTestObject('Address Management/Add New Address/dropdown_Province'), 30)

WebUI.click(findTestObject('Address Management/Add New Address/dropdown_Province'))

WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/Dropdown Province/li_Banteay Meanchey Province'), 
    30)

WebUI.click(findTestObject('Address Management/Add New Address/Dropdown Province/li_Banteay Meanchey Province'))

// City
WebUI.waitForElementClickable(findTestObject('Address Management/Add New Address/dropdown_Select Province'), 30)

WebUI.click(findTestObject('Address Management/Add New Address/dropdown_Select Province'))

WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/Dropdown Select Province/li_Paoy Paet Municipality'), 
    30)

WebUI.click(findTestObject('Address Management/Add New Address/Dropdown Select Province/li_Paoy Paet Municipality'))

// District
WebUI.waitForElementClickable(findTestObject('Address Management/Add New Address/dropdown_Districts'), 30)

WebUI.click(findTestObject('Address Management/Add New Address/dropdown_Districts'))

WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/Dropdown District/li_Sangkat Kandal'), 30)

WebUI.click(findTestObject('Address Management/Add New Address/Dropdown District/li_Sangkat Kandal'))

// Postal Code
WebUI.waitForElementVisible(findTestObject('Address Management/Add New Address/field_ZipPostal Code'), 30)

WebUI.setText(findTestObject('Address Management/Add New Address/field_ZipPostal Code'), randomCode)

// Save
WebUI.scrollToElement(findTestObject('Address Management/Add New Address/button_Save'), 5)

WebUI.waitForElementClickable(findTestObject('Address Management/Add New Address/button_Save'), 30)

WebUI.click(findTestObject('Address Management/Add New Address/button_Save'))

WebUI.waitForPageLoad(30)

// Verify
WebUI.scrollToElement(findTestObject('Address Management/Shipping Address/lbl_Shipping Address'), 5)

WebUI.comment('Email      : ' + randomEmail)

WebUI.comment('First Name : ' + randomFirstName)

WebUI.comment('Last Name  : ' + randomLastName)

WebUI.comment('Phone      : ' + randomPhone)

WebUI.comment('Address    : ' + randomAddress)

WebUI.comment('Code       : ' + randomCode)

WebUI.closeBrowser()

