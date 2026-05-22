//package mongoDB
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
//import com.mongodb.client.MongoClients
//import com.mongodb.client.MongoCollection
//import com.mongodb.client.MongoDatabase
//import org.bson.Document
//import com.kms.katalon.core.util.KeywordUtil
//
//import internal.GlobalVariable
//
//public class MongoDBHelper {
//
//	@Keyword
//	String getLatestOTP(String phoneNumber) {
//		
//			String mongoUri =
//					"mongodb://${GlobalVariable.userMongoDB}:${GlobalVariable.passMongoDB}@" +
//					"${GlobalVariable.mongoHost}:${GlobalVariable.portMongoDB}/" +
//					"${GlobalVariable.MongoDatabase}?authSource=${GlobalVariable.MongoDatabase}"
//		
//			def client = MongoClients.create(mongoUri)
//		
//			try {
//				MongoDatabase database = client.getDatabase(GlobalVariable.MongoDatabase)
//				MongoCollection<Document> collection =
//						database.getCollection(GlobalVariable.MongoCollection)
//		
//				KeywordUtil.logInfo("Connecting to MongoDB")
//				KeywordUtil.logInfo("DB: ${GlobalVariable.MongoDatabase}")
//				KeywordUtil.logInfo("Collection: ${GlobalVariable.MongoCollection}")
//		
//				Document query = new Document("msisdn", phoneNumber)
//				Document sort = new Document("_modified", -1)
//		
//				Document result = collection.find(query).sort(sort).first()
//		
//				if (result == null) {
//					KeywordUtil.logInfo("⚠️ No OTP found for MSISDN: " + phoneNumber)
//					return null
//				}
//		
//				KeywordUtil.logInfo("✅ Query Result: " + result.toJson())
//		
//				String otp = result.getString("code")
//				KeywordUtil.logInfo("✅ Retrieved OTP: " + otp)
//		
//				return otp
//		
//			} finally {
//				client.close()
//			}
//		}
//
//
//	def String getLatestOTPEmail(String email) {
//		String mongoUri = "mongodb://" + GlobalVariable.userMongoDB + ":" + GlobalVariable.passMongoDB + "@" + GlobalVariable.mongoHost + ":" + GlobalVariable.portMongoDB + "/" + GlobalVariable.MongoDatabase + "?authSource=" + GlobalVariable.MongoDatabase
//
//		def client = MongoClients.create(mongoUri)
//
//		// Select database and collection
//		MongoDatabase database = client.getDatabase(GlobalVariable.MongoDatabase)
//		MongoCollection<Document> collection = database.getCollection(GlobalVariable.MongoCollection)
//
//		KeywordUtil.logInfo("Connecting to MongoDB with URI: " + mongoUri)
//		KeywordUtil.logInfo("Database: " + GlobalVariable.MongoDatabase)
//		KeywordUtil.logInfo("Collection: " + GlobalVariable.MongoCollection)
//
//		String emailQuery = email.toString()
//
//		// Query to fetch the latest OTP
//		Document query = new Document("email", emailQuery)
//		Document sort = new Document("_modified", -1) // Sort by latest entry
//		Document result1 = collection.find(query).sort(sort).first()
//
//		String otp = null
//
//		// ✅ Check if result1 is null before calling toJson()
//		if (result1 != null) {
//			//		KeywordUtil.logInfo("✅ Query Result: " + result1.toJson()) // Safe to call toJson()
//			KeywordUtil.logInfo("Query Result: " + (result1 != null ? result1.toJson() : "No data found")) // ✅ Safe logging
//			otp = result1.getString("code") // Ensure the field name is correct
//			KeywordUtil.logInfo("✅ Retrieved OTP: " + otp)
//		} else {
//			KeywordUtil.logInfo("⚠️ No OTP found for email: " + email)
//		}
//
//
//		// Close connection
//		client.close()
//		return otp
//	}
//
//	def String getOldestOTP(String phoneNumber) {
//		String mongoUri = "mongodb://" + GlobalVariable.userMongoDB + ":" + GlobalVariable.passMongoDB + "@" +
//				GlobalVariable.mongoHost + ":" + GlobalVariable.portMongoDB + "/" +
//				GlobalVariable.MongoDatabase + "?authSource=" + GlobalVariable.MongoDatabase
//
//		def client = MongoClients.create(mongoUri)
//
//		// Select database and collection
//		MongoDatabase database = client.getDatabase(GlobalVariable.MongoDatabase)
//		MongoCollection<Document> collection = database.getCollection(GlobalVariable.MongoCollection)
//
//		KeywordUtil.logInfo("Connecting to MongoDB with URI: " + mongoUri)
//		KeywordUtil.logInfo("Database: " + GlobalVariable.MongoDatabase)
//		KeywordUtil.logInfo("Collection: " + GlobalVariable.MongoCollection)
//
//		// ✅ Query to fetch the oldest OTP (Sort by _id in ascending order)
//		Document query = new Document("msisdn", phoneNumber)
//		Document sort = new Document("_modified", -1) // ✅ Sort by oldest entry : 1
//		Document result = collection.find(query).sort(sort).first()
//
//		// ✅ Ensure result is not null before logging
//		if (result == null) {
//			KeywordUtil.logInfo("⚠️ No OTP found for MSISDN: " + phoneNumber)
//			client.close()
//			return null
//		}
//
//		// ✅ Safe to call toJson() now
//		if (result != null) {
//			KeywordUtil.logInfo("✅ Query Result: " + result.toJson())
//		} else {
//			KeywordUtil.logInfo("⚠️ Query returned null result") // Just extra safety
//		}
//
//		String otp = result.getString("code") // Ensure this matches your field name
//		KeywordUtil.logInfo("✅ Retrieved OTP: " + otp)
//
//		client.close()
//		return otp
//	}
//}
