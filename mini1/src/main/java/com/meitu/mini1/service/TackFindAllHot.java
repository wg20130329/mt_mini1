package com.meitu.mini1.service;

public interface TackFindAllHot {

    /**
     * 根据设定好的更新周期进行查询热词数据存储到redis
     */
    void dataToRedis();
}
