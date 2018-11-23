package com.yumei.common.utils;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.yumei.common.utils.consts.RedisConsts;

/**
 * Redis工具类。<br>
 * 【备考】此处采用spring提供的redisTemplate实现功能。
 * 
 * @author Tei
 * @Date 2018年11月18日
 */
@Component
public class RedisUtil {

	/** redisTemplate */
	private static RedisTemplate<Object, Object> redisTemplate;

	/**
	 * 设置 redisTemplate
	 *
	 * @param redisTemplate redisTemplate
	 */
	@Autowired
	public void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
		RedisUtil.redisTemplate = redisTemplate;
	}

	
	/**
	 * 写入缓存<br>
	 * [备考]默认缓存1分钟
	 * 
	 * @param key   缓存key
	 * @param value 缓存value
	 * @return 保存结果
	 */
	public static boolean set(String key, Object value) {
		
		return set(key, value, RedisConsts.EXPIRE_TIME);
	}
	
	
	/**
	 * 写入缓存
	 * 
	 * @param key   缓存key
	 * @param value 缓存value
	 * @param time 缓存时间
	 * @return 保存结果
	 */
	public static boolean set(String key, Object value, long time) {
		boolean result = false;
		try {
			// 获取key-value模板
			ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
			// 保存key-value
			operations.set(key, value);
			// 设置保存时间
			redisTemplate.expire(key, time, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 根据key获取value
	 * 
	 * @param key 缓存key
	 * @return 缓存value
	 */
	public static Object get(String key) {
		Object object = redisTemplate.opsForValue().get(key);
		return object;
	}
	
}
