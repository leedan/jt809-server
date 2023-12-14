CREATE TABLE `bus_gps`
(
    `id`        varchar(255) DEFAULT NULL,
    `vehicleno` varchar(50)  DEFAULT NULL,
    `lon`       varchar(255) DEFAULT NULL,
    `lat`       varchar(255) DEFAULT NULL,
    `sendtime`  datetime     DEFAULT NULL,
    `cjsj`      datetime     DEFAULT NULL,
    `vec1`      varchar(50)  DEFAULT NULL COMMENT '速度:指卫星定位车载终端设备上传的行车速度信息',
    `vec3`      varchar(50)  DEFAULT NULL COMMENT '车辆当前总里程数，值车辆上传的行车里程数',
    `vec2`      varchar(50)  DEFAULT NULL COMMENT '行驶记录速度',
    `direction` varchar(50)  DEFAULT NULL COMMENT '方向，0-359，单位为度',
    `altitude`  varchar(50)  DEFAULT NULL COMMENT '海拔高度，单位为米',
    `alarm`     varchar(50)  DEFAULT NULL COMMENT '报警状态',
    KEY `idx_vehicleno` (`vehicleno`),
    KEY `idx_id` (`id`),
    KEY `idx_sendtime` (`sendtime`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;