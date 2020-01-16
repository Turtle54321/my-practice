package com.xhk.practice.utils;


import com.xhk.practice.enums.ErrorCodeEnum;
import com.xhk.practice.exception.AssetException;
import org.apache.commons.collections.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * 资产服务系统validator工具类
 * 主要是给接口入参进行参数校验，如果出现异常，统一抛出"AssetException"异常且ErrorCode为"200000"（入参不合法）
 *
 * @author: fengpeng
 * @date: 2019/3/25  上午11:36
 */
public class ValidatorUtil {
    private ValidatorUtil() {
        throw new AssetException("工具类无需实例化");
    }

    private static Validator validator;

    static {
        //  实例化
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }

    /**
     * 校验包含组信息的注解
     *
     * @param obj 待验证的实体
     * @param groups 校验组别
     * @param <T> 待验证的类型
     */
    public static <T> void validate(T obj, Class<?>... groups) {
        Set<ConstraintViolation<T>> set = validator.validate(obj, groups);
        assembleErrorMsg(set);
    }

    /**
     * 校验方法
     *
     * @param t   待验证的实体
     * @param <T> 待验证的类型
     */
    public static <T> void validate(T t) {
        Set<ConstraintViolation<T>> set = validator.validate(t);
        assembleErrorMsg(set);
    }


    private static <T> void assembleErrorMsg(Set<ConstraintViolation<T>> set) {
        if (CollectionUtils.isNotEmpty(set)) {
            StringBuilder validateError = new StringBuilder();
            for (ConstraintViolation<T> error : set) {
                validateError.append(String.format("%s ：[%s = %s] ;", error.getMessage(), error.getPropertyPath(), error.getInvalidValue()));
            }
            throw new AssetException(ErrorCodeEnum.INVALID_PARAM.getCode(), validateError.toString());
        }
    }
}
