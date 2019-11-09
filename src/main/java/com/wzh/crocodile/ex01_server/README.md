## 完成一个简单的web服务器

基于ex00socket的尝试，使用socket技术实现一个简单的web服务器

### 1、Request类用于封装Http请求信息

获取socket的输入流，获取请求数据信息

### 2、Response类用于封装Http响应信息

获取socket的输出流，用于输出响应信息

### 3、HttpServer类为服务器：
监听端口，获取socket。
创建Request和Response的实例，用于处理解析请求，并返回响应结果

PS：

支持响应静态文件，静态文件存放于项目根目录下的webroot目录下，如：html文件