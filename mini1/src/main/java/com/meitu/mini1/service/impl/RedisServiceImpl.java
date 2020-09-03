package com.meitu.mini1.service.impl;

import com.meitu.mini1.entities.Hot;
import com.meitu.mini1.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    private static final String RANK_PREFIX = "global_hot";

    @Override
    public void add(String key, String value, int number) {
        redisTemplate.opsForZSet().add(RANK_PREFIX,value,number);
    }

    @Override
    public List<Hot> getTopNRanks(int n) {
        Set<ZSetOperations.TypedTuple<String>> result = rangeWithScore(RANK_PREFIX, 0, n - 1);
        return buildRedisRankToBizDO(result, 1);
    }

    @Override
    public Set<ZSetOperations.TypedTuple<String>> rangeWithScore(String key, long start, long end) {
        return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
    }

    private List<Hot> buildRedisRankToBizDO(Set<ZSetOperations.TypedTuple<String>> result, long offset) {
        List<Hot> rankList = new ArrayList<>(result.size());
        long rank = offset;
        for (ZSetOperations.TypedTuple<String> sub : result) {
            rankList.add(new Hot(sub.getValue(),sub.getScore()));
        }
        return rankList;
    }
}
