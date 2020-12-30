
drop table if exists hxtms_bidding_head;
CREATE TABLE `hxtms_bidding_head` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `uuid` char(32) NOT NULL DEFAULT '' COMMENT '投标书UUID',
  `bill_no` varchar(100) NOT NULL DEFAULT '' COMMENT '投标书编号',
  `tender_uuid` char(32) NOT NULL DEFAULT '' COMMENT '招标书UUID',
  `carriers_uuid` char(32) NOT NULL DEFAULT '' COMMENT '投标承运商UUID',
  `carriers_code` varchar(50) NOT NULL DEFAULT '' COMMENT '投标承运商Code',
  `carriers_name` varchar(100) NOT NULL DEFAULT '' COMMENT '投标承运商名称',
  `bidding_channel` tinyint(4) NOT NULL DEFAULT '0' COMMENT '投标渠道:0表示宏信,1表示其他',
  `merchant_uuid` char(32) NOT NULL DEFAULT '' COMMENT '商户UUID',
  `merchant_code` varchar(50) NOT NULL DEFAULT '' COMMENT '商户代码',
  `merchant_name` varchar(100) NOT NULL DEFAULT '' COMMENT '商户名称',
  `bill_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态:0,草稿、20,已发布、-100.已撤销',
  `creator_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '制单人ID',
  `creator_code` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人AD',
  `creator_name` varchar(128) NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `modify_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '修改人ID',
  `modify_code` varchar(32) NOT NULL DEFAULT '' COMMENT '修改人AD',
  `modify_name` varchar(128) NOT NULL DEFAULT '' COMMENT '修改人姓名',
  `notes` varchar(1000) NOT NULL DEFAULT '' COMMENT '备注',
  `commit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志:''0''表示正常;''1''表示逻辑删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_index_uuid` (`uuid`)
) DEFAULT CHARSET=utf8mb4 COMMENT='投标书主信息';

drop table if exists hxtms_bizunit;
CREATE TABLE `hxtms_bizunit` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `uuid` char(32) NOT NULL DEFAULT '' COMMENT 'uuid',
  `tender_uuid` char(32) NOT NULL DEFAULT '' COMMENT '标书uuid',
  `biz_unit_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '事业部ID',
  `biz_unit_code` varchar(50) NOT NULL DEFAULT '' COMMENT '事业部代码',
  `biz_unit_name` varchar(100) NOT NULL DEFAULT '' COMMENT '事业部名称',
  `source` tinyint(4) NOT NULL DEFAULT '0' COMMENT '可视范围的数据来源:0,代表招标书;1,代表中标书;2,代表投标书',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志:''0''表示正常;''1''表示逻辑删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_index_uuid` (`uuid`)
) DEFAULT CHARSET=utf8mb4 COMMENT='事业部信息';

drop table if exists hxtms_files;
CREATE TABLE `hxtms_files` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `uuid` char(32) NOT NULL DEFAULT '' COMMENT 'uuid',
  `bill_uuid` char(32) NOT NULL DEFAULT '' COMMENT '标书ID',
  `file_name` varchar(100) NOT NULL DEFAULT '' COMMENT '文件名称',
  `file_path` varchar(500) NOT NULL DEFAULT '' COMMENT '文件路径',
  `file_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '文件类型:0,代表默认;1,代表''招标文件'',2,代表''投标模板''',
  `bill_source` tinyint(4) NOT NULL DEFAULT '0' COMMENT '单据来源:0,代表''未设定'',1,代表''招标书'';2,代表''投标书'';3,代表''中标书''',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志:''0''表示正常;''1''表示逻辑删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_index_uuid` (`uuid`)
) DEFAULT CHARSET=utf8mb4 COMMENT='文件信息';

drop table if exists hxtms_invite_carriers;
CREATE TABLE `hxtms_invite_carriers` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `uuid` char(32) NOT NULL DEFAULT '' COMMENT 'uuid',
  `tender_uuid` char(32) NOT NULL DEFAULT '' COMMENT '招标书uuid',
  `carriers_uuid` char(32) NOT NULL DEFAULT '' COMMENT '承运商UUID',
  `carriers_code` varchar(50) NOT NULL DEFAULT '' COMMENT '承运商代码',
  `carriers_name` varchar(100) NOT NULL DEFAULT '' COMMENT '承运商名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志:''0''表示正常;''1''表示逻辑删除',
  `source` tinyint(4) NOT NULL DEFAULT '0' COMMENT '数据来源:0,代表招标书;1,代表中标书;2,代表投标书',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_index_uuid` (`uuid`)
) DEFAULT CHARSET=utf8mb4 COMMENT='邀请承运商';

