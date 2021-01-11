package com.shptchangfeng.eastdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shptchangfeng.eastdemo.common.utils.ConvertorUtil;
import com.shptchangfeng.eastdemo.model.Result;
import com.shptchangfeng.eastdemo.po.DicStaff;
import com.shptchangfeng.eastdemo.service.DicStaffService;
import com.shptchangfeng.eastdemo.vo.request.DicStaffReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/manage/dics")
@Api(value = "字典信息管理接口",tags = "字典信息管理接口")
@Slf4j
public class DicsManagerController {
    @Resource
    private DicStaffService dicStaffService;
    @Resource
    private ConvertorUtil convertor;

    /* 方法注解 */
    @ApiOperation(value = "保存人员信息")
    @PostMapping("/staff/save")
    public Result<Boolean> saveStaff(/*参数注解*/ @ApiParam(value = "传入人员信息", required = true)@RequestBody @Valid DicStaffReqVO dicStaffReqVO) {
        log.info("======saveStaff param:" + JSONObject.toJSONString(dicStaffReqVO));
        DicStaff dicStaff = null;
        if (null == dicStaffReqVO) {
            log.error("参数不能为空");
        } else {
            dicStaff = this.convertor.convertor(dicStaffReqVO, DicStaff.class);
        }
        Result<Boolean> result = dicStaffService.save(dicStaff);
        return result;
    }
}
