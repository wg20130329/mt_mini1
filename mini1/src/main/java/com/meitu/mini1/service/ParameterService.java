package com.meitu.mini1.service;


import com.meitu.mini1.dto.ParameterDto;
import com.meitu.mini1.entities.Hot;
import com.meitu.mini1.entities.Parameter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParameterService {

    /**
     * 修改更新周期x小时参数，和返回热词个数K值。只能修改value值，其余不能修改
     * @param parameterDto
     * @return
     */
    public int updateParameter(ParameterDto parameterDto);

    /**
     * 获取所有参数值
     * @return
     */
    List<Parameter> getHotList();

    /**
     * 根据类型获取对应的参数值
      * @param type
     * @return
     */
    String getParaByType(Integer type);
}
