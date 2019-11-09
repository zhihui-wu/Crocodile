## 连接器

#### 概述

Tomcat服务器中的Catalina有两个主要模块，连接器（connnector）和容器（container）。

现在，我们建立一个连接器来增强程序的功能，用一种更好的方法来创建request对象和response对象

#### 目录结构

+ ex03_connector

    - connector ------------------------------------------连接器模块
    
        + HttpConnector
        
        + HttpProcessor
        
        + HttpRequest
        
        + HttpResponse
        
        + SocketInputStream
        
    - core --------------------------------------------------核心模块
    
        + ServletProcessor
        
        + StaticResourceProcessor
        
    - Bootstrap -------------------------------------------启动类
