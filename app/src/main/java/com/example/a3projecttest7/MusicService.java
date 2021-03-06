package com.example.a3projecttest7;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {
    public MediaPlayer mp;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }


    @Override
    public void onStart(Intent intent, int startId) {
        Log.i("Example", "Service onStart()");

        super.onStart(intent, startId);
        mp = MediaPlayer.create(this, R.raw.music);
        mp.setLooping(true);

        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });


    }

    @Override
    public void onDestroy() {
        Log.i("Example", "Service onDestroy()");
        super.onDestroy();
        mp.pause();
        mp.reset();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }


}
/*
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        // 서비스가 호출될 때마다 실행
        Log.d("test", "서비스의 onStartCommand");
        mp3.start(); // 노래 시작
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        // 서비스가 종료될 때 실행
        mp3.stop(); // 음악 종료
        Log.d("test", "서비스의 onDestroy");


    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 서비스에서 가장 먼저 호출됨(최초에 한번만)
        Log.d("test", "서비스의 onCreate");
        mp3 = MediaPlayer.create(this, R.raw.music);
        mp3.setLooping(false); // 반복재생
    }
*/
