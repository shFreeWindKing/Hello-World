package com.shptchangfeng.eastdemo.po;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Table;
import java.util.Date;

/**
 *  sys_serial_number
 * @author xudongjian 2021-01-04
 */
@Data
@Table(name = "sys_serial_number")
public class SysSerialNumber implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增长主键
     */
    @ApiModelProperty("自增长主键")
    private Long id;

    /**
     * 模块名称
     */
    @ApiModelProperty("模块名称")
    private String moduleName;

    /**
     * 模块/表单编码（唯一的）
     */
    @ApiModelProperty("模块/表单编码（唯一的）")
    private String moduleCode;

    /**
     * 前缀 (使用的序列号模板)
     */
    @ApiModelProperty("前缀 (使用的序列号模板)")
    private String configTemplet;

    /**
     * 存放当前序列号的值
     */
    @ApiModelProperty("存放当前序列号的值")
    private Long maxSerial;

    /**
     * 预生成序列号存放到缓存的个数
     */
    @ApiModelProperty("预生成序列号存放到缓存的个数")
    private Long preMaxNum;

    /**
     * 是否自动增长模式，0：否 1：是
     */
    @ApiModelProperty("是否自动增长模式，0：否 1：是")
    private int isAutoIncrement;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date editTime;

    /**
     * 删除标志: 0 表示正常; 1 表示逻辑删除
     */
    @ApiModelProperty("删除标志: 0 表示正常; 1 表示逻辑删除")
    private int deleteFlag;

    public SysSerialNumber() {
    }

    public SysSerialNumber(Long id){
        this.id = id;
    }

    public  SysSerialNumber(Long id, String moduleCode){
        this.id = id;
        this.moduleCode = moduleCode;
    }
}
