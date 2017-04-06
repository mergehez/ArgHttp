package com.arges.sepan.arghttpsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.arges.sepan.arghttp.ArgHttp;
import com.arges.sepan.arghttp.CallGisti;
import com.arges.sepan.arghttp.PostValues;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    String urlGet = "http://mergesoft.org/thesis/arghttp/get.php";
    String urlPost = "http://mergesoft.org/thesis/arghttp/post.php";
    String urlPostAndGet = "http://mergesoft.org/thesis/arghttp/postget.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tvResult);

        findViewById(R.id.btnGet).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { get(); }
        });
        findViewById(R.id.btnPost).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { post(); }
        });
        findViewById(R.id.btnPostGet).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { postAndGet(); }
        });
    }

    void get(){
        // Executing functions
        new ArgHttp().get(urlGet, "ERROR", new CallGisti() {
            @Override
            public void agahi(ArgHttp context, String response) {
                // Check if there is an error
                if(context.isError()){
                    writeResult("GET\n"+"App got an error. Error: "+context.getError());
                }else if(response.length()<1){
                    writeResult("GET\n Response length is 0!");
                }else{
                    Book b = BookHandler.getBookFromJson(response);
                    writeResult("GET\n"+"Successfully worked.\n"+b.getBookAsString());
                }
            }
        });
    }

    void post(){
        //final ArgHttp http = new ArgHttp();
        PostValues pvs = new PostValues().add("book-title","Book1").add("book-author","Mergehez");
        new ArgHttp().post(urlPost, "ERROR", pvs, new CallGisti(){
            @Override
            public void agahi(ArgHttp context, String response) {
                if(context.isError()){
                    writeResult("POST\n"+"App got an error. Error: "+context.getError());
                }else{
                    writeResult("POST\n"+"Book has successfully sent/posted/inserted");
                }
            }
        });
    }

    void postAndGet(){
        PostValues pvs = new PostValues().add("book-title","Book1").add("book-author","Mergehez");
        new ArgHttp().postAndGet(urlPostAndGet, "ERROR", pvs, new CallGisti() {
            @Override
            public void agahi(ArgHttp context, String response) {
                if(context.isError()){
                    writeResult("POST and GET\n"+"App got an error. \nError: "+context.getError());
                }else if(response.length()<1){
                    writeResult("POST and GET\n Response length is 0!");
                }else{
                    ArrayList<Book> arr = BookHandler.getBooksFromJson(response);
                    writeResult("POST and GET\n"+BookHandler.getBookArrayAsString(arr));
                }
            }
        });
    }


    void writeResult(String str){
        tv.setText(String.format("%s", str));
    }
}
