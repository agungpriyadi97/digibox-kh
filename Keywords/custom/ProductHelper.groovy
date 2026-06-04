package custom

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class ProductHelper {

    @Keyword
    def addAnyAvailableProduct() {

        WebUI.waitForElementVisible(
            findTestObject('WEB/Home Page/Search/list_product'),
            15)

        int totalProduct =
            WebUiCommonHelper.findWebElements(
                findTestObject('WEB/Home Page/Search/list_product'),
                15
            ).size()

        WebUI.comment("Total product found : ${totalProduct}")

        boolean productFound = false

        for (int i = 1; i <= totalProduct; i++) {

            try {

                WebUI.comment("Checking product index : ${i}")

                TestObject dynamicProduct = new TestObject()

                dynamicProduct.addProperty(
                    'xpath',
                    ConditionType.EQUALS,
                    "(//div[contains(@class,'sp-plp-card')])[${i}]"
                )

                WebUI.scrollToElement(dynamicProduct, 5)

                WebUI.click(dynamicProduct)

                WebUI.waitForPageLoad(10)

                boolean addToCartExist =
                    WebUI.waitForElementVisible(
                        findTestObject(
                            'Product and Cart/Add to cart/button_Add to Cart'
                        ),
                        5,
                        FailureHandling.OPTIONAL
                    )

                if (addToCartExist) {

                    WebUI.comment("Available product found")

                    WebUI.click(
                        findTestObject(
                            'Product and Cart/Add to cart/button_Add to Cart'
                        )
                    )

                    productFound = true

                    break
                }

                WebUI.comment("Product sold out")

                WebUI.back()

                WebUI.waitForPageLoad(10)

                WebUI.waitForElementVisible(
                    findTestObject('WEB/Home Page/Search/list_product'),
                    10)

            } catch (Exception e) {

                WebUI.comment(
                    "Failed product index ${i} : ${e.getMessage()}"
                )

                try {

                    WebUI.back()

                    WebUI.waitForPageLoad(10)

                } catch (Exception ignored) {
                }
            }
        }

        if (!productFound) {

            WebUI.takeScreenshot()

            KeywordUtil.markFailedAndStop(
                "Tidak ada product available untuk ditambahkan ke cart"
            )
        }
    }
}