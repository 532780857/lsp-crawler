package com.googlevip8.lspCrawler.video.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 视频详情
 * </p>
 *
 * @author MT
 * @since 2021-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("video_info")
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String id;
    /**
     * 地址
     */
    private String uri;

    /**
     * 主题
     */
    private String title;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 下载状态
     */
    private Integer downStatus;


}
