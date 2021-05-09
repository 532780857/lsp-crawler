package com.googlevip8.lspCrawler.video.service;

import com.googlevip8.lspCrawler.video.entity.Info;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 视频详情 服务类
 * </p>
 *
 * @author MT
 * @since 2021-05-03
 */
public interface IInfoService extends IService<Info> {


    void add(Info info);

    Info sel(Integer i);

    void downStatus(String id);
}
