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

// ==========================
// MENU IPHONE
// ==========================
clickWhenReady('Home Page/Page Iphone/menu-iphone')

clickWhenReady('Home Page/Page Iphone/sub-menu-iPhone 14 Pro Max')

clickWhenReady('Home Page/Page Iphone/sub-menu-iPhone 13 Pro Max')

clickWhenReady('Home Page/Page Iphone/sub-menu-iPhone 13 Pro')

clickWhenReady('Home Page/Page Iphone/sub-menu-iPhone 13')

clickWhenReady('Home Page/Page Iphone/sub-menu-iPhone 13 mini')

clickWhenReady('Home Page/Page Iphone/sub-menu-iPhone 12')

clickWhenReady('Home Page/Page Iphone/sub-menu-iPhone 11')

// ==========================
// MENU IPAD
// ==========================
clickWhenReady('Home Page/Page Ipad/menu-ipad')

clickWhenReady('Home Page/Page Ipad/sub-menu-iPad pro')

clickWhenReady('Home Page/Page Ipad/sub-menu-iPad Air')

clickWhenReady('Home Page/Page Ipad/sub-menu-iPad Mini')

clickWhenReady('Home Page/Page Ipad/sub-menu-iPad (Gen 10th)')

clickWhenReady('Home Page/Page Ipad/sub-menu-iPad')

// ==========================
// MENU APPLE WATCH
// ==========================
clickWhenReady('Home Page/Page Apple Watch/menu-Apple Watch')

clickWhenReady('Home Page/Page Apple Watch/sub-menu-Apple Watch 7')

clickWhenReady('Home Page/Page Apple Watch/sub-menu-Apple Watch 6')

clickWhenReady('Home Page/Page Apple Watch/sub-menu-Apple Watch 3')

clickWhenReady('Home Page/Page Apple Watch/sub-menu-Apple Watch SE')

clickWhenReady('Home Page/Page Apple Watch/sub-menu-Apple Watch Ultra')

// ==========================
// MENU MAC
// ==========================
clickWhenReady('Home Page/Page Mac/menu-Mac')

clickWhenReady('Home Page/Page Mac/sub-menu-MacBook Pro')

clickWhenReady('Home Page/Page Mac/sub-menu-MacBook Air')

// ==========================
// MENU AIRPODS
// ==========================
clickWhenReady('Home Page/Page Airpods/menu-AirPods')

clickWhenReady('Home Page/Page Airpods/sub-menu-AirPods Max')

clickWhenReady('Home Page/Page Airpods/sub-menu-AirPods Pro')

clickWhenReady('Home Page/Page Airpods/sub-menu-AirPods 3rd Generation')

clickWhenReady('Home Page/Page Airpods/sub-menu-AirPods 2nd Generation')

// ==========================
// MENU ACCESSORIES
// ==========================
clickWhenReady('Home Page/Page Accessoris/menu-accessoris')

clickWhenReady('Home Page/Page Accessoris/sub-menu-Aksesoris iPhone')

clickWhenReady('Home Page/Page Accessoris/sub-menu-Aksesoris iPad')

clickWhenReady('Home Page/Page Accessoris/sub-menu-MacBook Accessories')

clickWhenReady('Home Page/Page Accessoris/sub-menu-Watch accessories')

// ==========================
// MENU PROMOTION
// ==========================
clickWhenReady('Home Page/Page Promotion/menu-Promotion')

clickWhenReady('Home Page/Page Promotion/sub-menu-Digimania August 2022')

clickWhenReady('Home Page/Page Promotion/sub-menu-Flash Sale')

// ==========================
// MENU ENTERPRISE
// ==========================
clickWhenReady('Home Page/Page Enterprice and Education/menu-Enterprise and Education')

// ==========================
// CLOSE BROWSER
// ==========================
WebUI.closeBrowser()

def clickWhenReady(String objectPath) {
    TestObject obj = findTestObject(objectPath)

    WebUI.waitForElementVisible(obj, 15)

    WebUI.scrollToElement(obj, 5)

    WebUI.waitForElementClickable(obj, 10)

    try {
        WebUI.click(obj)
    }
    catch (Exception e) {
        println('Normal click gagal, pakai JS Click')

        WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(WebUiCommonHelper.findWebElement(obj, 10)))
    } 
    
    WebUI.delay(1)

    WebUI.waitForPageLoad(10)
}

