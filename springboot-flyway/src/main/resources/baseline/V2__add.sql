alter table user add email varchar(64) null comment '用户邮箱' after username;

alter table user add test varchar(64) null comment '测试' after email;
