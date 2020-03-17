create table athlete
(
    id           int auto_increment comment '主键'
        primary key,
    athlete_code varchar(20)                    not null comment '运动员编码，自动生成，全局唯一',
    reg_code     varchar(50)                    not null comment '运动员注册号，手填，队伍唯一',
    team_code    varchar(20)                    not null comment '参赛队伍编码',
    name         varchar(20)                    not null comment '姓名',
    id_number    varchar(50)                    not null comment '证件号',
    id_type      enum ('1', '2', '3', '4', '5') not null comment '证件类型',
    gender       enum ('0', '1')                not null comment '性别',
    age          int                            not null comment '年龄',
    created_at   datetime                       not null comment '创建时间',
    updated_at   datetime                       not null comment '更新时间',
    created_by   varchar(50)                    not null comment '创建人',
    updated_by   varchar(50)                    not null comment '更新人'
);

