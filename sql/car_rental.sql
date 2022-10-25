use `ry-vue`;

-- 根菜单
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query, is_frame, is_cache,
                      menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time,
                      remark)
VALUES (5, '资产管理', 0, 5, 'asset', null, '', 1, 0, 'M', '0', '0', '', 'tool', 'admin', '2022-10-26 00:05:06',
        '', null, '资产管理目录');

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
    status      char(1)       default '0' comment '车辆状态（0正常1停用2已租）',
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
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('车辆信息', '5', '1', 'cars', 'info/cars/index', 1, 0, 'C', '0', '0', 'info:cars:list', '#', 'admin', sysdate(),
        '', null, '车辆信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('车辆信息查询', @parentId, '1', '#', '', 1, 0, 'F', '0', '0', 'info:cars:query', '#', 'admin', sysdate(), '',
        null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('车辆信息新增', @parentId, '2', '#', '', 1, 0, 'F', '0', '0', 'info:cars:add', '#', 'admin', sysdate(), '',
        null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('车辆信息修改', @parentId, '3', '#', '', 1, 0, 'F', '0', '0', 'info:cars:edit', '#', 'admin', sysdate(), '',
        null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('车辆信息删除', @parentId, '4', '#', '', 1, 0, 'F', '0', '0', 'info:cars:remove', '#', 'admin', sysdate(), '',
        null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status,
                      perms, icon, create_by, create_time, update_by, update_time, remark)
values ('车辆信息导出', @parentId, '5', '#', '', 1, 0, 'F', '0', '0', 'info:cars:export', '#', 'admin', sysdate(), '',
        null, '');

-- 车辆状态字典
INSERT INTO `ry-vue`.sys_dict_type (dict_id, dict_name, dict_type, status, create_by, remark)
VALUES (100, '车辆状态', 'info_cars_status', '0', 'admin', '车辆状态列表');


INSERT INTO sys_dict_data (dict_code, dict_sort, dict_label, dict_value, dict_type, list_class, is_default, status,
                           create_by, remark)
VALUES (100, 0, '正常', '0', 'info_cars_status', 'success', 'N', '0', 'admin', '车辆正常');
INSERT INTO sys_dict_data (dict_code, dict_sort, dict_label, dict_value, dict_type, list_class, is_default, status,
                           create_by, remark)
VALUES (101, 1, '停用', '1', 'info_cars_status', 'danger', 'N', '0', 'admin', '车辆停用');
INSERT INTO sys_dict_data (dict_code, dict_sort, dict_label, dict_value, dict_type, list_class, is_default, status,
                           create_by, remark)
VALUES (102, 3, '已租', '3', 'info_cars_status', 'info', 'N', '0', 'admin', '车辆已租');

# 门店信息表
drop table if exists bsn_stores;
create table bsn_stores
(
    store_id      bigint(20)   not null auto_increment comment '门店ID',
    store_name    varchar(100) not null comment '门店名称',
    store_address varchar(500) default null comment '门店地址',
    store_manager bigint(20)   default null comment '店长ID',
    store_own     int(8)       default 0 comment '所属车辆数',
    store_type    char(1)      default null comment '门店类型',
    status        char(1)      default '0' comment '门店状态（0正常1停用）',
    create_by     varchar(64)  default '' comment '创建者',
    create_time   datetime comment '创建时间',
    update_by     varchar(64)  default '' comment '更新者',
    update_time   datetime comment '更新时间',
    remark        varchar(500) default null comment '备注',
    primary key (store_id)
) engine = innodb
  auto_increment = 10 comment ='门店信息表';

insert into bsn_stores
values (1, '默认初始', null, 1, 0, '1', '0', 'admin', sysdate(), '', null, '默认初始门店');

# 门店词典SQL
INSERT INTO `ry-vue`.sys_dict_type (dict_id, dict_name, dict_type, status, create_by, remark)
VALUES (101, '门店状态', 'info_store_status', '0', 'admin', '门店状态列表');

INSERT INTO `ry-vue`.sys_dict_data (dict_code, dict_sort, dict_label, dict_value, dict_type, css_class, list_class,
                                    is_default, status, create_by, remark)
VALUES (103, 0, '正常', '0', 'info_store_status', '0', 'primary', 'N', '0', 'admin', '门店正常');
INSERT INTO `ry-vue`.sys_dict_data (dict_code, dict_sort, dict_label, dict_value, dict_type, css_class, list_class,
                                    is_default, status, create_by, remark)
VALUES (104, 1, '停用', '1', 'info_store_status', null, 'info', 'N', '0', 'admin', '门店停用');

INSERT INTO `ry-vue`.sys_dict_type (dict_id, dict_name, dict_type, status, create_by, remark)
VALUES (102, '门店类型', 'info_store_type', '0', 'admin', '门店类型列表');

INSERT INTO `ry-vue`.sys_dict_data (dict_code, dict_sort, dict_label, dict_value, dict_type, css_class, list_class,
                                    is_default, status, create_by, remark)
VALUES (105, 0, '默认厂店', '0', 'info_store_type', null, 'default', 'N', '0', 'admin', '系统默认厂店');
INSERT INTO `ry-vue`.sys_dict_data (dict_code, dict_sort, dict_label, dict_value, dict_type, css_class, list_class,
                                    is_default, status, create_by, remark)
VALUES (106, 1, '普通门店', '1', 'info_store_type', null, 'default', 'N', '0', 'admin', '普通门店');
INSERT INTO `ry-vue`.sys_dict_data (dict_code, dict_sort, dict_label, dict_value, dict_type, css_class, list_class,
                                    is_default, status, create_by, remark)
VALUES (107, 2, '工厂店', '2', 'info_store_type', 'colors:#B0C4DE', 'default', 'N', '0', 'admin', '可维修车辆门店');
INSERT INTO `ry-vue`.sys_dict_data (dict_code, dict_sort, dict_label, dict_value, dict_type, css_class, list_class,
                                    is_default, status, create_by, remark)
VALUES (108, 3, '旗舰店', '3', 'info_store_type', null, 'default', 'N', '0', 'admin', '品牌旗舰店');

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('门店信息', '5', '1', 'stores', 'info/stores/index', 1, 0, 'C', '0', '0', 'info:stores:list', '#', 'admin', sysdate(), '', null, '门店信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('门店信息查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'info:stores:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('门店信息新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'info:stores:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('门店信息修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'info:stores:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('门店信息删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'info:stores:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('门店信息导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'info:stores:export',       '#', 'admin', sysdate(), '', null, '');
