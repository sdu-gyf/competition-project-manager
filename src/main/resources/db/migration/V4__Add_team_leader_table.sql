create table team_leader
(
    id          int auto_increment comment '主键'
        primary key,
    team_code   varchar(20)                    not null comment '参赛队伍编码，自动生成，全局唯一',
    leader_name varchar(20)                    not null comment '代表队名称',
    leader_job  enum ('1', '2')                not null comment '职务',
    ethnicity   varchar(50)                    not null comment '民族',
    gender      enum ('0', '1')                not null comment '性别',
    id_number   varchar(50)                    not null comment '证件号',
    id_type     enum ('1', '2', '3', '4', '5') not null comment '证件类型',
    created_at  datetime                       not null comment '创建时间',
    updated_at  datetime                       not null comment '更新时间',
    created_by  varchar(50)                    not null comment '创建人',
    updated_by  varchar(50)                    not null comment '更新人'
);

