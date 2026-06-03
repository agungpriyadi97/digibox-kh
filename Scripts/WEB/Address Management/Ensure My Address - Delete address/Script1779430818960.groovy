import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

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
// DELETE ADDRESS
// ========================
WebUI.waitForElementClickable(findTestObject('Address Management/Shipping Address/btn_Delete'), 30)

WebUI.scrollToElement(findTestObject('Address Management/Shipping Address/btn_Delete'), 5)

WebUI.enhancedClick(findTestObject('Address Management/Shipping Address/btn_Delete'))

// ========================
// POPUP CONFIRMATION OK
// ========================
TestObject btnOK = new TestObject('btnOK')

btnOK.addProperty('xpath', ConditionType.EQUALS, '//div[contains(@class,\'el-message-box\')]//span[normalize-space()=\'OK\']')

WebUI.waitForElementVisible(btnOK, 30)

WebUI.waitForElementClickable(btnOK, 30)

WebUI.enhancedClick(btnOK)

WebUI.waitForPageLoad(10)

// ========================
// REFRESH PAGE
// ========================
WebUI.refresh()

WebUI.waitForPageLoad(30)

// ========================
// VERIFY DATA DELETED
// ========================
TestObject deletedEmail = new TestObject('deletedEmail')

deletedEmail.addProperty('xpath', ConditionType.EQUALS, '//*[contains(text(),\'agung.priyadi@gtech.digital\')]')

boolean isEmailStillExist = WebUI.verifyElementPresent(deletedEmail, 5, com.kms.katalon.core.model.FailureHandling.OPTIONAL)

if (isEmailStillExist) {
    WebUI.comment('FAILED - Email masih ditemukan setelah delete')

    WebUI.takeScreenshot()

    assert false : 'Email masih tampil setelah delete address'
} else {
    WebUI.comment('PASSED - Address berhasil dihapus')
}

// ========================
// CLOSE BROWSER
// ========================
WebUI.closeBrowser()

