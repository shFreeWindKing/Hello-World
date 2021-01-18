package com.shptchangfeng.eastdemo.dao;

import com.shptchangfeng.eastdemo.po.SysSerialNumber;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@Mapper
@Repository
public interface SysSerialNumberMapper  extends tk.mybatis.mapper.common.Mapper<SysSerialNumber>, MySqlMapper<SysSerialNumber> {
    /**
     * [新增]
     * @author xudongjian
     * @date 2021/01/04
     **/
    int insert(SysSerialNumber sysSerialNumber);

//    /**
//     * [刪除]
//     * @author xudongjian
//     * @date 2020/12/28
//     **/
//    int delete(long id);

    /**
     * [更新]
     * @author xudongjian
     * @date 2021/01/04
     **/
    int update(SysSerialNumber sysSerialNumber);

    /**
     * [查询] 分页查询
     * @author xudongjian
     * @date 2021/01/04
     **/
    List<SysSerialNumber> pageList(int offset, int pagesize);

    /**
     * [查询] 分页查询 count
     * @author xudongjian
     * @date 2021/01/04
     **/
    int pageListCount(int offset,int pagesize);

    /**
     * [查询] 根据主键 id 查询
     * @author xudongjian
     * @date 2020/12/28
     **/
    SysSerialNumber load(long id);
}
