package com.cy.pojo;

/**
 * 轨道信息
 */
public class TrackInfo {

    private int id;

    private String baseUrl;

    private String base_url;

    private String codecs;

    private long bandwidth;

    private int codecid;

    private String frameRate;

    private String frame_rate;

    private int height;

    private String mimeType;

    private String mime_type;

    private String sar;

    private int startWithSap;

    private int start_with_sap;

    private int width;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public String getCodecs() {
        return codecs;
    }

    public void setCodecs(String codecs) {
        this.codecs = codecs;
    }

    public long getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(long bandwidth) {
        this.bandwidth = bandwidth;
    }

    public int getCodecid() {
        return codecid;
    }

    public void setCodecid(int codecid) {
        this.codecid = codecid;
    }

    public String getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    public String getFrame_rate() {
        return frame_rate;
    }

    public void setFrame_rate(String frame_rate) {
        this.frame_rate = frame_rate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }

    public String getSar() {
        return sar;
    }

    public void setSar(String sar) {
        this.sar = sar;
    }

    public int getStartWithSap() {
        return startWithSap;
    }

    public void setStartWithSap(int startWithSap) {
        this.startWithSap = startWithSap;
    }

    public int getStart_with_sap() {
        return start_with_sap;
    }

    public void setStart_with_sap(int start_with_sap) {
        this.start_with_sap = start_with_sap;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "TrackInfo{" +
                "id=" + id +
                ", baseUrl='" + baseUrl + '\'' +
                ", base_url='" + base_url + '\'' +
                ", codecs='" + codecs + '\'' +
                ", bandwidth=" + bandwidth +
                ", codecid=" + codecid +
                ", frameRate='" + frameRate + '\'' +
                ", frame_rate='" + frame_rate + '\'' +
                ", height=" + height +
                ", mimeType='" + mimeType + '\'' +
                ", mime_type='" + mime_type + '\'' +
                ", sar='" + sar + '\'' +
                ", startWithSap=" + startWithSap +
                ", start_with_sap=" + start_with_sap +
                ", width=" + width +
                '}';
    }
}
