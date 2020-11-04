package com.qf.forum.config.other;
/*
 *   Author = Liewona
 *   Date = 2020/10/13 23:21
 */

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.time.Duration;


@Configuration
public class MyRedisConfig {

    private Duration ttl = Duration.ofSeconds(120);

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory factory) {

//        System.out.println("----------------RedisCacheManager---------------\n\n");
//        System.out.println(getTtl());
        RedisCacheWriter writer = RedisCacheWriter.nonLockingRedisCacheWriter(factory);

//        FastJsonRedisSerializer<Object> serializer = new FastJsonRedisSerializer<>(Object.class);  //使用fastjson序列化

        GenericFastJsonRedisSerializer genericFastJsonRedisSerializer = new GenericFastJsonRedisSerializer();


        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(ttl)
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer())) //使用普通字符串序列化 缓存的key
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(genericFastJsonRedisSerializer));  //使用fastjson序列化缓存的 value值


        return RedisCacheManager.builder(writer)
                .cacheDefaults(cacheConfiguration)
                .build();
    }

    @ConditionalOnMissingBean(name = "redisTemplate")
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

        FastJsonRedisSerializer<Object> serializer = new FastJsonRedisSerializer<>(Object.class);
        GenericFastJsonRedisSerializer genericFastJsonRedisSerializer = new GenericFastJsonRedisSerializer();
//        redisTemplate.setDefaultSerializer(serializer);

        // value使用fastjson序列化
        redisTemplate.setValueSerializer(genericFastJsonRedisSerializer);
        redisTemplate.setHashValueSerializer(genericFastJsonRedisSerializer);


        //key使用普通序字符串列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }


    public Duration getTtl() {
        return ttl;
    }

    public void setTtl(Duration ttl) {
        this.ttl = ttl;
    }
}
