package com.shptchangfeng.eastdemo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BasePageDTO {

    @ApiModelProperty(value = "当前页", example = "1")
    private int pageNum = 1;

    @ApiModelProperty(value = "每页显示数", example = "10")
    private int pageSize = 10;

    @ApiModelProperty(value = "排序方式", example = "desc")
    private String order = "desc";
}
