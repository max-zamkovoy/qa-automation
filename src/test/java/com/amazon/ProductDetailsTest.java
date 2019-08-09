package com.amazon;

import com.amazon.driver.ChromiumDriver;
import com.amazon.pages.ProductDetailsPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDetailsTest {

	private static ProductDetailsPage productDetailsPage;
	private static ChromiumDriver chromiumDriver;

	@BeforeClass
	public static void setUpBefore() {
		chromiumDriver = new ChromiumDriver();
		productDetailsPage = new ProductDetailsPage(chromiumDriver.run());
	}

	@Test
	public void shouldExistAddToCartButton() {
		productDetailsPage.getAddToCardButton();
	}

	@AfterClass
	public static void setUpAfter() {
		chromiumDriver.stop();
	}
}
