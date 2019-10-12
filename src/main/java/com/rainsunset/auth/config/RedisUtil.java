package com.rainsunset.auth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @version : 1.0
 * @description: Redis工具类
 * @author: 李刚伟
 * @company rainsunset
 * @date: 2019 -10-12
 */
@Slf4j
@Repository
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key the key
     * @return boolean boolean
     * @author : ligangwei / 2019-10-12 4:40:52
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除对应的value
     *
     * @param key the key
     * @author : ligangwei / 2019-10-12 4:40:52
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 批量删除对应的value
     *
     * @param keys the keys
     * @author : ligangwei / 2019-10-12 4:40:52
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern the pattern
     * @author : ligangwei / 2019-10-12 4:40:52
     */
    public void removePattern(final String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

    /**
     * 通过key设置有效期（单位秒）
     *
     * @param key        键
     * @param expireTime 有效时间
     * @author : ligangwei / 2019-10-12 5:40:41
     */
    public void expire(String key, long expireTime) {
        redisTemplate.boundValueOps(key).expire(expireTime, TimeUnit.SECONDS);
    }

    /**
     * String 类型 取
     * 根据 key 获取对应的value 如果key不存在则返回null
     *
     * @param key 查询的key
     * @return 查询结果 string
     * @author : ligangwei / 2019-10-12 5:40:43
     */
    public String get(final String key) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String result = operations.get(key);
        return result;
    }

    /**
     * String 类型 存
     * <p>
     * 设置 key 的值为 value
     * 如果key不存在添加key 保存值为value
     * 如果key存在则对value进行覆盖
     *
     * @param key   key值
     * @param value 存入的value值
     * @return 添加结果 boolean
     * @author : ligangwei / 2019-10-12 5:40:43
     */
    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            ValueOperations<String, String> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * map类型 存
     *
     * 为散列添加多个key-value键值对
     *
     * @param key   key值
     * @param value map值
     * @return 添加结果 boolean
     * @author : ligangwei / 2019-10-12 5:47:16
     */
    public boolean hmset(String key, Map<String, String> value) {
        boolean result = false;
        try {
            HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
            hashOperations.putAll(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 为散列添加或者覆盖一个 key-value键值对
     *
     * @param key    the key
     * @param hkey   the hkey
     * @param hvalue the hvalue
     * @return the boolean
     * @author : ligangwei / 2019-10-12 9:57:55
     */
    public boolean hmadd(String key, String hkey, String hvalue) {
        boolean result = false;
        try {
            HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
            hashOperations.put(key, hkey, hvalue);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * map类型 取
     * 获取散列的key-value键值对集合
     *
     * @param key key值
     * @return 查询结果 map
     * @author : ligangwei / 2019-10-12 5:47:16
     */
    public Map<String, String> hmget(String key) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        Map<String, String> result = hashOperations.entries(key);
        return result;
    }

    /**
     * map类型 取
     * 获取散列的key-value键值对中一个key对应的值
     * @param key  the key
     * @param hkey the hkey
     * @return the string
     * @author : ligangwei / 2019-10-12 10:02:46
     */
    public String hmgethk(String key,String hkey) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        String result = hashOperations.get(key,hkey);
        return result;
    }

    /**
     * list 类型 存
     * 插入数据到list
     *
     * @param key  key值
     * @param list value值
     * @return 添加结果 list
     * @author : ligangwei / 2019-10-12 5:47:16
     */
    public boolean setList(String key, List<String> list) {
        boolean result = false;
        try {
            ListOperations<String, String> listOperations = redisTemplate.opsForList();
            // 从list尾部插入value
            listOperations.rightPushAll(key, list);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * list 类型 取
     *
     * @param key key值
     * @return 查询结果 string
     * @author : ligangwei / 2019-10-12 5:47:16
     */
    public List<String> getList(final String key) {
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        List<String> range = listOperations.range(key, 0L, -1L);
        return range;
    }

    /**
     * list 类型 取对应下标的值
     *
     * @param key   the key
     * @param index the index
     * @return the string
     * @author : ligangwei / 2019-10-12 10:07:34
     */
    public String getListIndex(final String key, Long index) {
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        String result = listOperations.index(key, index);
        if (result == null) {
            return null;
        }
        return result;
    }

    /**
     * set 类型 存
     * 给集合key添加值，集合不存在创建后再添加
     *
     * @param key key值
     * @param set value值
     * @return 添加结果 set
     * @author : ligangwei / 2019-10-12 5:47:16
     */
    public boolean setSet(String key, Set<String> set) {
        boolean result = false;
        try {
            SetOperations<String,String> setOperations = redisTemplate.opsForSet();
            setOperations.add(key, set.toString());
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * set 类型 取
     * 获取所有set值
     *
     * @param key key值
     * @return 查询结果 string
     * @author : ligangwei / 2019-10-12 5:47:16
     */
    public Set<String> getSet(final String key) {
        SetOperations<String,String> setOperations = redisTemplate.opsForSet();
        Set<String> members = setOperations.members(key);
        return members;
    }

    /**
     * ZSet 类型 存
     * 给有序集合添加一个指定分数的成员 如果成员存在则覆盖
     *
     * @param key   key值
     * @param value value值
     * @param score 分数
     * @return 添加结果 z set
     * @author : ligangwei / 2019-10-12 5:47:16
     */
    public boolean setZSet(String key, String value, double score) {
        boolean result = false;
        try {
            ZSetOperations<String,String> zSetOperations = redisTemplate.opsForZSet();
            zSetOperations.add(key, value, score);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * ZSet 类型 取
     * 获取指定范围内数据
     *
     * @param key   the key
     * @param start the start
     * @param end   the end
     * @return 查询数据 set
     * @author : ligangwei / 2019-10-12 5:47:16
     */
    public Set<String> getZSet(final String key, long start, long end) {
        Object result = null;
        ZSetOperations<String,String> zSetOperations = redisTemplate.opsForZSet();
        // 从有序集合中获取指定范围内从高到低的成员集合 获取 value
        result = zSetOperations.reverseRange(key, start, end);
        if (null == result) {
            return null;
        }
        Iterator iterator = ((Set) result).iterator();
        Set<String> zSetValList = new HashSet<>();
        while (iterator.hasNext()) {
            //使用reverseRange 方法获取
            String next = (String) iterator.next();
            zSetValList.add(next);
        }
        return zSetValList;
    }
}
