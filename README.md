# lsp爬虫

## LSP是第一生产力，深夜开车必备

### 你是不是也经常碰到无数的博（bo）彩（cai）广告、app下载跳出来，你是不是非常的懊恼，学习一下爬虫吧，只看你想看的内容
#### 介绍
由“阿里渣渣java研发组”、“阿里渣渣java开发组”全体群友投票决定要做的开源项目

基于各位lsp的投票，从以下19个开源项目投票选项中经过3轮投票得出，本群需要开源开发一个java爬虫项目

1. 造个IDE
2. lsp网站收集
3. 一键搭建微服务的项目
4. 一套弱代码继承开发系统，支持界面自定义搭配，数据库自由配置
5. 后台管理的手脚架
6. 一个反大数据推荐的程序
7. 知识管理+项目管理
8. 做个lsp网站的粽子爬虫程序
9. wiki
10. 博（bo）彩(cai)网站
11. 开源一个程序员导航项目
12. 云存储管理系统
13. 文档生成，类似swgger2的
14. 深度学习的项目
15. 小学生编程学习网站
16. 远程办公软件
17. 投屏系统
18. 一套bladex项目
19. 低代码模板可配置手脚架


## **以下开源项目名称暂定 lsp爬虫 ** 

请在下方写上“lsp爬虫”具有的功能

1. 输入网址，选择爬取内容
2. 获取视频、图片、标题（同步爬取视频&图片的标签，按照标签分类，可以按照标签爬取）
3. 支持各种lsp网站的爬虫
4. 网站内容，视频获取
5. 开发网站显示爬取的无害内容
6. 分享weiaxin，朋友圈、QQ、QQ空间、同学群
7. 可以根据fan号、人名、标签、关键词等获取内容
8. 采集weiaxin公众号文章
9. 墙内访问外网lsp网站爬取指定链接视频
10. 自动生成精彩片段
11. 短视频去水印
12. （电影直播个毛）最新电影，拉取在线直播
13. 可以对人物进行换脸，对语言进行自动翻译成中文
14. （非项目功能）投屏到电视机
15. 网络传输加密，参考tor
16. 对人物打分，只保留高分内容，
17. 可以对抓取的内容进行转码m3u8转mp4等
18. 弹幕功能
19. （非项目功能）看视频的时候，网不卡就行。
20. （图片粽子可以，升级分辨率不存在）以图搜粽子，爬取时超分辨率处理，1080P升级成4K
21. 搭建一个lsp社区！
22. 女主角AI换脸
23. 服务器用阿美利肯的，受阿美利肯法律保护
24. 爬虫排行榜实时更新 周榜 日榜 月榜
25. 支持下载,压缩,解码,MD5修改（云盘上传不和谐）功能,让群友离线观看
26. 对有马赛克的视频，将马塞克去除掉并高清展示原内容
27. 图片粽子(将粽子隐藏在图片中) 并且支持解析图种和生成
28. 视频支持4K,老视频自动修复并去掉马赛克
29. 上传功能，可以上传自己的视频造福其他人，评论功能，上传者视频做的好，评论好，排名靠前
30. 类似与facebook的视频聊天室，独乐乐不如众乐乐
31. （谁不想呢，做不到）可以联系到男一号以及女一号
32. 支持订阅


## **对以上大佬们提的功能进行提炼**

1. 爬虫功能，爬取文字信息、图片信息、视频信息
2. 视频转码功能
3. 爬取的信息进行打标签、分类、打分
4. 支持代理功能
5. 爬虫网站使用非对称加密访问，参考tor
6. 爬取的内容可以分享到weiaxin、朋友圈、QQ、QQ空间，对用户爬虫信息进行订阅
7. 爬取同一块内容时，可以聊天、弹幕
8. 爬虫信息排行榜，周榜、日榜、月榜
9. 爬虫结果进行做种，粽子可以生成图种
10. 上传文字、图片、视频信息
11. 视频处理功能：修复老视频、去马赛克、AI换脸、升级分辨率、去水印、标记精彩片段、编辑视频、视频解码、自动中文字幕翻译

总结：除视频处理之外，我们要做一个爬虫平台，可以私有、公共爬取信息并分享信息

20201年4月27日输入以上信息

# 给我一个用爬虫的理由

<img src="img/QQ图片20210430181128.jpg" width="300px">

看到上图内容，如果你害怕了，说明你需要一个匿名爬虫（Tor）

2021年4月30日输入以上信息

可行性分析：

1. 视频处理等待万能的群友解决
2. 视频下载：m3u8解析、转码、下载、合并、多线程；使用m3u8Dowload开源项目
3. 公共平台：上传下载过的网站和视频信息并打上标签
4. 使用基于rtmp流的视频人脸识别“red5-rtmp-push”识别男主角与女主角
5. lsp神器：阿里云盘、夸克浏览器

软件架构：未定

功能分析：未开始


## 完成第一个可用版本
1. 爬了“你懂的”网址
2. 多线程爬虫速度非常快，直接挤满带宽
3. 计划下阶段用上代理，参考clash
2021年5月8号输入以上信息
   
## 完成P站爬虫
1. 单线程爬取P站视频
2. 无需spring boot
3. 存在问题，没有找到m3u8地址，下载略慢
4. 存在问题，Java解析clash代理失败，如需代理，请咨询VIP群群主
2021年5月9好输入以上信息

### 开发过程中碰到的问题

1. java.lang.ArithmeticException: / by zero
```html
1、异常提示：　　java.lang.ArithmeticException: / by zero
 
2、原因：　　当我们定义的被除数为整型时（short、int、long）会抛出此异常， 被除数为整型时不可为零。
 
3、解决办法： 检查整型的被除数。
```

QQ群：
- [阿里渣渣java研发组（831363708）](https://jq.qq.com/?_wv=1027&k=eWW8vonD)
- [阿里渣渣java开发组（577287025）](https://jq.qq.com/?_wv=1027&k=Oc9Ggboo)

微信群：
群员已超过200人，需要加好友拉微信群
<img src="img/A628E8E53B98458E78CF3AB54DEA9FD2.jpg" width="300px">



欢迎加入我们进行探讨或在下方留言说出你的想法

## 赞助

”“你懂的”爬虫“是一款开源项目，其持续稳定的开发离不开这些优秀的**支持者**。 如果您想加入他们，请考虑：

- 成为**阿里渣渣**赞助商
- 成为**阿里渣渣**创始合伙人
- 通过支付宝一次性捐赠

<img src="img/image-20210428083300991.png" width="300px">

##  赞助者列表

（按时间顺序排列）

- 不愿当弱者 ￥ 10
- Amanda ￥ 10
- 潇潇北风 ￥ 1
- 心静如水 ￥ 2000
- 小丑鸭 ￥ 2000
- 人在江湖飘 ￥ 10
- 淦天雷 ￥ 20
- 江.  ￥ 10
- 北笙 ￥ 10
- 抱抱小熊 ￥ 10
- ε吧啦吧啦咘oοО￥ 20

## 捐赠者福利

- 10元以上捐赠者请加群主好友，拉***阿里渣渣javaVIP组***，享受群主手把手教学服务，附赠2T学习资料
- 2000元以上捐赠者请加群主好友，拉***阿里渣渣java前途组***，享受群主一对一的一年授课服务

### 如果你没有充裕的资金，我们都是lsp，帮忙点个Star吧！点个Star吧！点个Star吧！

### 官网博客：[googlevip8](http://googlevip8.com)
### 推荐：[java开发者专用导航网站](http://googlevip8.com/webstack/)
