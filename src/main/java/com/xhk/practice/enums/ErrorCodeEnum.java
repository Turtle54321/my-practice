package com.xhk.practice.enums;

/**
 * 错误码共6位，前两位表示错误类型
 * 10代表调用成功，
 * <p>
 * 20代表参数校验失败，（包括参数为空异常和参数非法异常，这样做原因是后台需要将所有入参全部校验完毕一起返回）
 * <p>
 * 40代表权限不足，
 * <p>
 * 50代表接口自定义错误等等
 *
 * @author liuhai
 * @date 2018/3/22.
 */
public enum ErrorCodeEnum implements EnumTrait {

    SUCCESS(100000, "成功"),
    EMPTY_RESULT(100001, "未查询到数据"),
    INVALID_PARAM(200000, "入参不合法"),
    REPEAT(300000, "重复"),
    OAUTH_ERROR(400000, "权限不足"),
    SERVICE_ERROR(500000, "服务失败"),
    /**
     * 余额不足错误码
     */
    BALANCE_NOT_ENOUGH_ERROR(500001, "余额不足错误码");

    private int code;
    private String text;

    ErrorCodeEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }


    /**
     * 错误码类型
     *
     * @param code
     * @return
     */
    public static ErrorCodeEnum valueOf(int code) {
        for (ErrorCodeEnum errorCodeEnum : values()) {
            if (code == errorCodeEnum.getCode()) {
                return errorCodeEnum;
            }
        }
        return null;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getText() {
        return text;
    }


}
