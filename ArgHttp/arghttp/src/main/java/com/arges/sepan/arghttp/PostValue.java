package com.arges.sepan.arghttp;

/**
 * Created by arges on 4/3/2017.
 */

class PostValue{
    private String key, value;
    PostValue(String key, Object value){
        this.key = key;
        this.value = value.toString();
    }

    String getKey() {
        return key;
    }

    void setKey(String key) {
        this.key = key;
    }

    String getValue() {
        return value;
    }

    void setValue(String value) {
        this.value = value;
    }
}