## SimpleV
一个简单的模板渲染框架，提供文件位置和渲染变量即可返回渲染好的数据。
###属性说明
| 属性         |            含义 | 默认值             |
|:------------:|:---------------:|:------------------:|
| fileNamePath | 模板目录        | 项目地址/resources/|
| encoding     | 编码            | UTF-8              |
| decoding     | 解码            | UTF-8              |
| templateMap  | 是否使用模板map | false              |
###使用说明
首先获得模板引擎
```java
    SimpleV.init();
    SimpleVEngine sve = SimpleV.engine(fileName);
```
然后初始化渲染变量
```java
    Context con = new SimpleContext();
    con.put()
```
完整的实例
```java
    import app.SimpleV;
    
    Class Test(){
        public static void main(String[] args){
        SimpleV.init();
        }
    }
```





