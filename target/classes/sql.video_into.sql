-- auto-generated definition
create table video_info
(
    id          varchar(255)  primary key,
    uri         varchar(255)  null comment '地址',
    title       varchar(255)  null comment '主题',
    img_url     varchar(255)  null comment '图片地址',
    down_status int default 0 null
)
    comment '视频详情';

