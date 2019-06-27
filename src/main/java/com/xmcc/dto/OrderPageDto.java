package com.xmcc.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ApiModel("分页实体类")
public class OrderPageDto {

    @NotNull(message = "微信号不能为空")
    @ApiModelProperty(value = "微信号",dataType = "String")
    private Integer openid ;

    @NotNull(message = "开始页不能为空")
    @ApiModelProperty(value = "从第0页开始",dataType = "Integer")
    private Integer page = 0;

    @NotNull(message = "分页不能为空")
    @ApiModelProperty(value = "每页显示数量",dataType = "Integer")
    private Integer size = 10;
}