drop table if exists hxtms_merchant_winbid_info;
CREATE TABLE `hxtms_merchant_winbid_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `uuid` char(32) NOT NULL DEFAULT '' COMMENT 'UUID',
  `carriers_uuid` char(32) NOT NULL DEFAULT '' COMMENT '承运商UUID',
  `carriers_name` varchar(100) NOT NULL DEFAULT '' COMMENT '承运商名称',
  `merchan_uuid` char(32) NOT NULL DEFAULT '' COMMENT '商户UUID',
  `merchan_code` varchar(50) NOT NULL DEFAULT '' COMMENT '商户代码',
  `merchan_name` varchar(100) NOT NULL DEFAULT '' COMMENT '商户名称',
  `winbid_uuid` char(32) NOT NULL DEFAULT '' COMMENT '中标书UUID',
  `tender_uuid` char(32) NOT NULL DEFAULT '' COMMENT '投标书UUID',
  `already_read` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已阅:0,代表未阅读;1代表已阅读',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志:''0''表示正常;''1''表示逻辑删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_index_uuid` (`uuid`)
) DEFAULT CHARSET=utf8mb4 COMMENT='商户中标信息表';

drop table if exists hxtms_rights_account;
CREATE TABLE `hxtms_rights_account` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `uuid` char(32) NOT NULL DEFAULT '' COMMENT 'UUID',
  `tender_uuid` char(32) NOT NULL DEFAULT '' COMMENT '招标书ID',
  `account_code` varchar(50) NOT NULL DEFAULT '' COMMENT '账户代码',
  `account_name` varchar(100) NOT NULL DEFAULT '' COMMENT '账户名称',
  `source` tinyint(4) NOT NULL DEFAULT '0' COMMENT '可视范围的数据来源:0,代表招标书;1,代表中标书;2,代表投标书',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志:''0''表示正常;''1''表示逻辑删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_index_uuid` (`uuid`)
) DEFAULT CHARSET=utf8mb4 COMMENT='可视范围';

drop table if exists hxtms_tender_head;
CREATE TABLE `hxtms_tender_head` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `uuid` char(32) NOT NULL DEFAULT '' COMMENT '招标书UUID',
  `bill_no` varchar(100) NOT NULL DEFAULT '' COMMENT '招标书编号',
  `tender_project` varchar(100) NOT NULL DEFAULT '' COMMENT '招标项目',
  `tender_name` varchar(100) NOT NULL DEFAULT '' COMMENT '招标书名称',
  `tender_starttime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '招标开始时间',
  `tender_endtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '招标截止时间',
  `expected_opendate` date NOT NULL DEFAULT '1900-01-01' COMMENT '预计开标日期',
  `tender_linkman` varchar(100) NOT NULL DEFAULT '' COMMENT '招标联系人',
  `tender_telnumber` varchar(50) NOT NULL DEFAULT '' COMMENT '联系电话',
  `tender_manner` tinyint(4) NOT NULL DEFAULT '0' COMMENT '招标方式:''0''表示公开招标;''1''表示邀请招标',
  `tender_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '招标类型：0,区域招标;1,干线招标',
  `should_quantity` bigint(20) NOT NULL DEFAULT '0' COMMENT '应投数量',
  `actual_quantity` bigint(20) NOT NULL DEFAULT '0' COMMENT '实投数量',
  `bill_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态:0,草稿、1,审批中、2,审批拒绝、10,审批通过、20,已发布、21,投标中、30,投标结束、40,已开标、-100.已撤销',
  `notes` varchar(1000) NOT NULL DEFAULT '' COMMENT '备注',
  `creator_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '制单人ID',
  `creator_code` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人AD',
  `creator_name` varchar(128) NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `modify_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '修改人ID',
  `modify_code` varchar(32) NOT NULL DEFAULT '' COMMENT '修改人AD',
  `modify_name` varchar(128) NOT NULL DEFAULT '' COMMENT '修改人姓名',
  `commit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `publisher_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '发布人ID',
  `publisher_code` varchar(32) NOT NULL DEFAULT '' COMMENT '发布人AD',
  `publisher_name` varchar(128) NOT NULL DEFAULT '' COMMENT '发布人姓名',
  `publish_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志:''0''表示正常;''1''表示逻辑删除',
  `task_id` varchar(128) NOT NULL DEFAULT '' COMMENT '工作流ID编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_index_uuid` (`uuid`)
) DEFAULT CHARSET=utf8mb4 COMMENT='招标书主信息';

