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
WebUI.waitForElementVisible(findTestObject('WEB/Home Page/header_digibox'), 30)

// ========================
// SEARCH PRODUCT
// ========================
WebUI.waitForElementClickable(findTestObject('WEB/Home Page/Search/icon-search'), 30)

WebUI.enhancedClick(findTestObject('WEB/Home Page/Search/icon-search'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Search/field-search'), 30)

WebUI.setText(findTestObject('WEB/Home Page/Search/field-search'), 'IPHONE 13 PRO MAX SIERRA BLUE 128GB')

WebUI.sendKeys(findTestObject('WEB/Home Page/Search/field-search'), Keys.chord(Keys.ENTER))

WebUI.waitForPageLoad(30)

WebUI.delay(3)

WebUI.click(findTestObject('WEB/Product and Cart/Add to cart/btn_product_PHONE 13 PRO MAX SIERRA BLUE'))

WebUI.click(findTestObject('WEB/Product and Cart/Add to cart/button_Add to Cart'))

WebUI.waitForElementPresent(findTestObject('WEB/Product and Cart/Add to cart/i_icon-cart'), 30)

WebUI.waitForElementClickable(findTestObject('WEB/Product and Cart/Add to cart/i_icon-cart'), 30)

WebUI.click(findTestObject('WEB/Product and Cart/Add to cart/i_icon-cart'))

// ========================
// CHECKOUT
// ========================
WebUI.waitForElementVisible(findTestObject('WEB/Checkout/Address/Address Ship To/btn_checkout'), 30)

WebUI.waitForElementClickable(findTestObject('WEB/Checkout/Address/Address Ship To/btn_checkout'), 30)

WebUI.enhancedClick(findTestObject('WEB/Checkout/Address/Address Ship To/btn_checkout'))

WebUI.waitForPageLoad(30)

// ========================
// GUEST EMAIL
// ========================
WebUI.waitForElementVisible(findTestObject('WEB/Checkout/Checkout guest/field_email'), 30)

WebUI.setText(findTestObject('WEB/Checkout/Checkout guest/field_email'), randomEmail)

WebUI.waitForElementClickable(findTestObject('WEB/Checkout/Checkout guest/btn_continue'), 30)

WebUI.enhancedClick(findTestObject('WEB/Checkout/Checkout guest/btn_continue'))

WebUI.waitForPageLoad(30)

// ========================
// SHIPPING ADDRESS
// ========================
WebUI.waitForElementVisible(findTestObject('WEB/Checkout/Address/Address Ship To/field_First Name'), 30)

WebUI.setText(findTestObject('WEB/Checkout/Address/Address Ship To/field_First Name'), randomFirstName)

WebUI.setText(findTestObject('WEB/Checkout/Address/Address Ship To/field_Last Name'), randomLastName)

WebUI.setText(findTestObject('WEB/Checkout/Address/Address Ship To/field_mobile phone'), randomPhone)

WebUI.setText(findTestObject('WEB/Checkout/Address/Address Ship To/field_Address'), randomAddress)

WebUI.setText(findTestObject('WEB/Checkout/Address/Address Ship To/input_ZipPostal Code'), randomCode)

// Province
WebUI.waitForElementClickable(findTestObject('WEB/Checkout/Address/Address Ship To/input_Province'), 30)

WebUI.enhancedClick(findTestObject('WEB/Checkout/Address/Address Ship To/input_Province'))

WebUI.waitForElementVisible(findTestObject('WEB/Checkout/Address/Address Ship To/li_Phnom Penh Capital_Province'), 30)

WebUI.enhancedClick(findTestObject('WEB/Checkout/Address/Address Ship To/li_Phnom Penh Capital_Province'))

// City
WebUI.waitForElementClickable(findTestObject('WEB/Checkout/Address/Address Ship To/input_Select Province'), 30)

WebUI.enhancedClick(findTestObject('WEB/Checkout/Address/Address Ship To/input_Select Province'))

WebUI.waitForElementVisible(findTestObject('WEB/Checkout/Address/Address Ship To/li_Khan Chamkar Mon_Select_Province'), 
    30)

WebUI.enhancedClick(findTestObject('WEB/Checkout/Address/Address Ship To/li_Khan Chamkar Mon_Select_Province'))

// District
WebUI.waitForElementClickable(findTestObject('WEB/Checkout/Address/Address Ship To/input_Districts'), 30)

WebUI.enhancedClick(findTestObject('WEB/Checkout/Address/Address Ship To/input_Districts'))

WebUI.waitForElementVisible(findTestObject('WEB/Checkout/Address/Address Ship To/li_Sangkat Tonle Basak_Districts'), 30)

WebUI.enhancedClick(findTestObject('WEB/Checkout/Address/Address Ship To/li_Sangkat Tonle Basak_Districts'))

// Save
WebUI.scrollToElement(findTestObject('WEB/Checkout/Address/Address Ship To/btn-save'), 5)

WebUI.waitForElementClickable(findTestObject('WEB/Checkout/Address/Address Ship To/btn-save'), 30)

WebUI.enhancedClick(findTestObject('WEB/Checkout/Address/Address Ship To/btn-save'))

WebUI.waitForPageLoad(30)

