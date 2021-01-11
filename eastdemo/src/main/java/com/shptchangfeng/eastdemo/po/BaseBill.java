package com.shptchangfeng.eastdemo.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 *  表单基类
 * @author xudongjian 2020-12-28
 */
@Data
public class BaseBill {
    /**
     * 自增长主键
     */
    @Id
    private Long id;

    @ApiModelProperty(value="表单uuid")
    @Column(columnDefinition = "VARCHAR")
    private String uuid;

    @ApiModelProperty(value="编号/代码")
    @Column(columnDefinition = "VARCHAR")
    private String billNo;

    @ApiModelProperty("创建时间")
    @Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;


    @ApiModelProperty("修改时间")
    @Column(nullable = true, insertable = false, updatable = false, columnDefinition = "TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
    private Date editTime;

    @ApiModelProperty("0 表示正常; 1 表示逻辑删除")
    @Column(columnDefinition = "INTEGER")
    private Integer deleteFlag;

}
