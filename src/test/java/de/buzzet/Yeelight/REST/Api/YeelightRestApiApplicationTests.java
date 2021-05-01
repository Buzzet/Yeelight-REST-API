package de.buzzet.Yeelight.REST.Api;

import de.buzzet.Yeelight.REST.Api.Services.YeelightService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YeelightRestApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testConnection(){
		YeelightService service1 = new YeelightService();
		YeelightService service2 = new YeelightService();
		service1.set("192.168.0.50", 55443);
		service2.set("192.168.0.91", 55443);
		service1.setPower("off", 30);
		service2.setPower("off", 30);
	}

}
