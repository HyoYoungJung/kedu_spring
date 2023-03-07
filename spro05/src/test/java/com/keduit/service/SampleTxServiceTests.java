package com.keduit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class SampleTxServiceTests {

	@Setter(onMethod_ = @Autowired)
	private SampleTxService service;

	@Test
	public void testLong() {
		String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
				+ "Egestas fringilla phasellus faucibus scelerisque eleifend donec pretium "
				+ "vulputate sapien. Pretium nibh ipsum consequat nisl. Viverra ipsum nunc "
				+ "aliquet bibendum enim facilisis. Sed felis eget velit aliquet sagittis id. "
				+ "Quam pellentesque nec nam aliquam sem et tortor. "
				+ "Pellentesque elit eget gravida cum sociis natoque.";
			log.info("글자의 길이는? " + str.getBytes().length);
			
			service.addData(str);
	}
	



}
