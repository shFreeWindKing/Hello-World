drop table if exists sys_serial_number;
/*==============================================================*/
/* Table: sys_serial_number                                     */
/*==============================================================*/
CREATE TABLE `sys_serial_number` (
  `id`                  bigint not null auto_increment comment '自增长主键',
  `module_name`         varchar(50) not null DEFAULT '默认' COMMENT '模块名称',
  `module_code`         varchar(50) not null DEFAULT 'DEF' COMMENT '模块/表单编码（唯一的）',
  `config_templet`      varchar(50) not null DEFAULT 'DEFAULT' COMMENT '前缀 (使用的序列号模板)',
  `max_serial`          bigint not null DEFAULT 0 COMMENT '存放当前序列号的值',
  `pre_max_num`         bigint not null DEFAULT 0 COMMENT '预生成序列号存放到缓存的个数',
  `is_auto_increment`   tinyint not null default 0 COMMENT '是否自动增长模式，0：否  1：是',
  `create_time`         datetime not null default CURRENT_TIMESTAMP comment '创建时间',
  `edit_time`           datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
  `delete_flag`         tinyint not null default 0 comment '删除标志:''0''表示正常;''1''表示逻辑删除',
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8mb4 COMMENT='序列自增长表';