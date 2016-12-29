## SimpleV
准备写一个Java web框架练手，实现了一个简单的模板渲染框架，提供文件位置和渲染变量即可返回渲染的数据。还在完善中，性能不能保证，仅供学习使用。
###属性说明
| 属性         |            含义 | 默认值             |
|:------------:|:---------------:|:------------------:|
| fileNamePath | 模板目录        | 项目地址/resources/|
| encoding     | 编码            | UTF-8              |
| templateMap  | 是否使用模板map | false              |
###配置文件
目前只有关于模板目录、编码和是否使用模板hash三个属性设置。
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE simplev SYSTEM "simplev_1_0.dtd">
<simplev>
    <file-dir>src\main\resources\</file-dir>
    <encoding>UTF-8</encoding>
    <template>
        <template-is-map>true</template-is-map>
    </template>
</simplev>
```
###使用实例
首先获得模板引擎
```java
    import app.*;
    SimpleV.init();
    SimpleVEngine sve = SimpleV.engine(fileName);
```
然后初始化渲染字典
```java
    import context.*;
    Context con = new SimpleContext();
    con.put("name","Eder");
```
完整的实例
```java
    /*初始化框架，读取配置*/
    SimpleV.init(); 
    
    /*获取模板引擎*/        
    SimpleVEngine simpleVEngine = SimpleV.engine("test.txt");
    
    /*渲染字典*/
    Context con = new SimpleContext();
    con.put("name","Eder");
    
    /*获得渲染字符串*/
    String html = simpleVEngine.render(con);
```
###原理介绍


###支持语法
语法受到Django的影响。渲染字典支持{String, list}，{String,Object}2种类型，前置用于for语法的使用，后者渲染时，实质是将String位置替换为Object.toString()；

在渲染过程中凡是不符合词法的渲染变量都会按照文本输出；不符合语法部分则忽略变量标识符；各个语法可以互相嵌套和循环。
####1 变量
```html
{{变量名}}
{{变量名.变量名}}
```
变量使用**{{变量}}**形式写于模板中，渲染时替换字典中与其匹配的内容。支持"."获取变量值。
####2 if语法
与从语法类似使用格式如下：
```html
{% if x %}
函数体
{% else %}
函数体
{% endif %}
```
可以使用嵌套，else同样可以省略。其语义与C语言相同。其中if语句的判断条件 x 必须为布尔类型，否则整个函数体不显示。
####3 for语法
```html
{% for x in list %}
函数体
{% endfor %}
```
其中 x 是自定义局部变量，仅在函数体中有效；list是渲染变量。

####4 include语法
增加了加载功能，可以将include指向的文件包含进来，输出到相应位置。如果没有文件则会直接忽略，但是如果循环加载会报错
```html
{% include 文件名%}
```
加载过程中，渲染字典有效。



