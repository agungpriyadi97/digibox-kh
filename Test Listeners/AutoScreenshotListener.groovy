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

/**
 * AutoScreenshotListener
 *
 * Otomatis mengambil screenshot dan menyimpan HTML source pada setiap test case,
 * baik PASSED maupun FAILED. Khusus untuk FAILED, akan menyimpan HTML source
 * untuk memudahkan debugging di environment CI/CD.
 *
 * @author Agung Priyadi
 */
class AutoScreenshotListener {

	/**
	 * Mendapatkan timestamp saat ini dalam format yyyyMMdd_HHmmss
	 * @return String timestam
	 */
	String getTimestamp() {
		return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
	}

	/**
	 * Mendapatkan nama test case yang sedang berjalan, membersihkan karakter tidak valid untuk path folder
	 * @return String nama test case
	 */
	String getTestCaseName() {
		return RunConfiguration.getExecutionSourceName()
				.replace("Test Cases/", "")
				.replaceAll("[\\\\/:*?\"<>|]", "_")
	}

	/**
	 * Menyimpan screenshot ke folder Screenshot/{status}/{testCaseName}/
	 * @param status Status test case (PASSED/FAILED)
	 */
	void saveScreenshot(String status) {
		try {
			String tcName = getTestCaseName()
			String folderPath = "Screenshot/${status}/${tcName}/"
			// Buat folder jika belum ada
			Files.createDirectories(Paths.get(folderPath))
			String screenshotPath = "${folderPath}${status}_${getTimestamp()}.png"
			WebUI.takeScreenshot(screenshotPath)
			println("Screenshot saved : " + screenshotPath)
		} catch (Exception e) {
			println("Failed to save screenshot: " + e.getMessage())
		}
	}

	/**
	 * Menyimpan HTML source dari halaman saat ini ke file
	 * @param status Status test case (PASSED/FAILED) - akan digunakan sebagai subfolder
	 */
	void saveHtmlSource(String status) {
		try {
			String tcName = getTestCaseName()
			String folderPath = "Screenshot/${status}/${tcName}/"
			Files.createDirectories(Paths.get(folderPath))
			String htmlPath = "${folderPath}${status}_${getTimestamp()}.html"
			
			// Gunakan FailureHandling.OPTIONAL agar tidak throw exception jika browser sudah tertutup
			String html = WebUI.getHtmlSource(FailureHandling.OPTIONAL)
			if (html != null && !html.isEmpty()) {
				Files.write(Paths.get(htmlPath), html.getBytes())
				println("HTML source saved : " + htmlPath)
			} else {
				println("HTML source is empty or browser not available. Skipped saving HTML.")
			}
		} catch (Exception e) {
			println("Failed to save HTML source: " + e.getMessage())
		}
	}

	/**
	 * Listener yang dijalankan setelah setiap test case selesai
	 * @param testCaseContext Context test case yang berisi status
	 */
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		String status = testCaseContext.getTestCaseStatus()
		
		if (status == "PASSED") {
			saveScreenshot("PASSED")
			// Opsional: simpan HTML source juga untuk PASSED jika diperlukan (aktifkan baris di bawah)
			// saveHtmlSource("PASSED")
		} else if (status == "FAILED") {
			saveScreenshot("FAILED")
			saveHtmlSource("FAILED")  // Simpan HTML source untuk debugging
		}
		
		// Cetak status ke console agar mudah dibaca di log CI
		println("Test Case '${testCaseContext.getTestCaseId()}' finished with status: ${status}")
	}
}