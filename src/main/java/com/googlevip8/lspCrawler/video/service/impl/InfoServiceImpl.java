package com.googlevip8.lspCrawler.video.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.googlevip8.lspCrawler.video.entity.Info;
import com.googlevip8.lspCrawler.video.mapper.InfoMapper;
import com.googlevip8.lspCrawler.video.service.IInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.Optional;

/**
 * <p>
 * 视频详情 服务实现类
 * </p>
 *
 * @author MT
 * @since 2021-05-03
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {

    @Autowired
    InfoMapper infoMapper;


    @Override
    public void add(Info info) {
        Optional.ofNullable(info).orElseThrow(()->new IllegalArgumentException("参数不能为空"));
        Optional.ofNullable(info.getTitle()).orElseThrow(()->new IllegalArgumentException("title不能为空"));
        Optional.ofNullable(info.getImgUrl()).orElseThrow(()->new IllegalArgumentException("imgUrl不能为空"));
        Optional.ofNullable(info.getUri()).orElseThrow(()->new IllegalArgumentException("uri不能为空"));
        Info haveOne = infoMapper.selectOne(Wrappers.<Info>lambdaQuery()
                .eq(Info::getId, info.getId()).last("LIMIT 1"));
        if (haveOne != null){
            System.out.println("已经存在了");
            return;
        }
        int insert = infoMapper.insert(info);
        if (insert != 1){
            throw new IllegalArgumentException("新增失败");
        }else {
            System.out.println("新增\"" +info.getTitle()+ "\"成功");
        }
    }

    @Override
    public Info sel(Integer i) {
        return infoMapper.selectOne(Wrappers.lambdaQuery(Info.class).eq(Info::getDownStatus,0).last("LIMIT "+i+",1" ));
    }

    @Override
    public void downStatus(String id) {
        Info info = new Info();
        info.setId(id);
        info.setDownStatus(1);
        infoMapper.updateById(info);
    }
}
