package com.meitu.mini1.controller;

import com.meitu.mini1.common.CommonResult;
import com.meitu.mini1.dto.ParameterDto;
import com.meitu.mini1.entities.Hot;
import com.meitu.mini1.entities.Parameter;
import com.meitu.mini1.service.ParameterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class ParameterController {

    @Resource
    private ParameterService parameterService;

    /**
     * 修改参数
     * @param parameterDto
     * @return
     */
    @PostMapping(value ="/parameter/create")
    public CommonResult create(ParameterDto parameterDto){
        int result = parameterService.updateParameter(parameterDto);
        if (result > 0) {
            log.info("修改参数成功！");
            return  new CommonResult(1,"插入成功" ,result);
        }else{
            log.info("修改参数失败！");
            return new CommonResult(0,"插入失败",null);
        }
    }


    /**
     * 查询所有参数
     * @return
     */
    @GetMapping(value ="/parameter/list")
    public CommonResult<List> getHotList(){
        List<Parameter> result = parameterService.getHotList();
        if (result !=  null) {
            log.info("查询集合成功");
            return  new CommonResult(1,"查询集合成功" ,result);
        }else{
            log.info("查询集合失败");
            return new CommonResult(0,"查询集合失败",null);
        }

    }
}
