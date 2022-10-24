use `ry-vue`;

# 车辆信息表
drop table if exists bsn_cars;
create table bsn_cars
(
    car_id      bigint(20)   not null auto_increment comment '车辆ID',
    car_plate   varchar(100) not null comment '车牌号',
    brand       varchar(200) not null comment '品牌',
    type        varchar(200) not null comment '型号',
    model       char(1)      not null comment '车型',
    price       double(10, 2) default null comment '租金/天',
    deposit     double(10, 2) default null comment '押金',
    img         varchar(100)  default '' comment '车辆照片',
    store_id    bigint(20)    default null comment '归属门店ID',
    status      char(1)       default '0' comment '车辆状态(0正常1停用2已租)',
    create_by   varchar(64)   default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)   default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500)  default null comment '备注',
    primary key (car_id)
) engine = innodb
  auto_increment = 10 comment ='车辆表';

insert into bsn_cars
values (1, '测A10001', '大众', '捷达2021款', '1', 120, 1000, '', null, '0', 'admin', sysdate(), '', null, '测试车辆1');

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆信息', '5', '1', 'cars', 'info/cars/index', 1, 0, 'C', '0', '0', 'info:cars:list', '#', 'admin', sysdate(), '', null, '车辆信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆信息查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'info:cars:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆信息新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'info:cars:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆信息修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'info:cars:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆信息删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'info:cars:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆信息导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'info:cars:export',       '#', 'admin', sysdate(), '', null, '');