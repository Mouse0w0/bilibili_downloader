package com.cy;

import com.cy.bilibili.BDownloader;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    /**
     * 开始下载
     *
     * @param args 程序入口函数
     */
    public static void main(String[] args) {
        try {
            commandLine(args);
        } catch (Exception e) {
            System.out.println("请检查您的网络或者URL，例如：https://www.bilibili.com/video/av39718511");
        }
    }


    /**
     * 命令行控制
     */
    private static void commandLine(String[] args) throws Exception {
        if (checkParam(args)) return; // 检查参数
        BDownloader.url = args[0]; // 开始下载
        BDownloader.startDownload();
    }

    /**
     * 检查参数
     *
     * @param args 用户参数
     * @return 是否成功
     */
    private static boolean checkParam(String[] args) {
        if (args.length < 1) {
            System.err.println("缺少URL，例如：https://www.bilibili.com/video/av39718511");
            return true;
        }
        if (!args[0].contains("www.bilibili.com/video/av")) {
            System.out.println("连接地址必须是BiliBili主站视频地址，不能是直播地址、小视频地址或者其他地址");
            System.out.println("例如：https://www.bilibili.com/video/av39718511");
            return true;
        }
        try {
            new URL(args[0]);
        } catch (MalformedURLException e) {
            System.err.println("非法的URL格式, 参考：协议://用户名:密码@子域名.域名.顶级域名:端口号/目录/文件名.文件后缀?参数=值#标志");
            return true;
        }
        return false;
    }

}
