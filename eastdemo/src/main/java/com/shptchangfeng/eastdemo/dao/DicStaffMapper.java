package com.shptchangfeng.eastdemo.dao;

import com.shptchangfeng.eastdemo.po.DicStaff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 接入 tk-mybatis
 *
 */
@Mapper
@Repository
public interface DicStaffMapper extends tk.mybatis.mapper.common.Mapper<DicStaff> {
    /**
     * [新增]
     * @author xudongjian
     * @date 2020/12/28
     **/
    int insert(DicStaff dicStaff);

    /**
     * [刪除]
     * @author xudongjian
     * @date 2020/12/28
     **/
    int delete(int id);

    /**
     * [更新]
     * @author xudongjian
     * @date 2020/12/28
     **/
    int update(DicStaff dicStaff);

    /**
     * [查询] 根据主键 id 查询
     * @author xudongjian
     * @date 2020/12/28
     **/
    DicStaff load(int id);

    /**
     * [查询] 分页查询
     *
     * @author
     * @date 2020/10/23
     **/
    List<DicStaff> pageList(@Param(value = "offset") int offset,@Param(value = "pagesize") int pagesize);

    /**
     * [查询] 分页查询 count
     *
     * @author
     * @date 2020/10/23
     **/
    int pageListCount(@Param(value = "offset") int offset,@Param(value = "pagesize") int pagesize);
}
