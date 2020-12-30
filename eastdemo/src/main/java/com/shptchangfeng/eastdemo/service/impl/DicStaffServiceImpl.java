package com.shptchangfeng.eastdemo.service.impl;

import com.shptchangfeng.eastdemo.dao.DicStaffMapper;
import com.shptchangfeng.eastdemo.model.Result;
import com.shptchangfeng.eastdemo.po.DicStaff;
import com.shptchangfeng.eastdemo.service.DicStaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 全体职工
 * @author xudongjian
 * @date 2020/12/28
 */
@Service
public class DicStaffServiceImpl implements DicStaffService {

    @Resource
    private DicStaffMapper dicStaffMapper;

    @Override
    public Result<Boolean> insert(DicStaff dicStaff) {

        // valid
        if (dicStaff == null) {
            return Result.error("必要参数缺失");
        }

        dicStaffMapper.insert(dicStaff);
        return Result.success();
    }

    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {

        List<DicStaff> pageList = dicStaffMapper.pageList(offset, pagesize);
        int totalCount = dicStaffMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return result;
    }

//    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout = 10)
    @Override
    public DicStaff getUserInfo(Long id) {
        return dicStaffMapper.selectByPrimaryKey(id);
    }

}