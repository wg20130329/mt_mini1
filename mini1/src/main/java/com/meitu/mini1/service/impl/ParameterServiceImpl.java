package com.meitu.mini1.service.impl;

import com.meitu.mini1.dao.HotDao;
import com.meitu.mini1.dao.ParameterDao;
import com.meitu.mini1.dto.ParameterDto;
import com.meitu.mini1.entities.Parameter;
import com.meitu.mini1.service.ParameterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParameterServiceImpl  implements ParameterService {

    @Resource
    private ParameterDao parameterDao;

    @Override
    public int updateParameter(ParameterDto parameterDto) {
        Parameter parameter = new Parameter();
        parameter.setParaValue(parameterDto.getParaValue());
        parameter.setParaId(Integer.parseInt(parameterDto.getParaId()));
        return parameterDao.updateParameter(parameter);
    }

    @Override
    public List<Parameter> getHotList() {
        return parameterDao.getHotList();
    }

    @Override
    public String getParaByType(Integer type) {
        return parameterDao.getParaByType(type);
    }
}
