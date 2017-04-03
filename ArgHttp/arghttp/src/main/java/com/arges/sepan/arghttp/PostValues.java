package com.arges.sepan.arghttp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PostValues {
    List<PostValue> list = new ArrayList<>();
    public PostValues(){

    }
    public PostValues add(String key, Object value){
        this.list.add(new PostValue(key,value));
        return this;
    }
    public PostValues addPostValueList(List<PostValue> list){
        for(PostValue p : list)
            this.add(p.getKey(),p.getValue());
        return this;
    }
    public PostValues addPostValueList(PostValue[] list){
        for(PostValue p : list)
            this.add(p.getKey(),p.getValue());
        return this;
    }
    public PostValue get(int index){
        return list.get(index);
    }

}
