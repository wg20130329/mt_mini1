package com.meitu.mini1.controller;

import com.meitu.mini1.common.CommonResult;
import com.meitu.mini1.dto.HotDto;
import com.meitu.mini1.entities.Hot;
import com.meitu.mini1.service.HotService;
import com.meitu.mini1.service.ParameterService;
import com.meitu.mini1.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class HotController {

    @Resource
    private HotService hotService;

    @Resource
    private RedisService redisService;

    @Resource
    private ParameterService parameterService;


    /**
     * 新增热词
     * @param name
     * @return
     */
    @PostMapping(value ="/hot/create")
    public CommonResult create(@RequestParam("name") String name){
        int result = hotService.create(name);
        if (result > 0) {
            log.info("插入成功！");
            return  new CommonResult(1,"插入成功" ,result);
        }else{
            log.info("插入失败！");
            return new CommonResult(0,"插入失败",null);
        }
    }

    /**
     * 通过名称查询单个热词
     * @param name
     * @return
     */
    @GetMapping(value ="/hot/get")
    public CommonResult<Hot>  getHot(@RequestParam("name") String name){
        Hot result = hotService.getHot(name);
        log.info("tongo");
        if (result !=  null) {
            return  new CommonResult(1,"查询单个成功",result);
        }else{
            return new CommonResult(0,"查询单个失败",null);
        }

    }

    /**
     * 查询自定义的热词个数
     * @return
     */
    @GetMapping(value ="/hot/list")
    public CommonResult<Hot>  getHotList(){
        // 查询redis
//        int num = Integer.parseInt(parameterService.getParaByType(2));
//        List<Hot> result = redisService.getTopNRanks(num);
        List<HotDto> result = hotService.getHotList();
        if (result !=  null) {
            log.info("查询集合成功");
            return  new CommonResult(1,"查询集合成功" ,result);
        }else{
            log.info("查询集合失败");
            return new CommonResult(0,"查询集合失败",null);
        }

    }

    /**
     * 删除热词
     * @param dto
     * @return
     */
    @PostMapping(value ="/hot/del")
    public CommonResult del(HotDto dto){
        int result = hotService.del(dto.getName());
        if (result > 0) {
            log.info("删除成功！");
            return  new CommonResult(1,"删除成功" ,result);
        }else{
            log.info("删除失败！");
            return new CommonResult(0,"删除失败",null);
        }
    }

    /**
     * 查询所有搜索记录
     * @return
     */
    @GetMapping(value ="/hot/histList")
    public CommonResult<Hot>  finfHistList(){
        List<HotDto> result = hotService.finfHistList();
        if (result !=  null) {
            log.info("查询集合成功");
            return  new CommonResult(1,"查询集合成功" ,result);
        }else{
            log.info("查询集合失败");
            return new CommonResult(0,"查询集合失败",null);
        }

    }
}
