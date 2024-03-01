
# 概要

整套架构的命名规则以中国古代神话人物拼音生成，全部小写

## monkey1

猴子猴狲-用来验证的测试项目

项目1

## backend

后端项目

## 1.0.0

项目结构如下：
```
    -- common: 通用/普通代码包，应该都不是"bean"
        --- exception: 自定义异常放这里(如果是通用的，需要放到"wipo"公共项目内)
        --- utils 自定义工具类，请谨慎使用，避免重复造轮子
    -- config: 自定义的Configuration，请详细阅读medusa文档，避免重复自定义核心逻辑
    -- convertor: 数据转换器，pojo之间的数据转换推荐使用idea插件，而非BeanUtils
    -- dao: ORM持久层
        --- entity: 可以叫DO，持久化对象，可以直接映射生成表
        --- repository: 请参考JPA文档
    -- feign: RPC实现，微服务之间的内部调用，非API接口
    -- pojo: 分层领域模型
        --- bo: Business Object，业务对象。 由Service层输出的封装业务逻辑的对象。
        --- dto: Data Transfer Objec，数据传输对象。Service层接收的数据对象，DTO定位比较抽象，必要时也可取代"bo"作为service层输出对象使用(取决于bo是否是真的切合"业务逻辑对象包装").
        --- request: http请求对象
        --- response: http响应对象，等同于VO(View Object)    
    -- service: service层，数据的处理逻辑放这里
    -- web: controller层，请求定义、参数验证、返回结果定义放这里
    Bootstrap: 启动类
    -- resources
        --- application.properties: 系统定义内容，这些内容是系统启动的必须，且不需要改动，也不需要同步到config配置中心去
        --- application-dev.properties: 本地启动时的自定义配置，比如debug级别，一些功能的开关
        --- customized.properties: 自定义配置放这里，比你的@Value。 (这个配置打包时会被排除掉，需要config中心配置)
        --- environment.properties: 环境配置，mysql、redis、consul 等等。(这个配置打包时会被排除掉，需要config中心配置)
        --- logback-spring.xml: 大部分时间不需要你关心
```


