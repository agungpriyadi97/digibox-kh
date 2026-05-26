package custom

import com.kms.katalon.core.annotation.Keyword
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Random

class RandomData {

	Random rand = new Random()

	@Keyword
	def generateRandomEmail() {
		String letters = ('a'..'z').join()
		Random rand = new Random()

		String randomSuffix = (1..3).collect {
		letters[rand.nextInt(letters.length())]
	}.join()

	return "agungpriyadi" + randomSuffix + "@gmail.com"
}

	@Keyword
	def generateRandomUsername() {
		int randomNum = rand.nextInt(9999)
		return "agung" + System.currentTimeMillis().toString().substring(7) + randomNum
	}

	@Keyword
	def generateRandomFirstName() {
		String[] firstNames = ["Agung", "Budi", "Rina", "Sinta", "Dewi"]
		return firstNames[rand.nextInt(firstNames.length)]
	}

	@Keyword
	def generateRandomLastName() {
		String[] lastNames = ["Priyadi", "Santoso", "Wijaya", "Saputra", "Putri"]
		return lastNames[rand.nextInt(lastNames.length)]
	}

	@Keyword
	def generateRandomAddress() {
		int randomNum = rand.nextInt(9999)
		return "Jakarta Testing " + randomNum
	}

	@Keyword
	def generateRandomPhone() {
		int randomNum = 100000000 + rand.nextInt(899999999)
		return "08" + randomNum
	}
	
	@Keyword
	def generateRandomCode() {
		int randomNum = rand.nextInt(10)
		return "15810" + randomNum
}
}