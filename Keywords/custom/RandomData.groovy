package custom

import com.kms.katalon.core.annotation.Keyword
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Random

class RandomData {

	@Keyword
	def generateRandomEmail() {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
		return "agung.priyadi+" + timestamp + "@gtech.digital"
	}

	@Keyword
	def generateRandomUsername() {
		Random rand = new Random()
		int randomNum = rand.nextInt(9999)
		return "agung" + System.currentTimeMillis().toString().substring(7) + randomNum
	}
}