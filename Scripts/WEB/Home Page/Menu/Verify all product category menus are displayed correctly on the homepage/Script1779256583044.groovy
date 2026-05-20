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

// Function untuk click setelah element ready
def clickWhenReady(String objectPath) {
	TestObject obj = findTestObject(objectPath)

	WebUI.waitForElementVisible(obj, 10)
	WebUI.waitForElementClickable(obj, 10)
	WebUI.click(obj)

	// tunggu page selesai load setelah click
	WebUI.waitForPageLoad(10)
}

// Start test
WebUI.openBrowser(GlobalVariable.URL)
WebUI.maximizeWindow()
WebUI.enableSmartWait()

// Verify homepage
WebUI.waitForElementVisible(findTestObject('Home Page/header_digibox'), 10)
WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

// Menu iPhone
clickWhenReady('Home Page/Page Iphone/menu-iphone')
clickWhenReady('Home Page/Page Iphone/sub-menu-iPhone 14 Pro Max')
clickWhenReady('Home Page/Page Iphone/sub-menu-iPhone 13 Pro Max')
clickWhenReady('Home Page/Page Iphone/sub-menu-iPhone 13 Pro')
clickWhenReady('Home Page/Page Iphone/sub-menu-iPhone 13')
clickWhenReady('Home Page/Page Iphone/sub-menu-iPhone 13 mini')
clickWhenReady('Home Page/Page Iphone/sub-menu-iPhone 12')
clickWhenReady('Home Page/Page Iphone/sub-menu-iPhone 11')

// Menu ipad
clickWhenReady('Home Page/Page Ipad/menu-ipad')
clickWhenReady('Home Page/Page Ipad/sub-menu-iPad pro')
clickWhenReady('Home Page/Page Ipad/sub-menu-iPad Air')
clickWhenReady('Home Page/Page Ipad/sub-menu-iPad Mini')
clickWhenReady('Home Page/Page Ipad/sub-menu-iPad (Gen 10th)')
clickWhenReady('Home Page/Page Ipad/sub-menu-iPad')


// Menu Apple Watch
clickWhenReady('Home Page/Page Apple Watch/menu-Apple Watch')
clickWhenReady('Home Page/Page Apple Watch/sub-menu-Apple Watch 7')
// clickWhenReady('Home Page/Page Apple Watch/sub-menu-Apple Watch 6')
clickWhenReady('Home Page/Page Apple Watch/sub-menu-Apple Watch 3')
clickWhenReady('Home Page/Page Apple Watch/sub-menu-Apple Watch SE')
// clickWhenReady('Home Page/Page Apple Watch/sub-menu-Apple Watch Ultra')

// Menu Apple Mac
clickWhenReady('Home Page/Page Mac/menu-Mac')
clickWhenReady('Home Page/Page Mac/sub-menu-MacBook Pro')
clickWhenReady('Home Page/Page Mac/sub-menu-MacBook Air')

// Menu Apple AirPods
clickWhenReady('Home Page/Page Airpods/menu-AirPods')
clickWhenReady('Home Page/Page Airpods/sub-menu-AirPods Max')
clickWhenReady('Home Page/Page Airpods/sub-menu-AirPods Pro')
// clickWhenReady('Home Page/Page Ipad/sub-menu-AirPods 3rd Generation')
// clickWhenReady('Home Page/Page Ipad/sub-menu-AirPods 2rd Generation')

// Menu Apple accessoris
clickWhenReady('Home Page/Page Accessoris/menu-accessoris')
clickWhenReady('Home Page/Page Accessoris/sub-menu-Aksesoris iPhone')
clickWhenReady('Home Page/Page Accessoris/sub-menu-Aksesoris iPad')
clickWhenReady('Home Page/Page Accessoris/sub-menu-MacBook Accessories')
clickWhenReady('Home Page/Page Accessoris/sub-menu-Watch accessories')

// Menu Apple Promotion
clickWhenReady('Home Page/Page Promotion/menu-Promotion')
// clickWhenReady('Home Page/Page Promotion/sub-menu-Digimania August 2022')
clickWhenReady('Home Page/Page Promotion/sub-menu-Flash Sale')

// Menu Apple Enterprise and Education
clickWhenReady('Home Page/Page Enterprice and Education/menu-Enterprise and Education')

// Screenshot
WebUI.takeScreenshot()

// Close browser
WebUI.closeBrowser()

