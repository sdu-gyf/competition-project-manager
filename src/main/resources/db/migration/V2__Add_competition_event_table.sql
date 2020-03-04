create table competition_event
(
    id                     int auto_increment comment '主键'
        primary key,
    competition_event_code varchar(20) not null comment '比赛项目编码，自动生成，全局唯一',
    competition_event_name varchar(20) not null comment '比赛项目名称',
    suite_type             int         not null comment '组别',
    plan_start_at          date        not null comment '计划开始日期',
    plan_end_at            date        not null comment '计划结束日期',
    status                 int         not null comment '状态',
    created_at             datetime(6) not null comment '创建时间',
    updated_at             datetime(6) not null comment '更新时间',
    created_by             varchar(50) not null comment '创建人',
    updated_by             varchar(50) not null comment '更新人'
);