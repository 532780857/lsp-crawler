package net.m3u8.main;

import net.m3u8.download.M3u8DownloadFactory;
import net.m3u8.listener.DownloadListener;
import net.m3u8.utils.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyaling
 * @email ts_liyaling@qq.com
 * @date 2019/12/14 16:02
 */

public class M3u8Main {

    private static final String M3U8URL = "https://videozmcdn.stz8.com:8091/20191127/PK7a0LKQ/index.m3u8";

    public static void main(String[] args) {

        M3u8DownloadFactory.M3u8Download m3u8Download = M3u8DownloadFactory.getInstance(M3U8URL);
        //设置生成目录
        m3u8Download.setDir("D:/m3u8");
        //设置视频名称
        m3u8Download.setFileName("test");
        //设置线程数
        m3u8Download.setThreadCount(100);
        //设置重试次数
        m3u8Download.setRetryCount(0);
        //设置连接超时时间（单位：毫秒）
        m3u8Download.setTimeoutMillisecond(3000L);
        /*
        设置日志级别
        可选值：NONE INFO DEBUG ERROR
        */
        m3u8Download.setLogLevel(Constant.INFO);
        //设置监听器间隔（单位：毫秒）
        m3u8Download.setInterval(500L);
        //添加额外请求头
      /*  Map<String, Object> headersMap = new HashMap<>();
        headersMap.put("Content-Type", "text/html;charset=utf-8");
        m3u8Download.addRequestHeaderMap(headersMap);*/
        //添加监听器
        m3u8Download.addListener(new DownloadListener() {
            @Override
            public void start() {
                System.out.println("开始下载！");
            }

            @Override
            public void process(String downloadUrl, int finished, int sum, float percent) {
                System.out.println("下载网址：" + downloadUrl + "\t已下载" + finished + "个\t一共" + sum + "个\t已完成" + percent + "%");
            }

            @Override
            public void speed(String speedPerSecond) {
                System.out.println("下载速度：" + speedPerSecond);
            }

            @Override
            public void end() {
//                System.out.println("下载完毕");
            }
        });
        //开始下载
        m3u8Download.start();
    }
}
