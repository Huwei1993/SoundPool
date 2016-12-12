package com.example.farhan.applicationdemo;

import android.app.Application;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class demoApplicationClass extends Application {
    SoundPool globalSoundPool;
    SoundPool.Builder soundPoolBuilder;

    AudioAttributes globalAudioAttributes;
    AudioAttributes.Builder globalAudioAttributesBuilder;

    AudioManager audioManager;

    float gCurVolume=3, gMaxVolume, gVolume=3;

    int globalSoundIDCoin;

    @Override
    public void onCreate() {
        super.onCreate();

        gCreateSoundPool();
        gLoadSounds();

        gVolumeSounds();
    }

    protected void gLoadSounds() {
        globalSoundIDCoin = globalSoundPool.load(this,R.raw.gamecoin,1);
    }
    protected void gPlaySound(){
        globalSoundPool.play(globalSoundIDCoin,gVolume,gVolume,1,-1, (float) 0.5);
    }
    protected void gVolumeSounds() {
        audioManager =(AudioManager) getSystemService(AUDIO_SERVICE);
        gCurVolume = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        gMaxVolume = (float) audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        gVolume = gCurVolume/gMaxVolume;

    }

    protected void gCreateSoundPool() {
        globalAudioAttributesBuilder = new AudioAttributes.Builder();
        globalAudioAttributesBuilder.setUsage(AudioAttributes.USAGE_GAME);
        globalAudioAttributesBuilder.setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION);
        globalAudioAttributes = globalAudioAttributesBuilder.build();

        soundPoolBuilder = new SoundPool.Builder();
        soundPoolBuilder.setAudioAttributes(globalAudioAttributes);
        globalSoundPool = soundPoolBuilder.build();
    }


    public void gStop() {
        globalSoundPool.stop(globalSoundIDCoin);
    }
}
