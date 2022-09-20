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
