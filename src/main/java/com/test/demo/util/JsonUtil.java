package com.test.demo.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        // 允许存在未知字段（忽略未知字段）。否则会抛异常。
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 允许未转义的字符存在。否则会抛异常。
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    public static String toJson(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromJson(String json, Class<T> cls) throws IOException {
        return mapper.readValue(json, cls);
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> fromJson2Map(String json) throws IOException {
        return mapper.readValue(json, Map.class);
    }

    public static <T> List<T> fromJson2ListGeneric(String json, Class<T> cls) throws IOException {
        return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, cls));
    }

}

