package com.meitu.mini1.service;


import com.meitu.mini1.dto.HotDto;
import com.meitu.mini1.entities.Hot;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotService {
    /**
     * 保存搜索和维护热搜词
     * 用户搜索的时候如果第一次查询添加一次，如果已经存在数量+1
     * 管理维护查看今日热搜词，如果已经存在不能添加，没有新增一条，数量默认为0
     * @param name 名称
     * @return
     */
    public int create(String name );

    /**
     * 通过名称查询是否已经存在
     * @param name 名称
     * @return
     */
    public Hot getHot(@Param("name") String name);

    /**
     *通过最后更新时间获取过去x小时，并且返回设定好的k值个数热搜词
     * @return
     */
    public List<HotDto> getHotList();

    /**
     * 管理后台根据名称主键删除今日热搜词
     * @param name
     * @return
     */
    public int del(String name);

    /**
     * 查询热搜查询历史记录，根据最新更新时间返回记录
     * @return
     */
    public List<HotDto> finfHistList();
}
