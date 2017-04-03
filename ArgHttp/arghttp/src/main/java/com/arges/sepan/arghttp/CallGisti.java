package com.arges.sepan.arghttp;

/**
 * Created by arges on 4/3/2017.
 */

public interface CallGisti {
    /**
     * This callback is for publishing responses of server or errors
     * @param response returned value from ArgHttp class's functions
     * @param context In order for the developer to use the functions within the ArgHttp class
     */
    void agahi(ArgHttp context, String response);
}
