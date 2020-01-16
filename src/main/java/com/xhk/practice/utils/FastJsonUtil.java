package com.xhk.practice.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * fastJson工具类
 *
 * @author zhangliang
 * @date 2019/3/27
 */
public class FastJsonUtil {
    private FastJsonUtil() {
    }

    public static String getJSON(Object value) {
        return JSON.toJSONString(value);
    }

    public static String getJsonWithDateFormat(Object value) {
        return JSON.toJSONStringWithDateFormat(value, JSON.DEFFAULT_DATE_FORMAT);
    }

    public static String getJsonWithDateFormat(Object value, String dateFormat) {
        return JSON.toJSONStringWithDateFormat(value, dateFormat);
    }

    public static String getJSON(Object object, SerializeFilter[] filters, SerializerFeature... features) {
        return JSON.toJSONString(object, filters, features);
    }

    public static <T> T toBean(String json, Class<T> beanClass) {
        return JSON.parseObject(json, beanClass);
    }

    public static Object toBean(String json) {
        return JSON.parseObject(json, Object.class);
    }

    public static <T> List<T> toList(String json, Class<T> beanClass) {
        return JSON.parseArray(json, beanClass);
    }
}
