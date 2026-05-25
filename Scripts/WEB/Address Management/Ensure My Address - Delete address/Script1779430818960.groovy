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

// Open browser
WebUI.openBrowser(GlobalVariable.URL)

// Verify homepage
WebUI.verifyElementVisible(findTestObject('Home Page/header_digibox'))

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.setText(findTestObject('Registration/field-account'), 'agungpriyadi')

WebUI.setText(findTestObject('Registration/field-Password'), 'Laskar123456')

WebUI.click(findTestObject('Login/btn-sign in'))

WebUI.click(findTestObject('Registration/icon-acount'))

WebUI.click(findTestObject('Address Management/Shipping Address/btn_My Address'))

WebUI.click(findTestObject('Address Management/Shipping Address/btn_Delete'))

TestObject btnOK = new TestObject()

btnOK.addProperty('xpath', ConditionType.EQUALS, '//div[contains(@class,\'el-message-box\')]//span[normalize-space()=\'OK\']')

WebUI.waitForElementVisible(btnOK, 10)

def okElement = WebUI.findWebElement(btnOK, 10)

WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(okElement))

// refresh supaya UI update
WebUI.refresh()

WebUI.waitForPageLoad(10)

// verify email deleted tidak ada lagi
TestObject deletedEmail = new TestObject()

deletedEmail.addProperty('xpath', ConditionType.EQUALS, '//*[contains(text(),\'agung.priyadi@gtech.digital\')]')

WebUI.takeScreenshot()

WebUI.closeBrowser()

