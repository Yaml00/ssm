# 整合SSM

#### 1、数据库环境

- 创建一个存放书籍数据的数据库表

```mysql
CREATE DATABASE `ssmbuild`;

USE `ssmbuild`;

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
`bookID` INT(10) NOT NULL AUTO_INCREMENT COMMENT '书id',
`bookName` VARCHAR(100) NOT NULL COMMENT '书名',
`bookCounts` INT(11) NOT NULL COMMENT '数量',
`detail` VARCHAR(200) NOT NULL COMMENT '描述',
KEY `bookID` (`bookID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

INSERT  INTO `books`(`bookID`,`bookName`,`bookCounts`,`detail`)VALUES
(1,'Java',1,'从入门到放弃'),
(2,'MySQL',10,'从删库到跑路'),
(3,'Linux',5,'从进门到进牢');
```

#### 2、搭建idea基本环境

1. 新建一个maven项目，名称：ssm，添加web的支持

2. pom.xml

   - 导入相关的pom依赖(junit，数据库驱动，servlet，jsp，jstl，mybatis，mybatis-spring，spring，lombok，druid，log4j，slf4j-simple(这个暂时不知道干嘛用的，不过不导入会报一个提示))

   - Maven资源过滤设置

3. 建立基本结构和配置框架！

   - pers.shui.ssm.pojo
   - pers.shui.ssm.dao
   - pers.shui.ssm.service
   - pers.shui.ssm.controller
   - mybatis-config.xml
   - applicationContext.xml

#### 3、Mybatis层编写

1. 数据库配置文件 jdbc.properties
2. 编写MyBatis的核心配置文件(mybatis-config.xml)
   - 设置别名
   - 引入映射文件
3. 编写数据库对应的实体类 com.kuang.pojo.Books
4. 编写Dao层的 Mapper接口BookMapper
5. 编写接口对应的映射文件BookMapper.xml ，需要导入到核心配置文件mybatis-config.xml
6. 编写Service层的接口和实现类(BookService，BookServiceImpl)

#### 4、Spring层

1. 编写Spring整合Mybatis的相关的配置文件：spring-dao.xml

   - 关联数据库文件，配置数据源
   - 配置SqlSessionFactory
   - 配置扫描dao接口包

2. Spring整合service层：spring-service.xml

   - 扫描service相关的bean

   - 配置事务管理器

#### 5、SpringMVC层

1. web.xml

   - 配置编码过滤器CharacterEncodingFilter
   - 配置HiddenHttpMethodFilter过滤器
   - 注册前端控制器DispatcherServlet

2. spring-mvc.xml

   - 扫描controller相关的bean

   - 配置jsp 显示ViewResolver视图解析器
   - 开启mvc注解驱动

3. Spring配置整合文件：applicationContext.xml

#### 6、Controller 和 视图层编写

1. BookController 类编写 ， 方法一：查询全部书籍
2. 编写首页 index.jsp
3. 书籍列表页面 allbook.jsp

## 未完待续







