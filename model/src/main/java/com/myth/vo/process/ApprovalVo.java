package com.myth.vo.process;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author may
 */
@Data
public class ApprovalVo {

    private Long processId;

    private String taskId;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "审批描述")
    private String description;
}