drop table if exists hxtms_winbid_carriers;
CREATE TABLE `hxtms_winbid_carriers` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `uuid` char(32) NOT NULL DEFAULT '' COMMENT 'UUID',
  `winbid_uuid` char(32) NOT NULL DEFAULT '' COMMENT '中标书UUID',
  `carriers_uuid` char(32) NOT NULL DEFAULT '' COMMENT '承运商UUID',
  `carriers_code` varchar(50) NOT NULL DEFAULT '' COMMENT '承运商代码',
  `carriers_name` varchar(100) NOT NULL DEFAULT '' COMMENT '承运商名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志:''0''表示正常;''1''表示逻辑删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_index_uuid` (`uuid`)
) DEFAULT CHARSET=utf8mb4 COMMENT='中标承运商';

drop table if exists hxtms_winbid_head;
CREATE TABLE `hxtms_winbid_head` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `uuid` char(32) NOT NULL DEFAULT '' COMMENT '中标书uuid',
  `tender_uuid` char(32) NOT NULL DEFAULT '' COMMENT '招标书编号',
  `bill_no` varchar(100) NOT NULL DEFAULT '' COMMENT '中标书编号',
  `tender_result` tinyint(4) NOT NULL DEFAULT '0' COMMENT '招标结果:0表示失败,1表示成功',
  `bill_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态:0,草稿、1,审批中、2,审批拒绝、10,审批通过、20,已发布、-100.已撤销',
  `public_degree` tinyint(4) NOT NULL DEFAULT '0' COMMENT '公开程度:0,代表''完全公开'';1,代表''投标者公开'';2,代表''中标者公开'';3,代表''不公开'';',
  `creator_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '制单人ID',
  `creator_code` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人AD',
  `creator_name` varchar(128) NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `modify_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '修改人ID',
  `modify_code` varchar(32) NOT NULL DEFAULT '' COMMENT '修改人AD',
  `modify_name` varchar(128) NOT NULL DEFAULT '' COMMENT '修改人姓名',
  `notes` varchar(1000) NOT NULL DEFAULT '' COMMENT '备注',
  `commit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `publisher_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '发布人ID',
  `publisher_code` varchar(32) NOT NULL DEFAULT '' COMMENT '发布人AD',
  `publisher_name` varchar(128) NOT NULL DEFAULT '' COMMENT '发布人姓名',
  `publish_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志:''0''表示正常;''1''表示逻辑删除',
  `task_id` varchar(128) NOT NULL DEFAULT '' COMMENT '工作流ID编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_index_uuid` (`uuid`)
) DEFAULT CHARSET=utf8mb4 COMMENT='中标书主信息';