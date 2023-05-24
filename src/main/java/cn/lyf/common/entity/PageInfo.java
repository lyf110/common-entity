package cn.lyf.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


/**
 * @author liuyangfang
 * @description 分页相关的封装对象
 * @since 2023/5/24 10:19:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "PageInfo", description = "分页相关的封装对象")
public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 当前页码
     */
    @ApiModelProperty("当前页码")
    private Long page;

    /**
     * 每页显示的行
     */
    @ApiModelProperty("每页显示的行")
    private Long size;

    /**
     * 总记录数
     */
    @ApiModelProperty("总记录数")
    private Long total;

    /**
     * 总页数
     */
    @ApiModelProperty("总页数")
    private Long totalPages;

    /**
     * 当前页记录
     */
    @ApiModelProperty("当前页记录, 当前页的数据")
    private List<T> list;
}
