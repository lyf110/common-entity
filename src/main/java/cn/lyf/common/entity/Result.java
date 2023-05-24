package cn.lyf.common.entity;

import cn.lyf.common.entity.enum_.StatusCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author liuyangfang
 * @description 通用的响应返回体
 * @since 2023/5/24 10:31:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "通用返回响应结果对象", value = "result")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "响应结果的错误信息", required = true)
    private String message;
    @ApiModelProperty(notes = "响应结果的错误信息状态码,2000X表示成功,4000X表示错误，5000X表示服务端异常", required = true)
    private Integer code;
    @ApiModelProperty(notes = "响应结果逻辑数据", required = true)
    private T data;


    public Result(StatusCode statusCode, T data) {
        this.message = statusCode.getMessage();
        this.code = statusCode.getCode();
        this.data = data;
    }


    /**
     * 成功 并不返回数据
     *
     * @param <T> T
     * @return 20000 操作成功
     */
    public static <T> Result<T> ok() {
        return Result.ok(null);
    }

    /**
     * 成功 并返回数据
     *
     * @param data 返回的数据
     * @param <T>  T
     * @return 20000 操作成功
     */
    public static <T> Result<T> ok(T data) {
        return new Result<>(StatusCode.SUCCESS, data);
    }


    /**
     * 系统错误 不返回数据
     *
     * @param <T> T
     * @return 50000 系统异常
     */
    public static <T> Result<T> error() {
        return error(StatusCode.FAILURE, null);
    }


    /**
     * 系统错误 并返回逻辑数据
     *
     * @param data 错误数据
     * @param <T>  T
     * @return 50000 系统异常
     */
    public static <T> Result<T> error(T data) {
        return error(StatusCode.FAILURE, data);
    }


    /**
     * 错误并返回指定错误信息和状态码以及逻辑数据
     *
     * @param statusCode 错误信息和状态码
     * @param data       逻辑数据
     * @param <T>        T
     * @return 指定错误信息和状态码
     */
    public static <T> Result<T> error(StatusCode statusCode, T data) {
        return new Result<>(statusCode, data);
    }

    /**
     * 错误并返回指定错误信息和状态码 不返回数据
     *
     * @param statusCode 错误信息和状态码
     * @param <T>        T
     * @return 指定错误信息和状态码
     */
    public static <T> Result<T> error(StatusCode statusCode) {
        return error(statusCode, null);
    }

    /**
     * 自定义错误和状态返回
     *
     * @param message 错误信息
     * @param code    状态码
     * @param data    逻辑数据
     * @param <T>     T
     * @return 错误信息 +  状态码 + 逻辑数据
     */
    public static <T> Result<T> errorMessage(String message, Integer code, T data) {
        return new Result<>(message, code, data);
    }


    /**
     * 自定义错误信息 状态码固定
     *
     * @param message 错误信息
     * @param data    逻辑数据
     * @param <T>     T
     * @return 错误信息 +  状态码
     */
    public static <T> Result<T> errorMessage(String message, T data) {
        return errorMessage(message, StatusCode.CUSTOM_FAILURE.getCode(), data);
    }

    /**
     * 自定义错误信息 状态码固定
     *
     * @param message 错误信息
     * @param <T>     T
     * @return 错误信息 +  状态码
     */
    public static <T> Result<T> errorMessage(String message) {
        return errorMessage(message, null);
    }
}
