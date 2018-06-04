package com.sreeraj.redistest.RedisTest;

import com.sreeraj.redistest.RedisTest.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.validation.Valid;

@SpringBootApplication
public class RedisTestApplication {

//	@Value("${}")
//	private String hostName;

	public static void main(String[] args) {
		SpringApplication.run(RedisTestApplication.class, args);
	}


	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName("localhost");
		jedisConnectionFactory.setPort(6379);
		return jedisConnectionFactory;
	}

	@Bean
	public RedisTemplate<String, Employee> redisTemplate () {
		RedisTemplate<String, Employee>	redisTemplate = new RedisTemplate<>();
		//redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return  redisTemplate;
 	}
}
