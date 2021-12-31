package com.example.seckill;

import com.example.seckill.utils.SerializeUtil;
import org.jasig.cas.client.validation.UserInfoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})// 指定启动类
@TestPropertySource("classpath:application.yml")
public class ApplicationTests {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void test() throws Exception {
		for (int i = 0; i < 10000; i++) {
			String result = restTemplate.getForObject("http://localhost:8080/user/process", String.class);
			Thread.sleep(1000);
		}
	}

	@Autowired
	private JedisPool jedispool;
	@Test
	public void test2(){
		Jedis jedis = jedispool.getResource();
		String keys = "name";
		String value = jedis.get(keys);
		System.out.println(value);
		UserInfoImpl p = new UserInfoImpl("7cb12c67fba148b6aacf7cba7f9aa393", "zmc", "zhumincai", "999100", "resjson", "18895356128", "330101199901265452", "机构A名称", "330100", "杭州市");
		jedis.set("SSO_testlogin".getBytes(),  SerializeUtil.serialize(p));
		/*byte[] byt = jedis.get("person".getBytes());
		Object obj = SerializeUtil.unserizlize(byt);
		if (obj instanceof UserInfoImpl) {
			System.out.println(obj);
		}*/


	}



}
