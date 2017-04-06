# ArgHttp

An android http library with less code.

Builds: [![](https://camo.githubusercontent.com/118d9756ddf9796f391d9aded450208550090913/68747470733a2f2f6a69747061636b2e696f2f762f4861617269676572486172616c642f616e64726f69642d796f7574756265457874726163746f722e737667)](https://jitpack.io/#mergehez/ArgHttp/master-SNAPSHOT&summary=true)

# Gradle

To always build from the latest commit with all updates. Add the JitPack repository:
```
allprojects {
    repositories {
        ...other repositories...
        maven { url 'https://jitpack.io' }
    }
}
```
And the dependency:

```
dependencies {
    compile 'com.github.mergehez:ArgHttp:master-SNAPSHOT'
}

```

# How to use

Usage of this library is very simple. By typing one function, you can send server request, you can post data to server and you can retrieve data by posting data to server. The use of these three functions is as follows:
    
### Server request:
    
```
new ArgHttp().get(urlGet, serverSideErrorText, new CallGisti() {
    @Override
    public void agahi(ArgHttp context, String response) {
        // Check if there is an error
        if(context.isError()){
            // Display error message
        }else{
            // Parse the response. You can look at my sample application to understand better
        }
    }
});
```

Parameters:
- urlGet: url of the script that you want to get data from
- serverSideErrorText: you should check errors on server side, if an error occures you should print a specific text. You will define this text in this parameter.
- CallGisti: is an interface that bring the response of server

----------

### Post:
    
```
PostValues pvs = new PostValues().add("book-title","Book1").add("book-author","Mergehez");
new ArgHttp().post(urlPost, serverSideErrorText, pvs, new CallGisti() {
    @Override
    public void agahi(ArgHttp context, String response) {
        if(context.isError()){
            // Display error message
        }else{
            // Display the "successfully executed" or 'anything else' message
        }
    }
});
```

Parameters:
- urlPost: url of the script that you want to post the data to
- serverSideErrorText: you should check errors on server side, if an error occures you should print a specific text. You will define this text in this parameter.
- pvs: is your posted data. It a PostValues variable. Look at the above code line to understand better.
- CallGisti: is an interface that bring the response of server

----------

### Post and Get Response:
    
```
PostValues pvs = new PostValues().add("book-author","Mergehez");
new ArgHttp().postAndGet(urlPost, serverSideErrorText, pvs, new CallGisti() {
    @Override
    public void agahi(ArgHttp context, String response) {
        if(context.isError()){
            // Display error message
        }else{
            // Parse the response. You can look at my sample application to understand better
        }
    }
});
```

Parameters:
- urlPost: url of the script that you want to post the data to
- serverSideErrorText: you should check errors on server side, if an error occures you should print a specific text. You will define this text in this parameter.
- pvs: is your posted data. It a PostValues variable. Look at the above code line to understand better.
- CallGisti: is an interface that bring the response of server
