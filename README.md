# ArgPlayer

An android music player ui library with easy usage.

Builds: [![](https://jitpack.io/v/mergehez/ArgPlayer.svg)](https://jitpack.io/#mergehez/ArgPlayer)

## Table Of Contents
[TOC]

## Gradle
To always build from the latest commit with all updates. Add the JitPack repository:

(path:\to\your\projects\MainFolderOfYourProject\build.gradle)
```
repositories {
    maven { url "https://jitpack.io" }
}
```
And the dependency:

```
dependencies {
	compile 'com.github.mergehez:ArgPlayer:master-SNAPSHOT'
}
```


## How to use

### XML Codes
for small view:
```xml
<com.arges.sepan.argmusicplayer.PlayerViews.ArgPlayerSmallView
	android:id="@+id/argmusicplayer"
	android:layout_width="match_parent"
	android:layout_height="wrap_content"/>
```
for large view:
```xml
<com.arges.sepan.argmusicplayer.PlayerViews.ArgPlayerLargeView
        android:id="@+id/argmusicplayer"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```
for full screen view:
```xml
<com.arges.sepan.argmusicplayer.PlayerViews.ArgPlayerFullScreenView
            android:id="@+id/argmusicplayer"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"/>
```

----
### Java Codes
#### Simplest Usage
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
	...
	String url = "https://mergesoft.org/caruso.mp3";
	ArgAudio audio = new ArgAudio("Andrea Bocelli","Caruso",url,AudioType.URL)
	ArgPlayerSmallView argMusicPlayer = (ArgPlayerSmallView) findViewById(R.id.argmusicplayer);
	argMusicPlayer.play(audio);
	...
}
```
----



#### All Methods
| Return | Method |
| --- |---|
| void |`play(ArgAudio audio)` <br>Directly play an audio|
| void |`playPlaylist(ArgAudioList list)` <br>Directly play a playlist|
| void |`loadSingleAudio(ArgAudio audio)` <br>Load an audio to play later|
| void |`playLoadedSingleAudio()` <br>Play the loaded audio if exists|
| void |`loadPlaylist(ArgAudioList list)` <br>Load a playlist to play later|
| void |`playLoadedPlaylist()` <br>Play the loaded playlist if exists|
| void |`pause()` <br>Pause a playing audio|
| void |`stop()` <br>Stop audio|
| void |`seekTo(int millisec)` <br>Seek audio to the specified millisecond|
| ArgAudio |`getCurrentAudio()` <br>Get the current audio if available|
| long|`getDuration()` <br>Get duration of current audio|
| boolean|`isPlaying()` <br>Check if an audio is playing|
| boolean|`isPaused()` <br>Check if an audio is paused|
| void |`playAudioAfterPercent(int percent)` <br>Audio will plays after %`percent` buffered. Only when audio type is Url. Default percent is **%50**. | 
| void |`enableProgress()` and `disableProgress()` <br> Enable/Disable Progress View. Default is **enableProgress()** method|
| void |`setProgressMessage(String message)` <br> Change Progress View message. Default message is **'Audio is Loading..'**|
| void |`enableErrorView()` and `disableErrorView()` <br>Enable/Disable Error View. Error view appears when an error has occured. Defaultly is **enabled** |
| void |`enableNextPrevButtons()`and `disableNextPrevButtons()` <br> Use can disable next/previous playback control but Defaultly is **enabled**|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|
| void |`()` <br>|










## ScreenShots
