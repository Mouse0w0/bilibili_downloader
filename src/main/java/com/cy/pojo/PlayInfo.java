package com.cy.pojo;

import java.util.Map;

/**
 * 播放信息
 */
public class PlayInfo {

    private int code;

    private PlayObject data;

    private String message;

    private String session;

    private int ttl;

    private Map videoFrame;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public PlayObject getData() {
        return data;
    }

    public void setData(PlayObject data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public Map getVideoFrame() {
        return videoFrame;
    }

    public void setVideoFrame(Map videoFrame) {
        this.videoFrame = videoFrame;
    }

    @Override
    public String toString() {
        return "PlayInfo{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                ", session='" + session + '\'' +
                ", ttl=" + ttl +
                ", videoFrame=" + videoFrame +
                '}';
    }
}
