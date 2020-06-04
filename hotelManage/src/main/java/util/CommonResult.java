package util;
import lombok.Data;

/**
 * 返回结果实体类
 */
@Data
public class CommonResult<T> {

    private Integer code;//返回码
    private String message;//返回消息
    private T data;//返回数据

    protected CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message=message;
        this.data=data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(HttpCode.SUCCESS.getCode(), HttpCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(HttpCode.SUCCESS.getCode(), message, data);
    }

    // 成功，没有返回结果
    public static CommonResult success() {
        return new CommonResult(HttpCode.SUCCESS.getCode(), HttpCode.SUCCESS.getMessage(),null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> CommonResult<T> failed(HttpCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(HttpCode.FAILED.getCode(), message, null);
    }

    public static <T> CommonResult<T> failed() {
        return failed(HttpCode.FAILED);
    }

    /**
     * 未登录返回结果
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(HttpCode.UNAUTHORIZED.getCode(), HttpCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(HttpCode.FORBIDDEN.getCode(), HttpCode.FORBIDDEN.getMessage(), data);
    }



}
