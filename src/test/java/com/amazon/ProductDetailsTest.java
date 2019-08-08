package com.amazon;

import com.amazon.driver.ChromiumDriver;
import com.amazon.pages.ProductDetailsPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDetailsTest {

	private ProductDetailsPage productDetailsPage;

	@Autowired
	ChromiumDriver chromiumDriver;

	@Before
	public void setUpBefore() {
		productDetailsPage = new ProductDetailsPage(chromiumDriver.run());
	}

	@Test
	public void shouldExistAddToCartButton() {
		Assert.assertTrue(productDetailsPage.isAddToCartButtonExist());
	}

	@After
	public void setUpAfter() {
		chromiumDriver.stop();
	}
}
