package me._0o0.consumer.service;

//pzhang
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
public class MysqlService {


  private static final Logger LOGGER = LoggerFactory.getLogger(MysqlService.class);

  @Autowired
  protected RedisTemplate redisTemplate;
  @Autowired
  private me._0o0.consumer.dao.UserMapper userMapper;

  @GetMapping("mysql")
  @ResponseStatus(HttpStatus.ACCEPTED)
  @ResponseBody
  public void testmysql() {
      LOGGER.info("测试mysql");
     
      userMapper.insert("AAA", 20);
     // me._0o0.consumer.dao.User u = userMapper.findByName("AAA");
  }
}
