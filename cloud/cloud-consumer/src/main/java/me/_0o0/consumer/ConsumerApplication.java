package me._0o0.consumer;
//pzhang
import lombok.extern.slf4j.Slf4j;
import me._0o0.common.Message;
import me._0o0.consumer.dao.UserMapper;
import me._0o0.consumer.service.InputMessageService;
import me._0o0.consumer.service.RedisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.data.redis.core.RedisTemplate;



@Slf4j
@EnableBinding(InputMessageService.class)
@SpringBootApplication

public class ConsumerApplication {
	 @Autowired
	  protected RedisTemplate redisTemplate;
	 @Autowired
	  protected UserMapper userMapper;
	 int i=100;
	 
	public static void main(String[] args) {
		new SpringApplicationBuilder(ConsumerApplication.class).run(args);
	}
	
	@StreamListener("message-in")
	public void handleMessage(Message msg) {
		log.info("Receive message: [{}]", msg);
		
		
		redisTemplate.opsForValue().set("redis",msg.toString());
		userMapper.insert("AAA", i++);
		
	}
}