package com.arges.sepan.arghttpsample;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arges on 4/3/2017.
 */

public class BookHandler {
    static public ArrayList<Book> getBooksFromJson(String json){
        ArrayList<Book> list = null;
        try {
            JSONArray arr = new JSONObject(json).getJSONArray("book");
            list = new ArrayList<>();
            for(int i=0; i<arr.length(); i++){
                JSONObject o = arr.getJSONObject(i);
                Book b = new Book();
                b.setAuthor(o.getString("author"));
                b.setTitle(o.getString("title"));
                list.add(b);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            list = null;
        }
        return list;
    }
    static public Book getBookFromJson(String json){
        Book b = null;
        try {
            JSONArray arr = new JSONObject(json).getJSONArray("book");
            JSONObject o = arr.getJSONObject(0);
            b = new Book();
            b.setAuthor(o.getString("author"));
            b.setTitle(o.getString("title"));
        } catch (JSONException e) {
            e.printStackTrace();
            b = null;
        }
        return b;
    }
    static public String getBookArrayAsString(ArrayList<Book> list){
        String str = "Book Array:\n";
        for (Book b : list){
            str += b.getBookAsString()+"\n";
        }
        return str;
    }
}
