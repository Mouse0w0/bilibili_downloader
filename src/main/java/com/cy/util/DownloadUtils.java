package com.cy.util;

import java.io.*;
import java.net.URLConnection;

/**
 * 下载工具类
 */
public class DownloadUtils {

    /**
     * 文件的结尾
     */
    private static final int EOF = -1;

    /**
     * 默认buffer尺寸
     */
    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

    /**
     * 读取所有的字节数组
     *
     * @param input 输入流
     * @return 所有的字节数组
     */
    public static byte[] readAllBytes(final InputStream input) {
        BufferedInputStream bufferedInput = new BufferedInputStream(input);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int length;
            while ((length = bufferedInput.read(buffer)) != EOF) {
                output.write(buffer, 0, length);
            }
            return output.toByteArray();
        } catch (IOException ignored) {
        } finally {
            try {
                output.close();
                bufferedInput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new byte[0];
    }

    /**
     * 读取所有的输入流到字符串中
     *
     * @param inputStream 输入流
     * @return 字符串
     */
    public static String readString(InputStream inputStream) {
        return new String(readAllBytes(inputStream));
    }

    /**
     * 把输入流转换到输出流中
     *
     * @param input  输入流
     * @param output 输出流
     */
    public static void copy(InputStream input, OutputStream output) {
        try {
            int length;
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            while ((length = input.read(buffer)) != EOF) {
                output.write(buffer, 0, length);
            }
        } catch (IOException e) {
        } finally {
            try {
                output.close();
                input.close();
            } catch (IOException e) {
            }
        }
    }

    /**
     * 下载规定的URLConnection到目标地址
     *
     * @param urlConnection URLConnection对象
     * @param filePath      下载的目标位置
     */
    public static void download(URLConnection urlConnection, String filePath) {
        try {
            mkdirs(filePath);
            if (new File(filePath).length() == urlConnection.getContentLength()) {
                return;
            }
            copy(urlConnection.getInputStream(), new FileOutputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建目录
     *
     * @param filePath 文件路径字符串
     */
    @SuppressWarnings("all")
    public static void mkdirs(String filePath) {
        File file = new File(filePath);
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
    }

    /**
     * 写文本到一个文件中
     *
     * @param content  课程信息
     * @param filePath 文件路径
     * @throws FileNotFoundException #
     */
    public static void printText2File(String content, String filePath) throws FileNotFoundException {

        // 写入文件
        DownloadUtils.mkdirs(filePath);
        new PrintStream(filePath).println(content);
    }
}
