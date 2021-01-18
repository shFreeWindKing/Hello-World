package com.shptchangfeng.eastdemo.service;

import com.shptchangfeng.eastdemo.dto.SysSerialNumberDTO;
import com.shptchangfeng.eastdemo.model.Result;
import com.shptchangfeng.eastdemo.po.SysSerialNumber;
import java.util.Map;

/**
 * sys_serial_number
 * @author xudongjian
 * @date 2021/01/04
 */
public interface SysSerialNumberService {

    /**
     * 新增
     */
    public Result<String> insert(SysSerialNumberDTO sysSerialNumber);

//    /**
//     * 删除
//     */
//    public Result<String> delete(long id);

    /**
     * 更新
     */
    public Result<String> update(SysSerialNumberDTO sysSerialNumber);

    /**
     * 根据主键 id 查询
     */
    public Result<SysSerialNumberDTO> load(long id);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

    /**
     * 根据模块代码生成新的流水号
     * @param modelCode 模块编码
     * @return
     */
    public String generateNumberByModelCode(String modelCode);

    /**
     * 根据模块编码获得编码参数对象
     * @param modelCode 模块编码
     * @return
     */
    public Result<SysSerialNumberDTO> findByModelCode(String modelCode);
}
