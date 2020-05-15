# spring-boot-dubbo-api

## 简介
基于Spring Boot + Dubbo + Nacos + MyBatis plus 注解方式实现微服务调用的种子项目，
用于快速构建API项目，特点稳定、简单、快速，摆脱那些重复劳动

## 版本
SpringBoot版本:2.2.0  
Dubbo版本:2.7.3  
Nacos版本:1.2.1  
JDK版本:1.8  
MyBatisPlus版本:3.3.0

## 特征&提供
- 统一响应结果封装及生成工具
- 统一异常处理
- 采用简单的jwt认证
- 使用Druid Spring Boot Starter 集成Druid数据库连接池与监控
- 集成MyBatis-Plus，实现单表业务零SQL

## 快速开始
1. 克隆项目, 下载并启动nacos
2. 导入```doc```包里的mysql脚本user.sql）
3. 对环境配置文件```application.yml```进行配置，
4. 先启动provider，再启动consumer，Have Fun！

## 开发建议
- post调用接口ip:8862/api/user/login,参数json: {"username":"admin","password":"123456"},调用成功后, 返回token。以后调用api接口，header中传token
- Model内成员变量建议与表字段数量对应，如需扩展成员变量（比如连表查询）建议创建DTO，否则需在扩展的成员变量上加@TableField(exist = false)，详见[MyBatis-Plus](https://mp.baomidou.com/guide/)文档说明
- 建议业务失败直接使用ServiceException("ErrorMessage")抛出，由统一异常处理器来封装业务失败的响应结果，会直接被封装为{"code":400,"message":"ErrorMessage"}返回，尽情抛出；body方式传参，@Valid校验Model，更无需自己处理；

## 相关文档
- Spring Boot（[springboot官方](https://spring.io/projects/spring-boot/)）
- Dubbo（[Apache Dubbo官方](http://dubbo.apache.org/zh-cn/index.html)）
- Nacos（[Nacos官方](https://nacos.io/zh-cn/docs/quick-start.html)）
- MyBatis-Plus ([查看官方中文文档](https://mp.baomidou.com/guide/))
- MyBatis-Plus分页插件（[查看官方中文文档](https://mp.baomidou.com/guide/page.html)）
- Druid Spring Boot Starter（[查看官方中文文档](https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter/)）
- Fastjson（[查看官方中文文档](https://github.com/Alibaba/fastjson/wiki/%E9%A6%96%E9%A1%B5)）
- 阿里巴巴Java开发手册[最新版下载](https://github.com/alibaba/p3c)
其他

## License
纯粹开源分享，感谢大家 [Star](https://gitee.com/zwens/springboot-dubbo-api) 的支持。
