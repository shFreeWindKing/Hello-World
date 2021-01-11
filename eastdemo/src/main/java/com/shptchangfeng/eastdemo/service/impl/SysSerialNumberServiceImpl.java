package com.shptchangfeng.eastdemo.service.impl;

import com.shptchangfeng.eastdemo.common.utils.ConvertorUtil;
import com.shptchangfeng.eastdemo.dao.SysSerialNumberMapper;
import com.shptchangfeng.eastdemo.dto.SysSerialNumberDTO;
import com.shptchangfeng.eastdemo.model.Result;
import com.shptchangfeng.eastdemo.po.SysSerialNumber;
import com.shptchangfeng.eastdemo.service.SysSerialNumberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * sys_serial_number
 * @author xudongjian
 * @date 2021/01/04
 */
@Service
@Slf4j
public class SysSerialNumberServiceImpl implements SysSerialNumberService {

    @Resource
    private SysSerialNumberMapper sysSerialNumberMapper;
    @Autowired
    private ConvertorUtil convertor;


    @Override
    public Result<String> insert(SysSerialNumberDTO sysSerialNumberDTO) {
        // valid
        if (sysSerialNumberDTO == null) {
            return Result.error("必要参数缺失");
        }
        SysSerialNumber sysSerialNumber = this.convertor.convertor(sysSerialNumberDTO, SysSerialNumber.class);
        sysSerialNumberMapper.insert(sysSerialNumber);
        return Result.success();
    }


    @Override
    public Result<String> delete(long id) {
        int ret = sysSerialNumberMapper.delete(id);
        return ret>0 ? Result.success() : Result.error("不存在id:" + id);
    }


    @Override
    public Result<String> update(SysSerialNumberDTO sysSerialNumberDTO) {
        SysSerialNumber sysSerialNumber = this.convertor.convertor(sysSerialNumberDTO, SysSerialNumber.class);
        int ret = sysSerialNumberMapper.update(sysSerialNumber);
        return ret>0 ? Result.success() : Result.error("更新失败.");
    }


    @Override
    public Result<SysSerialNumberDTO> load(long id) {
        SysSerialNumber sysSerialNumber = sysSerialNumberMapper.load(id);
        SysSerialNumberDTO sysSerialNumberDTO = this.convertor.convertor(sysSerialNumber, SysSerialNumberDTO.class);
        return  Result.success(sysSerialNumberDTO);
    }


    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {

        List<SysSerialNumber> pageList = sysSerialNumberMapper.pageList(offset, pagesize);
        int totalCount = sysSerialNumberMapper.pageListCount(offset, pagesize);
        List<SysSerialNumberDTO> sysSerialNumberDTOList = this.convertor.convertor(pageList, SysSerialNumberDTO.class);
        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", sysSerialNumberDTOList);
        result.put("totalCount", totalCount);

        return result;
    }

    /**
     * 根据模块代码生成新的流水号
     *
     * @param modelCode 模块编码
     * @return
     */
    @Override
    public String generateNumberByModelCode(String modelCode) {
        return null;
    }

    /**
     * 根据模块编码获得编码参数对象
     *
     * @param modelCode 模块编码
     * @return
     */
    @Override
    public Result<SysSerialNumberDTO> findByModelCode(String modelCode) {
        if (modelCode.isEmpty()) {
            return Result.error("必要参数缺失");
        }
        Example example = new Example(SysSerialNumber.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("moduleCode", modelCode);
        SysSerialNumber sysSerialNumber = sysSerialNumberMapper.selectOneByExample(example);
        if(null != sysSerialNumber) {
            return Result.success(this.convertor.convertor(sysSerialNumber, SysSerialNumberDTO.class));
        } else {
            return Result.error("未查到模块编码为" + modelCode + "的记录.");
        }
    }

}
