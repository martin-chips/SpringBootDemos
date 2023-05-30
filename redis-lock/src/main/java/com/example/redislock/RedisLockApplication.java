package com.example.redislock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Redis实现分布式锁的两种方法：
 * 1. SetNX+Redis Lua实现加锁和释放锁。
 *  使用set命令完成设置过期时间+不存在的时候设置值。set key value nx px XXXX， value可设置为随机值，并且在删除的时候判断一下，防止业务代码执行时间超过锁时间，导致释放锁的时候会出现释放了其他锁的情况。
 *
 * 2。 Redisson+RedLock实现
 */
@SpringBootApplication
@Slf4j
@RestController
public class RedisLockApplication {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private DefaultRedisScript<Long> script;

    @PostConstruct
    public void init() {
        script = new DefaultRedisScript<>();
        script.setResultType(Long.class);
        script.setScriptSource(new ResourceScriptSource(new ClassPathResource("lock.lua")));
    }


    public static void main(String[] args) {
        SpringApplication.run(RedisLockApplication.class, args);
    }


    @PostMapping("user")
    public String createUser(@RequestBody User user) {
        String key = "redis-key-" + user.getName();
        String value = UUID.randomUUID().toString();
        // setIfAbsent <=> SET key value [NX] [XX] [EX <seconds>] [PX [millseconds]]
        Boolean flag = redisTemplate.opsForValue().setIfAbsent(key, value, 20000, TimeUnit.MILLISECONDS);
        if (flag) {
            try {
                log.info("lock success,key is {}", key);
                Thread.sleep(1000 * 10);
            } catch (Exception ignore) {
                log.debug("ignore exception {}", ignore.getMessage());
            } finally {
                // need check the value, in case of the lock been unlocked by other thread.
                String valueInRedis = redisTemplate.opsForValue().get(key);
                if (Objects.equals(value, valueInRedis)) {
//                    redisTemplate.delete(key);
                    List<String> keys = new ArrayList<>();
                    keys.add(key);
                    Long execute = redisTemplate.execute(script, keys, valueInRedis);
                    log.info("unlock result {}.", execute);
                }
                log.info("unlock success,key is {}", key);
            }
            return "success";
        } else {
            log.error("get lock {} failed!", key);
            return "please try again later!";
        }

    }
}
