# mybatis-demo
一、新建数据库
二、新建项目
1.新建一个maven项目
2.删除src目录
3.导入maven依赖（基础工程搭建完成）
4.创建一个模块（module）
三、创建一个模块
1. 编写mybatis的核心配置文件(链接数据库)
2. 编写mybatis工具类
   四、编写代码
3. 实体类（pojo）
4. dao接口
5. 接口实现类（UserMapper.xml，由原来的UserDaoImpl转变为一个Mapper配置文件）
6. 测试（junit）
   常见问题：
   1. Error parsing SQL Mapper Configuration. Cause: java.io.IOException: Could not find resource com/ling/dao/UserMapper.xml

    因为maven由于他的约定大于配置，我们之后可能遇到，我们写的配置文件，无法被导出或者生效的问题，
    解决方案：再build中配置resources，来防止我们资源导出失败的问题
    ```xml
     <build>
            <resources>
                <resource>
                    <directory>src/main/resources</directory>
                    <includes>
                        <include>**/*.properties</include>
                        <include>**/*.xml</include>
                    </includes>
                    <filtering>true</filtering>
                </resource>
                <resource>
                    <directory>src/main/java</directory>
                    <includes>
                        <include>**/*.properties</include>
                        <include>**/*.xml</include>
                    </includes>
                    <filtering>true</filtering>
                </resource>
            </resources>
        </build>
    
    ```
   2. 数据库链接失败
      数据库的链接 方式由 useSSL=true 变成 useSSL=false
## 配置解析
   1. 核心配置文件
      1. mybatis-config.xml
      2. mybatis的配置
   2. 环境配置
      1. mybatis可以配置成适应多种环境
      2. 尽管可以配置多个环境，但每个sqlSessionFactory实例只能选择一种环境
      3. mybatis默认的事务管理器是JDBC(这个配置直接使用了 JDBC 的提交和回滚设施，它依赖从数据源获得的连接来管理事务作用域。)
      4. mybatis默认的链接是POOLED（这种数据源的实现利用“池”的概念将 JDBC 连接对象组织起来，避免了创建新的连接实例时所必需的初始化和认证时间。 这种处理方式很流行，能使并发 Web 应用快速响应请求。）
   3. 属性
       1. 这些属性可以在外部进行配置，并可以进行动态替换。你既可以在典型的 Java 属性文件中配置这些属性，也可以在 properties 元素的子元素中设置
       2. 编写配置文件(db.properties)
       3. 再核心配置文件中引入！！！！！（重点）也可以再其中增加引用配置，如果两个一样字段，优先使用外部配置
   
   4. 设置
        4. cacheEnabled	全局性地开启或关闭所有映射器配置文件中已配置的任何缓存。
        5. lazyLoadingEnabled	延迟加载的全局开关。当开启时，所有关联对象都会延迟加载。 特定关联关系中可通过设置 fetchType 属性来覆盖该项的开关状态。
        6. logImpl	指定 MyBatis 所用日志的具体实现，未指定时将自动查找。
