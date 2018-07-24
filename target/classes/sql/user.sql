create table user(
  id int AUTO_INCREMENT COMMENT '主键ID',
  user_name varchar(32) COMMENT '用户名',
  pass_word varchar(32) COMMENT '用户密码',
  age int COMMENT '用户年龄',
   PRIMARY KEY (ID)
)COMMENT='用户信息表';

create table sys_oper(
  id int AUTO_INCREMENT PRIMARY KEY comment '主键ID',
  oper_nm VARCHAR(32) NOT NULL COMMENT '操作员名称',
  oper_phone VARCHAR(24) NOT NULL COMMENT '操作员手机号',
  oper_email VARCHAR(64) COMMENT '操作员邮箱',
  oper_pwd VARCHAR(32) NOT NULL COMMENT '操作员密码',
  oper_type INT(1) NOT NULL COMMENT '操作员类型-0：系统操作员；1：普通操作员',
  last_log_tm DATE COMMENT '上次登录时间',
  log_sts INT(1) NOT NULL COMMENT '登录状态-0：未登录；1：已登录',
  pwd_fail_tm INT(1) COMMENT '密码错误次数',
  create_tm DATE COMMENT '创建时间',
  create_oper VARCHAR(32) COMMENT '创建操作员',
  update_tm DATE COMMENT '修改时间',
  update_oper varchar(32) COMMENT '修改操作员',
  tm_smp DATE COMMENT '时间戳'
)COMMENT = '	系统操作员信息表';
CREATE UNIQUE INDEX sys_oper_IU1 ON sys_oper(oper_phone);

