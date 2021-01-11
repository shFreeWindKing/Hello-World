package com.shptchangfeng.eastdemo.controller;

import com.shptchangfeng.eastdemo.common.utils.ConvertorUtil;
import com.shptchangfeng.eastdemo.dto.DicStaffDTO;
import com.shptchangfeng.eastdemo.model.Result;
import com.shptchangfeng.eastdemo.service.DicStaffService;
import com.shptchangfeng.eastdemo.vo.response.DicStaffRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/query/dics")
@Api(value = "字典信息查询接口",tags = "字典信息查询接口")
public class DicsQueryController {
    @Resource
    private DicStaffService dicStaffService;
    @Resource
    private ConvertorUtil convertor;
    /* 方法注解 */
    @ApiOperation(value = "根据姓名查询人员信息", notes = "支持模糊查询（*）")
    @PostMapping("/staff")
    public Result<List<DicStaffRespVO>> queryStaffInfo(/*参数注解*/ @ApiParam(value = "传入名字", required = true)@RequestParam String name) {
        List<DicStaffDTO> dicStaffList = dicStaffService.getUserInfoByName(name);
        List<DicStaffRespVO> dicStaffRespVOList = this.convertor.convertor(dicStaffList, DicStaffRespVO.class);
        return Result.success(dicStaffRespVOList);
    }
}
