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
      1. cacheEnabled	全局性地开启或关闭所有映射器配置文件中已配置的任何缓存。
      2. lazyLoadingEnabled	延迟加载的全局开关。当开启时，所有关联对象都会延迟加载。 特定关联关系中可通过设置 fetchType 属性来覆盖该项的开关状态。
      3. logImpl	指定 MyBatis 所用日志的具体实现，未指定时将自动查找。
   5. 映射
      1. 映入接口的实现类（UserMapper.xml）
   6. 生命周期
      1. 生命周期和作用域是至关重要的，因为错误的使用会导致非常严重的并发问题
      ![img.png](img.png)
      2. sqlSessionFactoryBuilder
         1. 一旦创建了sqlSessionFactory，就不再需要它了
         2. 局部变量
      3. sqlSessionFactory
         1. 说白了就是可以想象为，数据库连接池
         2. sqlSessionFactory一旦被创建就应该再应用的运行期间一直存在，**没有任何理由丢弃它或重新创建一个实例**
         3. 因此sqlSessionFactory的最佳作用域是应用作用域。
         4. 最简单的就是使用单例模式或者静态单例模式
      4. sqlSession
         1. 链接到连接池的一个请求
         2. sqlSession的实例不是线程安全的，因此是不能被共享的，所以它的最佳作用域是请求或方法作用域
         3. 用完之后需要赶紧关闭，否则资源被占用
      
   7. 解决属性名和字段名不一致的问题
      1. 解决方法，起别名（sql中起别名，与属性对应）
      2. UserMapper.xml中的 resultType="user" 改为  resultMap="UserMap",并设置相对应的映射
      3. 
