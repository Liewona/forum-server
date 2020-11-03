package com.qf.forum;

import com.qf.forum.utils.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@ComponentScan(basePackages = {"com.qf.forum.config.other"})
@SpringBootTest
class ForumServerApplicationTests {

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Test
    void contextLoads() {
//        System.out.println(StringUtils.upPath);

        redisTemplate.opsForValue().set("xjs", "哈哈哈我是熊劲松");
        System.out.println(redisTemplate.opsForValue().get("xjs"));

    }

}
