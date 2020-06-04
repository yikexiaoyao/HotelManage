package util;

/**
 * 枚举了一些常用API操作码
 */
public enum HttpCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),

    STOCK_OUT(601,"库存不足");

    private Integer code;
    private String message;

    private HttpCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 根据描述，返回该描述的枚举类型
     * @return
     */
    public static HttpCode fromDescribe(String describe) {
        for(HttpCode errorCode : HttpCode.values()) {
            if(errorCode.getMessage().equals(describe)) {
                return errorCode;
            }
        }
        return null;
    }
}
