drop table if exists dic_staff;
/*==============================================================*/
/* Table: dic_staff                                             */
/*==============================================================*/
create table dic_staff
(
   id                   bigint not null auto_increment comment '自增长主键',
   uuid                 char(32) not null comment '表单UUID',
   bill_no              varchar(100) not null comment '表单编号',
   name                 varchar(50),
   age                  tinyint unsigned,
   create_time          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   edit_time            datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   delete_flag          tinyint not null default 0 comment '删除标志:''0''表示正常;''1''表示逻辑删除',
	 PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_index_uuid` (`uuid`)
) DEFAULT CHARSET=utf8mb4 COMMENT='全体职工';