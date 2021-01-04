package com.shptchangfeng.eastdemo.common.utils;

import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * dozer 转换器
 */
@Component
public class ConvertorUtil {

    private final Mapper mapper;

    public ConvertorUtil(Mapper mapper) {
        this.mapper = mapper;
    }

    /**
     * List  实体类 转换器
     *
     * @param source 原数据
     * @param clz    转换类型
     * @param <T>
     * @param <S>
     * @return
     */
    public <T, S> List<T> convertor(List<S> source, Class<T> clz) {
        if (source == null) return null;
        List<T> map = new ArrayList<>();
        for (S s : source) {
            map.add(mapper.map(s, clz));
        }
        return map;
    }

    /**
     * 实体类 深度转换器
     *
     * @param source
     * @param clz
     * @param <T>
     * @param <S>
     * @return
     */
    public <T, S> T convertor(S source, Class<T> clz) {
        if (source == null) return null;
        return mapper.map(source, clz);
    }

    public void convertor(Object source, Object object) {
        mapper.map(source, object);
    }

    public <T> void copyConvertor(T source, Object object) {
        mapper.map(source, object);
    }
}