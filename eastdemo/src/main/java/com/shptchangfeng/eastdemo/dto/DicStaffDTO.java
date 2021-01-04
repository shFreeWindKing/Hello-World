package com.shptchangfeng.eastdemo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DicStaffDTO extends BasePageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表单唯一值")
    private Long id;

    @ApiModelProperty(value="表单uuid")
    private String uuid;

    @ApiModelProperty(value="编号/代码")
    private String billNo;

    @ApiModelProperty(value="姓名")
    private String name;

    @ApiModelProperty(value="年龄")
    private int age;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date editTime;

    @ApiModelProperty("0 表示正常; 1 表示逻辑删除")
    private Integer deleteFlag;
}
