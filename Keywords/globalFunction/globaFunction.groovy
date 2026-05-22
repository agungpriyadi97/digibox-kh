//package globalFunction
//
//import java.sql.DriverManager
//import java.sql.ResultSet
//import java.sql.Statement
//import java.sql.Connection
//
//import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
//import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
//import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
//import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
//import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
//
//import com.kms.katalon.core.annotation.Keyword
//import com.kms.katalon.core.checkpoint.Checkpoint
//import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
//import com.kms.katalon.core.model.FailureHandling
//import com.kms.katalon.core.testcase.TestCase
//import com.kms.katalon.core.testdata.TestData
//import com.kms.katalon.core.testobject.TestObject
//import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
//import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
//
//import com.kms.katalon.core.annotation.Keyword
//import com.kms.katalon.core.testobject.ConditionType
//import com.kms.katalon.core.testobject.TestObject
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
//import com.kms.katalon.core.util.KeywordUtil
//
//import internal.GlobalVariable
//
//public class GetData {
//
//	@Keyword
//	def generatePhoneNumber() {
//		def providerPrefixes = [
//			811,
//			812,
//			813,
//			821,
//			822,
//			823,
//			851,
//			852,
//			853,
//			857,
//			858,
//			859
//		]
//
//		Random random = new Random()
//
//		def providerCode = providerPrefixes[random.nextInt(providerPrefixes.size())]
//
//		def subscriberNumber = random.nextInt(900000000) + 100000000
//
//		return "$providerCode$subscriberNumber"
//	}
//
//	@Keyword
//	def stringSet() {
//		String SALTCHARS = 'abcdefghijklmnopqrstuvwxyz1234567890'
//
//		StringBuilder salt = new StringBuilder()
//
//		Random rnd = new Random()
//
//		while (salt.length() < 5) {
//			int index = ((rnd.nextFloat() * SALTCHARS.length()) as int)
//
//			salt.append(SALTCHARS.charAt(index))
//		}
//
//		String saltStr = ('qagtech_' + salt.toString()) + '@yopmail.com'
//
//		return saltStr
//	}
//
//	private static Connection connection = null;
//
//	@Keyword
//	def connectDB(){
//
//		String conn = "jdbc:mysql://" + GlobalVariable.urlDB + ":" + GlobalVariable.portDB + "/" + GlobalVariable.dbname
//		if(connection != null && !connection.isClosed()){
//
//			connection.close()
//		}
//		connection = DriverManager.getConnection(conn, GlobalVariable.userDB, GlobalVariable.passDB)
//
//		return connection
//	}
//
//
//	@Keyword
//	def getOtp(String noHandphone){
//
//		Statement stm = connection.createStatement()
//		//noHandphone.substring(1,12)
//		//Query Excute
//		ResultSet rs = stm.executeQuery('SELECT otp FROM pawoon2.otps where phone='+'"'+noHandphone+'"'+ 'AND revoked != TRUE ORDER by created_at DESC LIMIT 1')
//
//		//Get Data OTP
//		while (rs.next()) {
//			String otp = rs.getString("otp")
//			//System.out.println(otp);
//			return otp
//		}
//	}
//}
