package com.cy.pojo;

import java.util.Arrays;

/**
 * 播放对象
 */
public class PlayObject {

    private String[] accept_description;

    private String accept_format;

    private int[] accept_quality;

    private Dash dash;

    private String format;

    private String from;

    private String message;

    private int quality;

    private String result;

    private String seek_param;

    private String seek_type;

    private long timelength;

    private int video_codecid;

    public String[] getAccept_description() {
        return accept_description;
    }

    public void setAccept_description(String[] accept_description) {
        this.accept_description = accept_description;
    }

    public String getAccept_format() {
        return accept_format;
    }

    public void setAccept_format(String accept_format) {
        this.accept_format = accept_format;
    }

    public int[] getAccept_quality() {
        return accept_quality;
    }

    public void setAccept_quality(int[] accept_quality) {
        this.accept_quality = accept_quality;
    }

    public Dash getDash() {
        return dash;
    }

    public void setDash(Dash dash) {
        this.dash = dash;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSeek_param() {
        return seek_param;
    }

    public void setSeek_param(String seek_param) {
        this.seek_param = seek_param;
    }

    public String getSeek_type() {
        return seek_type;
    }

    public void setSeek_type(String seek_type) {
        this.seek_type = seek_type;
    }

    public long getTimelength() {
        return timelength;
    }

    public void setTimelength(long timelength) {
        this.timelength = timelength;
    }

    public int getVideo_codecid() {
        return video_codecid;
    }

    public void setVideo_codecid(int video_codecid) {
        this.video_codecid = video_codecid;
    }

    @Override
    public String toString() {
        return "PlayObject{" +
                "accept_description=" + Arrays.toString(accept_description) +
                ", accept_format='" + accept_format + '\'' +
                ", accept_quality=" + Arrays.toString(accept_quality) +
                ", dash=" + dash +
                ", format='" + format + '\'' +
                ", from='" + from + '\'' +
                ", message='" + message + '\'' +
                ", quality=" + quality +
                ", result='" + result + '\'' +
                ", seek_param='" + seek_param + '\'' +
                ", seek_type='" + seek_type + '\'' +
                ", timelength=" + timelength +
                ", video_codecid=" + video_codecid +
                '}';
    }
}
