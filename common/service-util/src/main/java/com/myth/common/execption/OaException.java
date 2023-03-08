package com.myth.common.execption;

import com.myth.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * 自定义全局异常类
 *
 * @author may
 */
@Data
public class OaException extends RuntimeException {

    private final Integer code;

    private final String message;

    /**
     * 通过状态码和错误消息创建异常对象
     *
     * @param code    code
     * @param message msg
     */
    public OaException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 接收枚举类型对象
     *
     * @param resultCodeEnum enum
     */
    public OaException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "OaException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}