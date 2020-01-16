package com.xhk.practice.exception;

import com.finup.core.asset.common.ao.TransOutput;
import com.finup.core.asset.common.enums.ErrorCodeEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * 资产异常封装类
 *
 * @author liuhai
 * @date 2018/3/22.
 */
public class AssetException extends RuntimeException {

    /**
     * 异常错误码
     */
    private int errorCode;
    /**
     * 异常信息
     */
    private String errorMessage;

    public AssetException(String message) {
        super(message);
    }

    public AssetException(int errorCode, String errorMessage) {
        super("(" + errorCode + ")" + errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public AssetException(String message, Throwable cause) {
        this(ErrorCodeEnum.SERVICE_ERROR.getCode(), message, cause);
    }

    public AssetException(int errorCode, String errorMessage, Throwable cause) {
        super("(" + errorCode + ")" + errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public TransOutput generateTransOutput() {
        return new TransOutput(errorCode, StringUtils.isNotBlank(errorMessage) ? errorMessage : getSuperMessage());
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuperMessage(){
        String message = this.getMessage();
        if(StringUtils.isNotBlank(message)){
            message = message.length() > 500 ? StringUtils.substring(message, 0, 500) : message;
        }
        return message;
    }
}
