package com.googlevip8.lspCrawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.googlevip8.lspCrawler.config.JavaProperyConfig;
import com.googlevip8.lspCrawler.utils.HttpsUtil;
import com.googlevip8.lspCrawler.utils.VideoDownUtil;
import com.googlevip8.lspCrawler.video.entity.Info;
import com.googlevip8.lspCrawler.video.service.IInfoService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan("com.googlevip8.lspCrawler.video.mapper")
public class LspApplication {

    @Autowired
    IInfoService iInfoService;
    @Autowired
    private static IInfoService iInfoServiceStatic;

    @PostConstruct
    public void init() {
        iInfoServiceStatic = iInfoService;
    }

    public static void main(String[] args) {
//        SpringApplication.run(LspApplication.class, args);
//        new Thread(LspApplication::startRunGetVideoInfo).start();
//        new Thread(LspApplication::startRunDownVideo).start();
        new Thread(LspApplication::startRunGetPornhubVideoInfo).start();
    }

    /**
     * 启动保存视频信息
     */
    public static void startRunGetVideoInfo() {
        for (int i = 0; i < 1000; i++) {
            getVideoList("https://xxxxx.com", "https://xxxxx.com/xxxxxxx/" + i + ".html", "D:\\m3u8");
        }
    }

    /**
     * 启动保存视频信息
     */
    public static void startRunGetPornhubVideoInfo() {
        new JavaProperyConfig().setPropery();
        for (int i = 0; i < 1000; i++) {
            getPronhubVideoList("https://cn.p站.com/", "https://cn.p站.com/video?o=mv&t=a&hd=1&page=" + i, "D:\\m3u8");
        }
    }

    /**
     * 启动下载视频
     */
    public static void startRunDownVideo() {
        for (int i = 2; i < 1000; i++) {
            try {
                Info sel = iInfoServiceStatic.sel(i);
                VideoDownUtil.M3u8Down(sel.getUri(), "D:\\video\\" + sel.getTitle(), sel.getTitle(), () -> {
                    iInfoServiceStatic.downStatus(sel.getId());
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 启动下载视频
     */
    public static void startDownPronhubVideo(String url,String fileDir) {
        HttpsUtil.downFile(url,fileDir);
    }

    /**
     * 获取视频详情
     *
     * @param url
     * @param title
     * @param imgUrl
     * @param downDir
     */
    public static void getVideoInfo(String url, String title, String imgUrl, String downDir) {
        try {
            String str = HttpsUtil.doGetToHtml(url);
            Document document = Jsoup.parse(str);
            Elements script = document.getElementsByTag("script").eq(7);
            String player_data = script.html().replace("var player_data=", "");
            JSONObject jsonObject = JSON.parseObject(player_data);
            String uri = jsonObject.getString("url");

            Info info = new Info();
            info.setTitle(title);
            info.setImgUrl(imgUrl);
            info.setUri(uri);
            iInfoServiceStatic.add(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取P站视频详情
     *
     * @param url
     * @param title
     * @param imgUrl
     * @param downDir
     */
    public static void getPornhubVideoInfo(String url, String title, String imgUrl, String downDir) {
        try {
            String str = HttpsUtil.doGetToHtml(url);
            Document document = Jsoup.parse(str);
            Element player = document.getElementById("player");
            Element script = player.child(0);
            String video_id = player.attr("data-video-id");
            String qualityItems = "var qualityItems_" + video_id + " = ";
            String player_data = script.html();
            int start = player_data.indexOf(qualityItems) + qualityItems.length();
            int end = player_data.indexOf("]", start) + 1;
            String videoArr = player_data.substring(start, end);
            JSONArray jsonArray = JSON.parseArray(videoArr);
            String videoUrl = null;
            for (int i = 0; i < jsonArray.size(); i++) {
                if (!"".equals(jsonArray.getJSONObject(i).getString("url"))){
                    videoUrl = jsonArray.getJSONObject(i).getString("url");
                }
                System.out.println(jsonArray.getJSONObject(i).getString("text") +":"+jsonArray.getJSONObject(i).getString("url"));
            }

            startDownPronhubVideo(videoUrl,downDir +"/"+ title + ".mp4");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取视频列表
     */
    public static void getVideoList(String domain, String uri, String downDir) {

        String str = HttpsUtil.doGetToHtml(uri);
        Document document = Jsoup.parse(str);
        Elements elements = document.getElementsByClass("stui-vodlist__thumb lazyload");
        for (Element element : elements) {
            getVideoInfo(domain + element.attr("href"), element.attr("title"), element.attr("data-original"), downDir);
        }
    }

    /**
     * 获取p站视频列表
     * 看到p站工程师写的代码，我怀疑他上班的时候在看片
     */
    public static void getPronhubVideoList(String domain, String uri, String downDir) {

        String str = HttpsUtil.doGetToHtml(uri);
        Document document = Jsoup.parse(str);
        Elements videoList = document.getElementsByClass("pcVideoListItem js-pop videoblock videoBox");
//        Elements elements = document.getElementById("plery");
        for (Element element : videoList) {
            Element aElement = element.getElementsByTag("a").get(0);
            String href = aElement.attr("href");
            String title = aElement.attr("title");
            String imgurl = aElement.child(0).attr("data-image");
            getPornhubVideoInfo(domain + href, title, imgurl, downDir);
        }
    }
}
