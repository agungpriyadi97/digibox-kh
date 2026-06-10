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

// ==========================
// FUNCTION CLICK READY
// ==========================
// ==========================
// START TEST
// ==========================
WebUI.openBrowser('')

CustomKeywords.'custom.BrowserHelper.setupBrowserWindow'()

// PENTING untuk headless chrome
WebUI.setViewPortSize(1920, 1080)

WebUI.enableSmartWait()

WebUI.navigateToUrl(GlobalVariable.URL)

// ==========================
// VERIFY HOMEPAGE
// ==========================
WebUI.waitForElementVisible(findTestObject('WEB/Home Page/header_digibox'), 15)

WebUI.verifyElementVisible(findTestObject('WEB/Home Page/header_digibox'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Iphone/menu-iphone'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Iphone/menu-iphone'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Iphone/sub-menu-iPhone 14 Pro Max'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Iphone/menu-iphone'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Iphone/menu-iphone'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Iphone/sub-menu-iPhone 13 Pro Max'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Iphone/menu-iphone'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Iphone/menu-iphone'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Iphone/sub-menu-iPhone 13 Pro'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Iphone/menu-iphone'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Iphone/menu-iphone'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Iphone/sub-menu-iPhone 13'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Iphone/menu-iphone'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Iphone/menu-iphone'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Iphone/sub-menu-iPhone 13 mini'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Iphone/menu-iphone'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Iphone/menu-iphone'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Iphone/sub-menu-iPhone 12'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Iphone/menu-iphone'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Iphone/menu-iphone'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Iphone/sub-menu-iPhone 11'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Ipad/menu-ipad'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Ipad/menu-ipad'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Ipad/sub-menu-iPad pro'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Ipad/menu-ipad'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Ipad/menu-ipad'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Ipad/sub-menu-iPad Air'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Ipad/menu-ipad'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Ipad/menu-ipad'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Ipad/sub-menu-iPad mini'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Ipad/menu-ipad'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Ipad/menu-ipad'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Ipad/sub-menu-iPad (Gen 10th)'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Apple Watch/menu-Apple Watch'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Apple Watch/menu-Apple Watch'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Apple Watch/sub-menu-Apple Watch 7'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Apple Watch/menu-Apple Watch'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Apple Watch/menu-Apple Watch'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Apple Watch/sub-menu-Apple Watch 6'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Apple Watch/menu-Apple Watch'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Apple Watch/menu-Apple Watch'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Apple Watch/sub-menu-Apple Watch 3'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Apple Watch/menu-Apple Watch'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Apple Watch/menu-Apple Watch'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Apple Watch/sub-menu-Apple Watch SE'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Apple Watch/menu-Apple Watch'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Apple Watch/menu-Apple Watch'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Apple Watch/sub-menu-Apple Watch Ultra'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Mac/menu-Mac'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Mac/menu-Mac'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Mac/sub-menu-MacBook Pro'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Mac/menu-Mac'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Mac/menu-Mac'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Mac/sub-menu-MacBook Air'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Airpods/menu-AirPods'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Airpods/menu-AirPods'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Airpods/sub-menu-AirPods Max'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Airpods/menu-AirPods'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Airpods/menu-AirPods'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Airpods/sub-menu-AirPods Pro'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Airpods/menu-AirPods'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Airpods/menu-AirPods'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Airpods/sub-menu-AirPods 3rd Generation'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Airpods/menu-AirPods'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Airpods/menu-AirPods'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Airpods/sub-menu-AirPods 2nd Generation'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Accessoris/menu-accessoris'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Accessoris/menu-accessoris'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Accessoris/sub-menu-Aksesoris iPhone'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Accessoris/menu-accessoris'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Accessoris/menu-accessoris'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Accessoris/sub-menu-Aksesoris iPad'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Accessoris/menu-accessoris'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Accessoris/menu-accessoris'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Accessoris/sub-menu-MacBook Accessories'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Accessoris/menu-accessoris'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Accessoris/menu-accessoris'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Accessoris/sub-menu-Watch accessories'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Promotion/menu-Promotion'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Promotion/menu-Promotion'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Promotion/sub-menu-Digimania August 2022'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Promotion/menu-Promotion'), 10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Promotion/menu-Promotion'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Promotion/sub-menu-Flash Sale'))

WebUI.waitForElementVisible(findTestObject('WEB/Home Page/Page Enterprice and Education/menu-Enterprise and Education'), 
    10)

WebUI.mouseOver(findTestObject('WEB/Home Page/Page Enterprice and Education/menu-Enterprise and Education'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home Page/Page Enterprice and Education/menu-Enterprise and Education'))

WebUI.waitForPageLoad(10)

WebUI.closeBrowser()

