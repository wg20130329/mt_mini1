package com.meitu.mini1.dao;


import com.meitu.mini1.entities.Hot;
import com.meitu.mini1.entities.Parameter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ParameterDao {

    /**
     * 修改参数
     * @param parameter
     * @return
     */
    public int updateParameter(Parameter parameter);

    /**
     * 获取所有参数值
     * @return
     */
    List<Parameter> getHotList();

    /**
     * 通过参数获取类型值
     * @param type
     * @return
     */
    String getParaByType(Integer type);
}
