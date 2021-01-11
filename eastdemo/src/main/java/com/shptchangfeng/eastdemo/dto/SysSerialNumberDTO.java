package com.shptchangfeng.eastdemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * sys_serial_number
 * @author xudongjian 2021-01-04
 */

@Data
@ApiModel("sys_serial_number")
public class SysSerialNumberDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增长主键")
    private Long id;

    @ApiModelProperty("模块名称")
    private String moduleName;

    @ApiModelProperty("模块/表单编码（唯一的）")
    private String moduleCode;

    @ApiModelProperty("前缀 (使用的序列号模板)")
    private String configTemplet;

    @ApiModelProperty("存放当前序列号的值")
    private Long maxSerial;

    @ApiModelProperty("预生成序列号存放到缓存的个数")
    private Long preMaxNum;

    @ApiModelProperty("是否自动增长模式，0：否 1：是")
    private int isAutoIncrement;

    public SysSerialNumberDTO() {
    }

}