package com.cy.pojo;

import java.util.Arrays;

/**
 * Dash信息
 */
public class Dash {

    private TrackInfo[] audio;

    private TrackInfo[] video;

    private int duration;

    private double minBufferTime;

    private double min_buffer_time;

    public TrackInfo[] getAudio() {
        return audio;
    }

    public void setAudio(TrackInfo[] audio) {
        this.audio = audio;
    }

    public TrackInfo[] getVideo() {
        return video;
    }

    public void setVideo(TrackInfo[] video) {
        this.video = video;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getMinBufferTime() {
        return minBufferTime;
    }

    public void setMinBufferTime(double minBufferTime) {
        this.minBufferTime = minBufferTime;
    }

    public double getMin_buffer_time() {
        return min_buffer_time;
    }

    public void setMin_buffer_time(double min_buffer_time) {
        this.min_buffer_time = min_buffer_time;
    }

    @Override
    public String toString() {
        return "Dash{" +
                "audio=" + Arrays.toString(audio) +
                ", video=" + Arrays.toString(video) +
                ", duration=" + duration +
                ", minBufferTime=" + minBufferTime +
                ", min_buffer_time=" + min_buffer_time +
                '}';
    }
}
