package com.meitu.mini1.service.impl;


import com.meitu.mini1.dao.HotDao;
import com.meitu.mini1.dto.HotDto;
import com.meitu.mini1.entities.Hot;
import com.meitu.mini1.entities.Parameter;
import com.meitu.mini1.service.HotService;
import com.meitu.mini1.service.ParameterService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class HotServiceImpl implements HotService {

    @Resource
    private HotDao hotDao;

    @Resource
    private ParameterService parameterService;

    /**
     * 热词添加
     * @param name
     * @return
     */
    public int create(String name){
        // 根据名称先判断是否存在
        Hot hot = getHot(name);
        if(hot == null){
            // 如果没有存在添加一直数据
            hot = new Hot();
            hot.setName(name);
            hot.setNumber(0.0);
            return hotDao.create(hot);
        }else{
            // 如果存在就修改数量
            double number = hot.getNumber() + 1;
            hot.setNumber(number);
            return hotDao.updateHot(hot);
        }


    }

    /**
     * 通过名字查找
     * @param name
     * @return
     */
    public Hot getHot(@Param("name")String name){
        return hotDao.getPayment(name);
    }

    @Override
    public List<HotDto> getHotList() {
        int line = 0; // 返回个数
        int time = 0; // 更新周期X小时
        // 获取所有参数配置，遍历参数如果类型1为更新周期x小时，如果类型2为热词数量
        List<Parameter> list = parameterService.getHotList();
        for (Parameter para :list) {
            if("1".equals(para.getParaType())){
                time = Integer.parseInt(para.getParaValue());
            } else if ("2".equals(para.getParaType())) {
                line =   Integer.parseInt(para.getParaValue());
            }
        }
        Map map = new HashMap<String,Integer>();
        map.put("line",line);
        map.put("time",time);
        return hotDao.getHotList(map);
    }

    @Override
    public int del(String name) {
        return hotDao.del(name);
    }

    @Override
    public List<HotDto> finfHistList() {
        return hotDao.finfHistList();
    }
}
