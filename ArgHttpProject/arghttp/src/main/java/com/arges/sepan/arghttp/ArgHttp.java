package com.arges.sepan.arghttp;

import android.os.AsyncTask;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Main Http class of the library
 * When we use http, there are three options: Only Posting Data, Only Getting Data, both Posting and Getting Data
 * There are three function for the above options: post, get, postAndGet
 * post: only posts data and returns no value
 * get: only gets data from server, posts nothing
 * post and get: posts data to server and gets the response from server
 *
 */
public class ArgHttp {
    private int TIME_OUT = 8000;    // The process ends when no response is received for 8 seconds.
    private String url, serverErrTxt;
    private PostValues postValues;
    private CallGisti call;         // CallBack for publishing response and errors
    private Result RESULT = new Result(Result.Type.NO_ACTION,"No Action!!!");
    public void setTimeOut(int timeOutInMillisecond){this.TIME_OUT = timeOutInMillisecond;}
    /**
     * This checks there is an error.
     * @return if there is an error returns true, if not returns false
     */
    public boolean isError(){
        return (this.RESULT.getType() == Result.Type.ERROR) || (this.RESULT.getType() == Result.Type.ERROR_SERVER);
    }
//An error occurred on the server side.
    /**
     * @return if there is an error returns error, if not returns a warning text
     */
    public String getError(){
        return (isError()
                ? ( this.RESULT.getType() == Result.Type.ERROR
                    ? this.RESULT.getContent()
                    : "An error occurred on the server side!")
                : "There is no error!");
    }

    /**
     * For less code
     * @return Returns a simple HttpClient
     */
    private HttpClient getClient(){
        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, TIME_OUT);
        HttpConnectionParams.setSoTimeout(httpParams, TIME_OUT);
        return new DefaultHttpClient(httpParams);
    }

    /**
     * this function posts data to server and retrieves data from server
     * Should be used when the server responds to the posted data
     *
     * @param url           the url that the function posts data to
     * @param postValues    Posted Data
     * @param call          this will publish the retrieved data or errors
     */
    public void postAndGet(String url, String serverSideErrorText, PostValues postValues, CallGisti call){ new PostBine(url, serverSideErrorText, postValues,call).execute(); }
    private class PostBine extends AsyncTask<Void,Void,Result> {
        PostBine(String url, String serverSideErrorText, PostValues postValues, CallGisti callBack){
            ArgHttp.this.url = url;
            ArgHttp.this.postValues = postValues;
            ArgHttp.this.call = callBack;
            ArgHttp.this.serverErrTxt = serverSideErrorText;
        }
        @Override
        protected void onPostExecute(Result aVoid) {
            ArgHttp.this.RESULT = aVoid;
            ArgHttp.this.call.agahi(ArgHttp.this,(aVoid.getType()== Result.Type.ERROR ? null : aVoid.getContent()));
            super.onPostExecute(aVoid);
        }

        @Override
        protected Result doInBackground(Void... voids){
            ArrayList<NameValuePair> dataToSend = new ArrayList<>();
            for(PostValue p : postValues.list)   dataToSend.add(new BasicNameValuePair(p.getKey(), p.getValue()));

            HttpClient client = getClient();
            HttpPost httpPost = new HttpPost(url);
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(dataToSend));
                String result = new String(EntityUtils.toString(client.execute(httpPost).getEntity()).getBytes("ISO-8859-1"), "UTF-8");
                //Log.d("ArgHttp","PostBine result: "+ result);
                if(result.equals(ArgHttp.this.serverErrTxt))
                    return new Result(Result.Type.ERROR_SERVER,"");
                else
                    return new Result(Result.Type.SUCCESSFUL,result);
            }catch (Exception e){
                e.printStackTrace();
                return new Result(Result.Type.ERROR,e.getMessage());
            }
        }
    }


    /**
     * this function only posts data
     * Should be used when the server does not respond to the posted data
     *
     * @param url           the url that the function posts data to
     * @param postValues    Posted Data
     */
    public void post(String url, String serverSideErrorText, PostValues postValues, CallGisti call){ new Post(url, serverSideErrorText, postValues, call).execute(); }
    private class Post extends AsyncTask<Void,Void,Result> {
        Post(String url, String serverSideErrorText, PostValues postValues, CallGisti call){
            ArgHttp.this.url = url;
            ArgHttp.this.postValues = postValues;
            ArgHttp.this.call = call;
            ArgHttp.this.serverErrTxt = serverSideErrorText;
        }
        @Override
        protected void onPostExecute(Result aVoid) {
            ArgHttp.this.RESULT = aVoid;
            ArgHttp.this.call.agahi(ArgHttp.this,aVoid.getContent());
            super.onPostExecute(aVoid);
        }
        @Override
        protected Result doInBackground(Void... voids) {
            try {
                HttpClient client = getClient();
                HttpPost httppost= new HttpPost(url);

                List<NameValuePair> nameValuePairs = new ArrayList<>();
                for(PostValue p : postValues.list)   nameValuePairs.add(new BasicNameValuePair(p.getKey(), p.getValue()));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs, HTTP.UTF_8));
                String result = new String(EntityUtils.toString(client.execute(httppost).getEntity()).getBytes("ISO-8859-1"), "UTF-8");
                if(result.equals(ArgHttp.this.serverErrTxt))
                    return new Result(Result.Type.ERROR_SERVER,"");
                else
                    return new Result(Result.Type.SUCCESSFUL,"");
            } catch (IOException e){
                e.printStackTrace();
                return new Result(Result.Type.ERROR,e.getMessage());
            }
        }
    }

    /**
     * this function only gets data from server
     * Should be used when no data is posted
     *
     * @param url                     the url that the function posts data to
     * @param call                    this will publish the retrieved data or errors
     * @param serverSideErrorText     this will be used for checking response whether it is an error.
     *                                Developer should check errors in his/her web scripts and if there is an error,
     *                                he/she should make scripts response this error text.
     */
    public void get(String url, String serverSideErrorText, CallGisti call){ new Get(url,serverSideErrorText,call).execute(); }
    private class Get extends AsyncTask<Void,Void,Result> {
        Get(String url, String serverSideErrorText, CallGisti callBack){
            ArgHttp.this.url = url;
            ArgHttp.this.call = callBack;
            ArgHttp.this.serverErrTxt = serverSideErrorText;
        }
        @Override
        protected void onPostExecute(Result aVoid) {
            ArgHttp.this.RESULT = aVoid;
            ArgHttp.this.call.agahi(ArgHttp.this,(aVoid.getType()== Result.Type.ERROR ? null : aVoid.getContent()));
            super.onPostExecute(aVoid);
        }

        @Override
        protected Result doInBackground(Void... voids){
            HttpClient client = getClient();
            HttpPost httpPost = new HttpPost(url);
            try {
                String result = new String(EntityUtils.toString(client.execute(httpPost).getEntity()).getBytes("ISO-8859-1"), "UTF-8");
                //Log.d("JSONRESULT: ", result);
                if(result.equals(ArgHttp.this.serverErrTxt))
                    return new Result(Result.Type.ERROR_SERVER,"");
                else
                    return new Result(Result.Type.SUCCESSFUL,result);

            }catch (Exception e){
                e.printStackTrace();
                return new Result(Result.Type.ERROR,e.getMessage());
            }
        }
    }
}
