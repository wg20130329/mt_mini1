package com.meitu.mini1.service;

import com.meitu.mini1.entities.Hot;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.List;
import java.util.Set;

public interface RedisService {
    /**
     * 保存一个热词的数据到redis
     * @param key
     * @param value
     * @param number
     */
    public void add(String key, String value, int number);

    /**
     * 获取前n名的排行榜数据
     *
     * @param n
     * @return
     */
    public List<Hot> getTopNRanks(int n);

    /**
     * 查询集合中指定顺序的值和score，0, -1 表示获取全部的集合内容
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<ZSetOperations.TypedTuple<String>> rangeWithScore(String key, long start, long end);
}
