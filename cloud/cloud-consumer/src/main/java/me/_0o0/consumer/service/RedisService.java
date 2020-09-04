package me._0o0.consumer.service;
//pzhang
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

 
@RestController
public class RedisService {
 
 
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    protected RedisTemplate redisTemplate;
 
 
    @GetMapping("redis")
	@ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public String testredis() {
        LOGGER.info("测试redis");
       
        // String redisSet = "hello";
        //redisTemplate.opsForValue().set("redisSet",redisSet);
		/*
		 * UserInfo user = new UserInfo(); user.setUserId(userId);
		 * ResponseEntity<UserInfo> entity =
		 * restTemplate.postForEntity("http://JINZHU-SERVICE-PRODUCER/userinfo/get",
		 * user, UserInfo.class, new Object[]{}); SuccessMessage message = new
		 * SuccessMessage(); UserInfo userInfo = entity.getBody();
		 */
        String obj = (String) redisTemplate.opsForValue().get("redis");
		/*
		 * userInfo.setUserName(obj.toString()); message.setData(userInfo);
		 */
        return obj;
    }
}



