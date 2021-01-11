package com.shptchangfeng.eastdemo.service.impl;

import com.shptchangfeng.eastdemo.common.utils.ConvertorUtil;
import com.shptchangfeng.eastdemo.common.utils.DateUtil;
import com.shptchangfeng.eastdemo.common.utils.GeneratorUtil;
import com.shptchangfeng.eastdemo.dao.DicStaffMapper;
import com.shptchangfeng.eastdemo.dto.DicStaffDTO;
import com.shptchangfeng.eastdemo.model.Result;
import com.shptchangfeng.eastdemo.po.DicStaff;
import com.shptchangfeng.eastdemo.service.DicStaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;

/**
 * 全体职工
 * @author xudongjian
 * @date 2020/12/28
 */
@Service
@Slf4j
public class DicStaffServiceImpl implements DicStaffService {

    @Resource
    private DicStaffMapper dicStaffMapper;
    @Autowired
    private ConvertorUtil convertor;

    @Override
    public Result<Boolean> insert(DicStaffDTO dicStaffDTO) {
        // valid
        if (dicStaffDTO == null) {
            return Result.error("必要参数缺失");
        }
        DicStaff dicStaff = this.convertor.convertor(dicStaffDTO, DicStaff.class);
        // 删除标识必须设置为0
        dicStaff.setDeleteFlag(0);
        if (null == dicStaff.getCreateTime()) {
            dicStaff.setCreateTime(DateUtil.getNow());
        }
        if (null == dicStaff.getEditTime()) {
            dicStaff.setEditTime(DateUtil.getNow());
        }
        if (null == dicStaff.getUuid() || dicStaff.getUuid().isEmpty()) {
            String uuid = GeneratorUtil.getRandomUUID();
            dicStaff.setUuid(uuid);
        }
        dicStaffMapper.insert(dicStaff);
        return Result.success();
    }

    /**
     * 更新
     *
     * @param dicStaffDTO
     */
    @Override
    public Result<Boolean> update(DicStaffDTO dicStaffDTO) {
        // valid
        if (dicStaffDTO == null) {
            return Result.error("必要参数缺失");
        }
        DicStaff dicStaff = this.convertor.convertor(dicStaffDTO, DicStaff.class);
        dicStaffMapper.update(dicStaff);
        return Result.success();
    }

    @Override
    public Result<Boolean> save(DicStaffDTO dicStaffDTO) {
        long id = dicStaffDTO.getId();
        if (id <= 0) {
            return insert(dicStaffDTO);
        } else {
            return update(dicStaffDTO);
        }
    }

    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {
        log.info("==========getUserInfoByName param:" + offset + ";" + pagesize);
        List<DicStaff> pageList = dicStaffMapper.pageList(offset, pagesize);
        List<DicStaffDTO> dicStaffDTO = this.convertor.convertor(pageList, DicStaffDTO.class);
        int totalCount = dicStaffMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", dicStaffDTO);
        result.put("totalCount", totalCount);

        return result;
    }

//    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class,timeout = 10)
    @Override
    public DicStaffDTO getUserInfo(Long id) {
        log.info("==========getUserInfoByName param:" + id);
        DicStaff dicStaff = dicStaffMapper.selectByPrimaryKey(id);
        DicStaffDTO dicStaffDTO = this.convertor.convertor(dicStaff, DicStaffDTO.class);
        return dicStaffDTO;
    }

    @Override
    public List<DicStaffDTO> getUserInfoByName(String name) {
        log.info("==========getUserInfoByName param:" + name);
        if (name.isEmpty()) {
            return new ArrayList<DicStaffDTO>();
        }
        Example example = new Example(DicStaff.class);
        example.orderBy("name");
        Example.Criteria criteria = example.createCriteria();
        if (name.equalsIgnoreCase("?") || name.equalsIgnoreCase("*")) {
            //全量查找
        } else {
            criteria.andLike("name", "%".concat(name).concat("%"));
        }
        List<DicStaff> dicStaffList = dicStaffMapper.selectByExample(example);

        List<DicStaffDTO> dicStaffDTOList = this.convertor.convertor(dicStaffList, DicStaffDTO.class);
        return dicStaffDTOList;
    }
}