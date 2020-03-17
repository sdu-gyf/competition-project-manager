create table team
(
    id          int auto_increment comment '主键'
        primary key,
    team_code   varchar(20)  not null comment '参赛队伍编码，自动生成，全局唯一',
    team_name   varchar(20)  not null comment '代表队名称，唯一',
    province    varchar(20)  not null comment '所在省',
    contact     varchar(20)  not null comment '联系人',
    phone       varchar(50)  not null comment '联系电话',
    description varchar(255) not null comment '备注',
    created_at  datetime     not null comment '创建时间',
    updated_at  datetime     not null comment '更新时间',
    created_by  varchar(50)  not null comment '创建人',
    updated_by  varchar(50)  not null comment '更新人'
);

