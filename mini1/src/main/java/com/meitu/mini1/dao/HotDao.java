package com.meitu.mini1.dao;


import com.meitu.mini1.dto.HotDto;
import com.meitu.mini1.entities.Hot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface HotDao {
    public int create(Hot hot);

    public Hot getPayment(@Param("name") String name);

    public int updateHot(Hot hot);

    List<HotDto> getHotList(Map map);

    int del(String name);

    List<HotDto> finfHistList();
}
