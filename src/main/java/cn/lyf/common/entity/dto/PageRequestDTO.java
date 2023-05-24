package cn.lyf.common.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author liuyangfang
 * @description 分页请求的传输对象
 * @since 2023/5/24 10:28:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "PageRequestDTO", description = "分页请求的传输对象")
public class PageRequestDTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 当前页码，默认值为1
     */
    @ApiModelProperty("当前页码，默认值为1")
    private Long page = 1L;

    /**
     * 每页显示的行，默认值为10
     */
    @ApiModelProperty("每页显示的行，默认值为10")
    private Long size = 10L;

    /**
     * 请求体实体对象
     */
    @ApiModelProperty("请求体实体对象")
    private T body;

}
