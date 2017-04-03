package com.arges.sepan.arghttp;

/**
 * Created by arges on 4/3/2017.
 */

public class Result {
    private Type type;
    private String content;
    Result(Type type, String content){
        this.type = type;
        this.content = content;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    enum Type{
        ERROR,
        ERROR_SERVER,
        NO_ACTION,
        SUCCESSFUL
    }
}
