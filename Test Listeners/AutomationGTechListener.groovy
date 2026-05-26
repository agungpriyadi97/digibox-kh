//import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
//import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
//import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
//import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
//
//import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
//import com.kms.katalon.core.model.FailureHandling as FailureHandling
//import com.kms.katalon.core.testcase.TestCase as TestCase
//import com.kms.katalon.core.testdata.TestData as TestData
//import com.kms.katalon.core.testobject.TestObject as TestObject
//
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
//
//import internal.GlobalVariable as GlobalVariable
//
//import com.kms.katalon.core.annotation.BeforeTestCase
//import com.kms.katalon.core.annotation.BeforeTestSuite
//import com.kms.katalon.core.annotation.AfterTestCase
//import com.kms.katalon.core.annotation.AfterTestSuite
//import com.kms.katalon.core.context.TestCaseContext
//import com.kms.katalon.core.context.TestSuiteContext
//import com.kms.katalon.core.keyword.builtin.CallTestCaseKeyword
//import com.kms.katalon.core.model.FailureHandling
//
//import com.kms.katalon.core.annotation.BeforeTestSuite
//import com.kms.katalon.core.configuration.RunConfiguration
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
//
//import com.kms.katalon.core.annotation.BeforeTestSuite
//import com.kms.katalon.core.annotation.BeforeTestSuite
//import com.kms.katalon.core.context.TestSuiteContext
////import io.appium.java_client.remote.MobileCapabilityType  // Import this!
//import org.openqa.selenium.remote.DesiredCapabilities
//import com.kms.katalon.core.util.KeywordUtil
//
//import com.kms.katalon.core.configuration.RunConfiguration
//import com.kms.katalon.core.util.KeywordUtil
//import com.kms.katalon.core.context.TestCaseContext
//
//import io.appium.java_client.AppiumDriver
////import io.appium.java_client.MobileElement
//
//class AutomationGTechListener {
//	/**
//	 * Executes before every test case starts.
//	 * @param testCaseContext related information of the executed test case.
//	 */
//	@BeforeTestCase
//	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
//		println testCaseContext.getTestCaseId()
//		println testCaseContext.getTestCaseVariables()
//		
//		if (GlobalVariable.web == '1') {
//			if(GlobalVariable.homepage == '1') {
//				// do testcase that start with home page
//				if(GlobalVariable.editProfile == '1') {
//					WebUI.callTestCase(findTestCase('Test Cases/WEB/Login/Ensure Login Works with Valid Prefix - Edit Profile'), [:], FailureHandling.STOP_ON_FAILURE)
//					
//				}
//				
//				if(GlobalVariable.EDS == '1') {
//					WebUI.callTestCase(findTestCase('Test Cases/WEB/Login/Ensure Login Works with Valid Prefix - EDS'), [:], FailureHandling.STOP_ON_FAILURE)
//					
//				}
//				
//				if(GlobalVariable.loginFirst == '1') {
//					WebUI.callTestCase(findTestCase('Test Cases/WEB/Login/Ensure Login Works with Valid Prefix - New Flow'), [:], FailureHandling.STOP_ON_FAILURE)
//				
//				}
//				
//				
//				if(GlobalVariable.English == '1') {
//					WebUI.delay(3)
//					
//					WebUI.waitForElementPresent(findTestObject('Object Repository/WEB/Language/Page_Title MAPCLUB Consolidation/btn_English'),
//						0)
//					
//					WebUI.click(findTestObject('Object Repository/WEB/Language/Page_Title MAPCLUB Consolidation/btn_English'))
//					
//					WebUI.delay(2)
//				}
//				
//				
//			}else {
//				//do testcase that start with login/regist page
//				
//			}
//			
//			
//			
//			
//		}
//		
////		if(GlobalVariable.websuite == '1') {
////			if(GlobalVariable.registFirst == '1') {
////				WebUI.callTestCase(findTestCase('Test Cases/WEB/Register/Online Register/E2E Registrantion Online Mapclub'), [:], FailureHandling.STOP_ON_FAILURE)
////				
////			}
////			if(GlobalVariable.loginFirst == '1') {
////				WebUI.callTestCase(findTestCase('Test Cases/WEB/Login/Ensure Login Works with Valid Prefix'), [:], FailureHandling.STOP_ON_FAILURE)
////				
////			}
////			
////		}
//		if (GlobalVariable.Android == '1') {
////			String appPath = RunConfiguration.getProjectDir() + GlobalVariable.pathApps
////			
////			Mobile.startApplication(appPath, false)
//			
//			if(GlobalVariable.homepageApp == '1') {
//				if(Mobile.verifyElementVisible(findTestObject('Mobile APP/Login/btn_Lanjutan (Peringatan Keamanan)'), 5, FailureHandling.OPTIONAL)){
//					Mobile.tap(findTestObject('Mobile APP/Login/btn_Lanjutan (Peringatan Keamanan)'), 0)
//				}
//				
//				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Mobile APP/Homepage/btn_Beranda'), 5, FailureHandling.OPTIONAL)){
//					//Lanjut eksekusi testcase from homepage
//				}else {
//					WebUI.callTestCase(findTestCase('Test Cases/Mobile APP/Login/Mobile App - Ensure Login Works with Valid Prefix'), [:], FailureHandling.STOP_ON_FAILURE)
//					
//				}
//				
//				if(Mobile.verifyElementVisible(findTestObject('Mobile APP/Login/btn_Lanjutan (Peringatan Keamanan)'), 5, FailureHandling.OPTIONAL)){
//					Mobile.tap(findTestObject('Mobile APP/Login/btn_Lanjutan (Peringatan Keamanan)'), 0)
//				}
//			}
//			if(GlobalVariable.pageLoginApp == '1'){
//				if(Mobile.verifyElementVisible(findTestObject('Mobile APP/Login/btn_Lanjutan (Peringatan Keamanan)'), 10, FailureHandling.OPTIONAL)){
//					Mobile.tap(findTestObject('Mobile APP/Login/btn_Lanjutan (Peringatan Keamanan)'), 0)
//				}
//				
//				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Mobile APP/Homepage/btn_Beranda'), 5, FailureHandling.OPTIONAL)){
//					WebUI.callTestCase(findTestCase('Mobile APP/Logout/Mobile_Logout'), [:], FailureHandling.STOP_ON_FAILURE)
//				}else {
//					//Lanjut Eksekusi testcase login/regist
//					Mobile.delay(5)
//				}
//				
//				
//			}
//			else {
//			//			Mobile.closeApplication()
//			}
//			
//		}else {
//			
//		}
//		
//	}
//
//	/**
//	 * Executes after every test case ends.
//	 * @param testCaseContext related information of the executed test case.
//	 */
//	@AfterTestCase
//	def handleAfterTestCase(TestCaseContext testCaseContext) {
//		// --- STEP 1: CAPTURE SCREENSHOT IMMEDIATELY ---
//		// We do this first so the driver takes the shot before any reset logic (closeApplication) runs.
//		
//		try {
//			String status = testCaseContext.getTestCaseStatus()
//			String testCaseId = testCaseContext.getTestCaseId().replaceAll('[^a-zA-Z0-9]', '_')
//			String timestamp = new Date().format("yyyyMMdd_HHmmss")
//			String screenshotPath = RunConfiguration.getReportFolder() + "/Screenshot_" + testCaseId + "_" + status + "_" + timestamp + ".png"
//	
//			if (GlobalVariable.Android == '1') {
//				Mobile.takeScreenshot(screenshotPath, FailureHandling.OPTIONAL)
//			} else {
//				WebUI.takeScreenshot(screenshotPath, FailureHandling.OPTIONAL)
//			}
//			KeywordUtil.logInfo("Screenshot saved: " + screenshotPath)
//		} catch (Exception e) {
//			KeywordUtil.markWarning("Failed to take screenshot after test case: " + e.getMessage())
//		}
//	
//		// --- STEP 2: RESET / CLEANUP LOGIC ---
//		
//		if(GlobalVariable.Android == '1') {
//			if(GlobalVariable.tc_LoginRegist == '1'){
//				
//				if(Mobile.verifyElementVisible(findTestObject('Mobile APP/Login/txt_Selamat Datang di Mapclub, Renaldo'), 5, FailureHandling.OPTIONAL)){
//					WebUI.callTestCase(findTestCase('Mobile APP/Logout/Mobile_Logout'), [:], FailureHandling.STOP_ON_FAILURE)
//			
//				}else {
//	//				Mobile.closeApplication()
//					try {
//						Mobile.closeApplication()
//						String appPath = RunConfiguration.getProjectDir() + GlobalVariable.pathApps  // adjust path as needed
//	//					Mobile.startApplication(appPath, false)  // false = don't reinstall
//						Mobile.startExistingApplication('map.store.com.map_app.sandbox')
//						
//					} catch (Exception e) {
//						println "App reset failed: ${e.message}"
//					}
//				}
//				
//	//			if(GlobalVariable.pageLoginApp == '1') {
//	//				//berakhir di login page App
//	//				Mobile.closeApplication()
//	//			}
//	//			else {
//	//				//berakhir di home page App
//	//				WebUI.callTestCase(findTestCase('Mobile APP/Logout/Mobile_Logout'), [:], FailureHandling.STOP_ON_FAILURE)
//	//			}
//				
//			}else {
//	//			Mobile.closeApplication()
//				try {
//					Mobile.closeApplication()
//					String appPath = RunConfiguration.getProjectDir() + GlobalVariable.pathApps  // adjust path as needed
//	//				Mobile.startApplication(appPath, false)  // false = don't reinstall
//					Mobile.startExistingApplication('map.store.com.map_app.sandbox')
//				} catch (Exception e) {
//					println "App reset failed: ${e.message}"
//				}
//			}
//		}
//	//	if(GlobalVariable.registFirst == '1') {
//	//		WebUI.callTestCase(findTestCase('Test Cases/WEB/Register/Online Register/E2E Registrantion Online Mapclub'), [:], FailureHandling.STOP_ON_FAILURE)
//	//
//	//	}
//		else {
//			// Do web testcase
//	//		WebUI.closeBrowser()
//		}
//		
//		if(GlobalVariable.homepageAfterTestcase == '1') {
//			WebUI.navigateToUrl('https://d-friday.blubox.id/')
//		}
//	}
//	@BeforeTestSuite
//	def setupTestSuite(testSuiteContext) {
//		
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability("platformName", "Android");  // Specify platform
////		caps.setCapability("deviceName", "emulator-5554");  // Use `adb devices` to check
//		caps.setCapability("deviceName", "127.0.0.1:5555");  // Use `adb devices` to check
//		caps.setCapability("automationName", "UiAutomator2");  // Use UiAutomator2 for Android
//		
//		// **App Information**
////		caps.setCapability("appPackage", "map.store.com.map_app.sandbox");
////		caps.setCapability("appActivity", "map.store.com.mapemall.MainActivity");
//		
//		caps.setCapability("appPackage", "map.store.com.map_app.sandbox");
//		caps.setCapability("appActivity", "map.store.com.mapemall.MainActivity");
//		
//		
//		// **Other Common Capabilities**
//		caps.setCapability("noReset", true);  // Don't reset app data
//		caps.setCapability("fullReset", false);  // Don't uninstall app
//		caps.setCapability("newCommandTimeout", 300);  // Timeout for new commands
//		
////		if(Mobile.verifyElementVisible(findTestObject('Mobile APP/Login/txt_Selamat Datang di Mapclub, Renaldo'), 10)){
////			WebUI.callTestCase(findTestCase('Mobile APP/Logout/Mobile_Logout'), [:], FailureHandling.STOP_ON_FAILURE)
////			
////		}else {
//////			Mobile.closeApplication()
////		}
//		
//		if(GlobalVariable.websuite == '1') {
//			if(GlobalVariable.registFirst == '1') {
//				WebUI.callTestCase(findTestCase('Test Cases/WEB/Register/Online Register/E2E Registrantion Online Mapclub'), [:], FailureHandling.STOP_ON_FAILURE)
//				
//			}
//			if(GlobalVariable.loginFirst == '1') {
//				WebUI.callTestCase(findTestCase('Test Cases/WEB/Login/Ensure Login Works with Valid Prefix'), [:], FailureHandling.STOP_ON_FAILURE)
//				
//			}
//			if(GlobalVariable.pageLoginWeb == '1') {
//				WebUI.openBrowser('')
//				
//				WebUI.maximizeWindow()
//				
//				WebUI.navigateToUrl(GlobalVariable.Mapclub_Login_Staging)
//			}
//			
//			
//		}
//		
//		if (GlobalVariable.Android == '1') {
//			
//			String appPath = RunConfiguration.getProjectDir() + GlobalVariable.pathApps
//			
////			Mobile.startApplication(appPath, false)
//			Mobile.startExistingApplication('map.store.com.map_app.sandbox')
//			
//			if(GlobalVariable.registFirst == '1') {
//				WebUI.callTestCase(findTestCase('Test Cases/Mobile APP/REGISTER/Mobile App - E2E Registrantion Online Mapclub'), [:], FailureHandling.STOP_ON_FAILURE)
//				
//			}
//			
//			if(GlobalVariable.homepageAppTS == '1') {
//				if(Mobile.verifyElementVisible(findTestObject('Mobile APP/Login/btn_Lanjutan (Peringatan Keamanan)'), 10, FailureHandling.OPTIONAL)){
//					Mobile.tap(findTestObject('Mobile APP/Login/btn_Lanjutan (Peringatan Keamanan)'), 0)
//				}
//				
//				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Mobile APP/Homepage/btn_Beranda'), 5, FailureHandling.OPTIONAL)){
//					//Lanjut eksekusi testcase from homepage
//				}else {
//					WebUI.callTestCase(findTestCase('Test Cases/Mobile APP/Login/Mobile App - Ensure Login Works with Valid Prefix'), [:], FailureHandling.STOP_ON_FAILURE)
//					
//				}
//				
//				if(Mobile.verifyElementVisible(findTestObject('Mobile APP/Login/btn_Lanjutan (Peringatan Keamanan)'), 10, FailureHandling.OPTIONAL)){
//					Mobile.tap(findTestObject('Mobile APP/Login/btn_Lanjutan (Peringatan Keamanan)'), 0)
//				}
//			}
//			if(GlobalVariable.pageLoginAppTS == '1'){
//				if(Mobile.verifyElementVisible(findTestObject('Mobile APP/Login/btn_Lanjutan (Peringatan Keamanan)'), 10, FailureHandling.OPTIONAL)){
//					Mobile.tap(findTestObject('Mobile APP/Login/btn_Lanjutan (Peringatan Keamanan)'), 0)
//				}
//				
//				if(Mobile.verifyElementVisible(findTestObject('Object Repository/Mobile APP/Homepage/btn_Beranda'), 5, FailureHandling.OPTIONAL)){
//					WebUI.callTestCase(findTestCase('Mobile APP/Logout/Mobile_Logout'), [:], FailureHandling.STOP_ON_FAILURE)
//					
//					if(GlobalVariable.EDS == '1'){
//						WebUI.callTestCase(findTestCase('Test Cases/Mobile APP/Login/Mobile App - Ensure Login Works with Valid Prefix - EDS'), [:], FailureHandling.STOP_ON_FAILURE)
//					}
//				}else {
//					//Lanjut Eksekusi testcase login/regist
//					Mobile.delay(5)
//				}
//				
//				
//			}
//		}
//		
//		if(GlobalVariable.webNewFlow == '1') {
//			if(GlobalVariable.registFirstNewFlow == '1') {
//				WebUI.callTestCase(findTestCase('Test Cases/WEB/Register/Online Register/E2E Registrantion Online Mapclub'), [:], FailureHandling.STOP_ON_FAILURE)
//				
//			}
//			
//			if(GlobalVariable.loginFirstNewFlow == '1') {
//				WebUI.callTestCase(findTestCase('Test Cases/WEB/Login/Ensure Login Works with Valid Prefix - New Flow'), [:], FailureHandling.STOP_ON_FAILURE)
//			
//			}
//			
//			if(GlobalVariable.loginFirst == '1') {
//				WebUI.callTestCase(findTestCase('Test Cases/WEB/Login/Ensure Login Works with Valid Prefix'), [:], FailureHandling.STOP_ON_FAILURE)
//			
//			}
//			
//		}
//		
//		
//		
//	}
//
//	@AfterTestSuite
//	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
//		println testSuiteContext.getTestSuiteId()
//		
//		if(GlobalVariable.tc_stat == 'FAILED'){
//			KeywordUtil.markFailed("Some TC have failed run")
//		
//		}
////		else if(GlobalVariable.Android == "1"){
////			WebUI.callTestCase(findTestCase('Mobile APP/Logout/Mobile_Logout'), [:], FailureHandling.STOP_ON_FAILURE)
////			
////		}
//		else {
////			WebUI.callTestCase(findTestCase('Test Cases/WEB/Logout/Logout'), [:], FailureHandling.STOP_ON_FAILURE)
//			
//			WebUI.closeBrowser()
//			WebUI.delay(2)
//		}
//		
//
//	}
//}