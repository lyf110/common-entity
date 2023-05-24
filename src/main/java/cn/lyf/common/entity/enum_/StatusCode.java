package cn.lyf.common.entity.enum_;

/**
 * @author liuyangfang
 * @description 枚举类状态码，区分与http状态码
 * @since 2023/5/24 10:34:37
 */
public enum StatusCode {
    SUCCESS(20000, "操作成功"),
    PARAM_ERROR(40000, "参数异常"),
    NOT_FOUND(40004, "资源不存在"),
    FAILURE(50000, "系统异常"),
    CUSTOM_FAILURE(50001, "自定义异常错误"),
    NEED_LOGIN(50002, "需要登录");

    private final Integer code;

    private final String message;

    StatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取状态码
     *
     * @return 状态码
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 获取信息
     *
     * @return 状态码对应的描述信息
     */
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.valueOf(this.code);
    }
}
