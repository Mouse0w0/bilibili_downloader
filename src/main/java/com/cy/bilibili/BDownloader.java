package com.cy.bilibili;

import com.alibaba.fastjson.JSON;
import com.coremedia.iso.boxes.Container;
import com.cy.pojo.Dash;
import com.cy.pojo.PlayInfo;
import com.cy.pojo.TrackInfo;
import com.cy.util.DownloadUtils;
import com.googlecode.mp4parser.MemoryDataSourceImpl;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.container.mp4.MovieCreator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;

public class BDownloader {

    public static String url;
    private static final String PATH = System.getProperty("user.dir") + File.separator;
    private static final String PLAY_INFO_PREFIX = "window.__playinfo__=";
    private static final String PLAY_INFO_SUFFIX = "</script>";

    public static void startDownload() throws Exception {

        System.out.println("正在连接...");
        Document document = Jsoup.connect(url).get();
        String title = document.select(".tit").text();
        PlayInfo playInfo = getPlayInfo(document);

        Dash dash = playInfo.getData().getDash();
        TrackInfo[] audio = dash.getAudio();
        TrackInfo[] video = dash.getVideo();
        TrackInfo audioInfo = audio[audio.length - 1];
        TrackInfo videoInfo = video[video.length - 1];

        System.out.println("已经获取DASH标准的AUDIO和VIDEO...");
        // 开始下载
        System.out.println("正在执行下载...");
        byte[] videoBytes = DownloadUtils.readAllBytes(url2InputStream(videoInfo.getBaseUrl()));
        System.out.println("视频轨道已经下载至内存中...");
        byte[] audioBytes = DownloadUtils.readAllBytes(url2InputStream(audioInfo.getBaseUrl()));
        System.out.println("音频轨道已经下载至内存中...");
        // 合并音频和视频
        muxingVideo(title, videoBytes, audioBytes);
        System.out.println("当前页面正在播放视频下载完成...");
    }

    private static void muxingVideo(String title, byte[] videoBytes, byte[] audioBytes) throws IOException {
        System.out.println("正在将“音频轨道”和“视频轨道”合并...");
        Track mp4Track = MovieCreator.build(new MemoryDataSourceImpl(audioBytes)).getTracks().get(0);
        Track mp3Track = MovieCreator.build(new MemoryDataSourceImpl(videoBytes)).getTracks().get(0);
        Movie movie = new Movie();
        movie.addTrack(mp4Track);
        movie.addTrack(mp3Track);
        Container mp4file = new DefaultMp4Builder().build(movie);
        FileChannel fc = new FileOutputStream(new File(PATH + getPrettyFileName(title) + ".mp4")).getChannel();
        mp4file.writeContainer(fc);
        fc.close();
    }

    private static PlayInfo getPlayInfo(Document document) {
        String pageContent = document.toString();
        int firstIndex = pageContent.indexOf(PLAY_INFO_PREFIX) + PLAY_INFO_PREFIX.length();
        int lastIndex = pageContent.indexOf(PLAY_INFO_SUFFIX, firstIndex);
        String json = pageContent.substring(firstIndex, lastIndex);
        return JSON.parseObject(json, PlayInfo.class);
    }

    /**
     * 将URL转换成InputStream流
     *
     * @param urlString URL
     * @return InputStream
     * @throws IOException 异常
     */
    private static InputStream url2InputStream(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestProperty("Origin", "https://www.bilibili.com");
        urlConnection.setRequestProperty("Referer", BDownloader.url);
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
        return urlConnection.getInputStream();
    }

    /**
     * 得到可用的文件名（通用性一般不包含特殊的字符，因为范围广，并且太复杂 比如说\U000E字符）
     *
     * @param fileName 文件名
     * @return 可用的文件名
     */
    private static String getPrettyFileName(String fileName) {
        if (fileName == null) return "临时文件名"; // 无文件名
        if (fileName.length() > 255) return fileName.substring(0, 10); // 裁剪一部分文件名
        if (!fileName.matches("[^\\s\\\\/:*?\"<>|](\\x20|[^\\s\\\\/:*?\"<>|])*[^\\s\\\\/:*?\"<>|.]$")) // 文件名合法验证
            return fileName.replaceAll("[\\s\\\\/:*?\"<>|]", ""); // 替换文件名中非法字符
        return fileName; // 原文件名
    }
}
