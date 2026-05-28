import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// OPEN BROWSER
WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

// VERIFY HOME
WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

// LOGIN
WebUI.click(findTestObject('Registration/icon-acount'))

CustomKeywords.'custom.BrowserHelper.closeFirefoxPopup'()

WebUI.setText(findTestObject('Registration/field-account'), GlobalVariable.username)

WebUI.setEncryptedText(findTestObject('Registration/field-Password'), GlobalVariable.password)

WebUI.click(findTestObject('Login/btn-sign in'))

// VERIFY LOGIN
WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.verifyElementVisible(findTestObject('Home Page/verify-succes-acount-login'))

// SEARCH PRODUCT
WebUI.click(findTestObject('Home Page/Search/icon-search'))

WebUI.setText(findTestObject('Home Page/Search/field-search'), 'IPHONE')

WebUI.sendKeys(findTestObject('Home Page/Search/field-search'), Keys.chord(Keys.ENTER))

// WAIT PRODUCT LIST
WebUI.waitForElementVisible(findTestObject('Home Page/Search/list_product'), 10)

// GET PRODUCT LIST
List<WebElement> products = WebUiCommonHelper.findWebElements(findTestObject('Home Page/Search/list_product'), 10)

boolean productFound = false

// LOOP PRODUCT
for (int i = 1; i <= products.size(); i++) {
    TestObject dynamicProduct = new TestObject()

    dynamicProduct.addProperty('xpath', ConditionType.EQUALS, ('(//div[contains(@class,\'sp-plp-card\')])[' + i) + ']')

    WebUI.comment('Checking product index : ' + i)

    WebUI.click(dynamicProduct)

    // WAIT PDP PAGE
    WebUI.waitForPageLoad(10)

    // CHECK ADD TO CART BUTTON
    boolean addToCartExist = WebUI.verifyElementPresent(findTestObject('Product and Cart/Add to cart/button_Add to Cart'), 
        5, FailureHandling.OPTIONAL)

    if (addToCartExist) {
        WebUI.comment('Available product found')

        WebUI.click(findTestObject('Product and Cart/Add to cart/button_Add to Cart'))

        productFound = true

        break
    } else {
        WebUI.comment('Product sold out')

        WebUI.back()

        WebUI.waitForPageLoad(10)
    }
}

// FAIL IF NO PRODUCT AVAILABLE
assert productFound : 'Semua product sold out'

// OPEN CART
WebUI.waitForElementPresent(findTestObject('Product and Cart/Add to cart/i_icon-cart'), 10)

WebUI.click(findTestObject('Product and Cart/Add to cart/i_icon-cart'))

// CHECKOUT
WebUI.verifyElementVisible(findTestObject('Checkout/Address/Address Ship To/btn_checkout'))

WebUI.click(findTestObject('Checkout/Address/Address Ship To/btn_checkout'))

// PAYMENT METHOD
WebUI.click(findTestObject('Checkout/Order Summary/Online Payment - Cradit Card'))

WebUI.check(findTestObject('Checkout/Order Summary/Checkbox__I accept'))

WebUI.click(findTestObject('Checkout/Order Summary/button_Checkout_Payment'))

// WAIT IFRAME
WebUI.waitForElementPresent(findTestObject('Checkout/Page Checkout/iframe_Credit Card'), 15)

// SWITCH TO IFRAME
WebUI.switchToFrame(findTestObject('Checkout/Page Checkout/iframe_Credit Card'), 10)

// WAIT CARD FIELD
WebUI.waitForElementVisible(findTestObject('Checkout/Page Checkout/field_cardNumber'), 10)

// INPUT CARD
WebUI.setText(findTestObject('Checkout/Page Checkout/field_cardNumber'), '5156839937706777')

// INPUT EXP DATE
TestObject expiry = findTestObject('Checkout/Page Checkout/field_cardExp')

WebUI.click(expiry)

WebUI.sendKeys(expiry, '0130')

// INPUT CVV
WebUI.setText(findTestObject('Checkout/Page Checkout/field_cvv2'), '993')

// PAY
WebUI.click(findTestObject('Checkout/Order Summary/button_Pay (1)'))

// VERIFY SUCCESS
WebUI.waitForElementPresent(findTestObject('Checkout/Order Summary/button_Continue shopping'), 15)

WebUI.click(findTestObject('Checkout/Order Summary/button_Continue shopping'))

// TRACK ORDER
WebUI.waitForElementVisible(findTestObject('Checkout/Track Order/track your order'), 10)

WebUI.click(findTestObject('Checkout/Track Order/track your order'))

WebUI.click(findTestObject('Checkout/button_Order Details'))

WebUI.scrollToElement(findTestObject('Checkout/Track Order/verify-order list'), 10)

// SCREENSHOT
WebUI.takeScreenshot()

// CLOSE
WebUI.closeBrowser()

