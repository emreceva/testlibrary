package com.example.testlibrary.utils.json;

import com.example.testlibrary.exception.JSONException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.DataInput;
import java.util.ArrayList;
import java.util.Collection;

public class JSONUtils {

    private static final ObjectMapper mapper = createMapper();
    private JSONUtils() { throw new IllegalStateException("Utility class"); }
    public static ObjectMapper createMapper() {
        ObjectMapper mapper = JsonMapper.builder() .findAndAddModules() .build();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        return mapper; }
    public static ObjectMapper getMapper() {
        return mapper; }
    public static <T> T convertValue(Object content, TypeReference typeReference) throws JSONException {
        try {
            return (T) mapper.convertValue(content, typeReference);
        } catch (Exception e) {
            throw new JSONException("JSON Parse Error", e);
        }
    }
    public static <T> T readJSON(JsonNode node, Class<T> clazz) throws JSONException {
        try {
            String content = mapper.writeValueAsString(node);
            return (T) mapper.readValue(content, clazz);
        } catch (Exception e) {
            throw new JSONException("JSON Parse Error", e);
        }
    }
    public static <T> T readJSON(String content, Class<T> clazz) throws JSONException {
        try {
            return (T) mapper.readValue(content, clazz);
        } catch (Exception e) {
            throw new JSONException("JSON Parse Error", e);
        }
    }
    public static <T> T readJSON(String content, TypeReference<T> tTypeReference) throws JSONException {
        try {
            return (T) mapper.readValue(content, tTypeReference);
        } catch (Exception e) {
            throw new com.example.testlibrary.exception.JSONException("JSON Parse Error", e);
        }
    }
    public static <T> T treeToValue(Object map, Class<T> clazz) throws JSONException {
        try {
            JsonNode node = (JsonNode) mapper.convertValue(map, JsonNode.class);
            return (T) mapper.treeToValue((TreeNode) node, clazz);
        } catch (Exception e) { throw new JSONException("JSON Parse Error", e);
        }
    }

    /*
    public static <T> T getData(BaseResponse<T> resp, Class<T> klass) {
        if (!resp.isSuccess()) { resp.getMessage().getDetail().forEach(baseMessageDetail -> {
            log.error("Error Code [{}]", Integer.valueOf(baseMessageDetail.getCode()));
            log.error("Error Args [{}]", baseMessageDetail.getArgs()); });
            return null; } return toObject(toJSON(resp.getData()), klass);
    }

     */
    private static String toJSON(Object object) {
        return writeJSON(object);
    } private static <T> T toObject(String content, Class<T> clazz) {
        return readJSON(content, clazz);
    } public static <T> T toObject(Object map, Class<T> clazz) {
        if (null == map) {
            return null;
        }
        return treeToValue(map, clazz);
    }
    public static <T extends JsonNode> T valueToTree(Object value) throws JSONException {
        try {
            return (T) mapper.valueToTree(value);
        } catch (Exception e) {
            throw new JSONException("JSON Parse Error", e);
        }
    } public static <T> String writeJSON(Object object) throws JSONException {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new JSONException("JSON Parse Error", e);
        }
    } public static <T> Collection<T> readJSONCollection(String content, Class<T> clz) {
        try {
            Collection<T> result = new ArrayList<>();
            ArrayNode c = readJSON(content, ArrayNode.class);
            for (JsonNode o : c) {
                T node = (T) mapper.readValue(o.textValue(), clz);
                result.add(node); }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static <T> Collection<T> readJSONCollection(ArrayNode content, Class<T> clz) {
        try {
            Collection<T> result = new ArrayList<>();
            for (Object o : content) {
                T node = (T) mapper.readValue((DataInput) o, clz);
                result.add(node);
            } return result;
        } catch (Exception e) { throw new RuntimeException(e);
        }
    }
    public static String prettyPrint(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception var2) {
            throw new JSONException("exception while pretty printing", var2);
        }
    }
}
