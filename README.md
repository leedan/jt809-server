# JT809-Server
## 简介

最近公司有个项目需要接收公交公司的实时推送的公交车位置数据。于是就用Netty简单实现了JT809协议的部分功能。

- ##### 服务端(上级平台)主链路

- ##### 主链路登录请求报文解析

- ##### 主链路登录应答消息

- ##### 车辆实时车辆定位信息消息报文解析

## 主要代码和使用

- 项目结构

![image](https://github.com/leedan/jt809-server/assets/11623253/2761c9dd-b9de-4047-9cb9-a36f7b2f1928)


### 解码适配器
![image](https://github.com/leedan/jt809-server/assets/11623253/2f47c095-a548-4290-bbaf-15427a240e6e)


亲测有效

```

