package com.meitu.mini1.service.impl;

import com.meitu.mini1.dto.HotDto;
import com.meitu.mini1.entities.Hot;
import com.meitu.mini1.service.HotService;
import com.meitu.mini1.service.RedisService;
import com.meitu.mini1.service.TackFindAllHot;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TackFindAllHotImpl implements TackFindAllHot {

    private static final String RANK_PREFIX = "global_hot";

    @Resource
    private  HotService hotService;

    @Resource
    private RedisService redisService;

    @Override
    public void dataToRedis() {
        List<HotDto> list = hotService.getHotList();
        if(list !=  null && list.size() > 0){
            for (HotDto hotDto:list) {
                redisService.add(RANK_PREFIX,hotDto.getName(),hotDto.getNumber());
                System.out.println("存到redis成功");
            }
        }
    }
}
