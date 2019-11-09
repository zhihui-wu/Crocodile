## 添加外观类



Request和Response中存在与Servlet的service()不相干的方法。如Request的parse()方法和Response的sendStaticResource()方法

如果将Request和Response的实例直接传入service(),则在service()中可以直接调用上述方法。

所以在ex02servlet项目的基础上，给Request和Response添加外观类。使得Servlet的service()方法无法访问上述方法。现在parse()、getUri()等方法是安全的了