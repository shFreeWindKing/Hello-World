package com.shptchangfeng.eastdemo.po;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;

/**
 *  全体职工
 * @author xudongjian 2020-12-28
 */
@Data
@Table(name = "dic_staff")
public class DicStaff extends BaseBill implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * name
     */
    @ApiModelProperty(value="姓名")
    private String name;

    /**
     * age
     */
    @ApiModelProperty(value="年龄")
    private int age;

    public DicStaff() {
    }

}