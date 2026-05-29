import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import com.kms.katalon.core.annotation.*
import com.kms.katalon.core.configuration.RunConfiguration

import java.text.SimpleDateFormat
import java.util.Date
import java.nio.file.Files
import java.nio.file.Paths

class AutoScreenshotListener {

	String getTimestamp() {
		return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
	}

	String getTestCaseName() {
		return RunConfiguration.getExecutionSourceName()
				.replace("Test Cases/", "")
				.replaceAll("[\\\\/:*?\"<>|]", "_")
	}

	void saveScreenshot(String status) {

		String tcName = getTestCaseName()

		String folderPath = "Screenshot/${status}/${tcName}/"

		// Create folder otomatis
		Files.createDirectories(Paths.get(folderPath))

		String screenshotPath =
				"${folderPath}${status}_${getTimestamp()}.png"

		WebUI.takeScreenshot(screenshotPath)

		println("Screenshot saved : " + screenshotPath)
	}

	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {

		String status = testCaseContext.getTestCaseStatus()

		if (status == "PASSED") {

			saveScreenshot("PASSED")

		} else if (status == "FAILED") {

			saveScreenshot("FAILED")

		}
	}
}