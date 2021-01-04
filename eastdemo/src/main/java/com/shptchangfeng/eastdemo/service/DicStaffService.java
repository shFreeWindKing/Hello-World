package com.shptchangfeng.eastdemo.service;

import com.shptchangfeng.eastdemo.dto.DicStaffDTO;
import com.shptchangfeng.eastdemo.po.DicStaff;
import com.shptchangfeng.eastdemo.model.Result;

import java.util.List;
import java.util.Map;


/**
 * 全体职工
 * @author xudongjian
 * @date 2020/12/28
 */
public interface DicStaffService {

    /**
     * 新增
     */
    public Result<Boolean> insert(DicStaff dicStaff);
//
//    /**
//     * 删除
//     */
//    public Result<Boolean> delete(int id);
//

    /**
     * 更新
     */
    public Result<Boolean> update(DicStaff dicStaff);

    /**
     * 保存
     */
    public Result<Boolean> save(DicStaff dicStaff);

//    /**
//     * 根据主键 id 查询
//     */
//    public DicStaff load(int id);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);


    public DicStaffDTO getUserInfo(Long id);

    public List<DicStaffDTO> getUserInfoByName(String name);
}