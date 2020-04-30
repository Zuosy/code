# Java变量

## 命名规则

略

判断一个标识符的方法

* 判断是否可以标识符的首字符

    `Character.isJavaIdentifierStart('a')`

* 判断是否可以用作标识符

    `Character.isJavaIdentifierPart('a')`



>尽管`$`是一个合法的Java字符，但不要在自己的代码中使用这个字符。它只用在Java编译器或其他工具生成的名字中。

## 变量初始化

声明一个变量之后，必须用赋值语句对变量进行显式初始化，千万不要使用未初始化的变量。

```java
int vacationDays;
System.out.println(vacationDays);
```

在Java中，变量的声明尽可能地靠近变量第一次使用的地方，这是一种良好的程序编写风格。

> * C++注释：声明和定义的区别
>
>     ```cpp
>     int i = 10; // 定义
>     extern int i; // 声明
>     ```
>
>     在Java中，不区分声明与定义。

## 常量(final)

```java
public static void main(String[] args) {
    final int SIZE = 512;
}
```

关键字final表示这个变量只能被赋值一次。一旦被赋值之后，就不能够再更改了。习惯上，常量名使用全大写。

---

在Java中，经常希望某个常量可以在一个类中的多个方法中使用，通常将这些常量称为类常量。可以使用关键字`static final`设置一个类常量。

```java
# Math.java
public static final double E = 2.7182818284590452354;
public static final double PI = 3.14159265358979323846;
```

> * C++注释：`const`是Java保留的关键字，但目前并没有使用。在Java中，必须使用`final`定义常量。

---

# 运算符

![1588149856431](/home/zuoshiyu/.config/Typora/typora-user-images/1588149856431.png)

## Math

向下取整

```java
# public static double floor(double a);
public static void main(String[] args) {
    System.out.println((int) Math.floor(3.14));
    System.out.println((int) Math.floor(-3.14));
}
```

```txt
3
-4
```

## 数值之间的转换

![1588227498236](/home/zuoshiyu/.config/Typora/typora-user-images/1588227498236.png)

上图中的实线部分类型转换不会有精度缺失，虚线部分会有精度缺失。

## 强制类型转换

```JAVA
public static void main(String[] args) {
    double x = 9.997;
    int nx = (int) x; // 9
    int rnx = (int) Math.round(x); // 10
}
```

`double`转成`int`只是把整数部分转换。

如果要四舍五入则需要`Math.round(x)`转换。

>* 警告：如果试图将一个数值从一种类型强制转换为另一种类型，而又超出了目标类型的表示范围，结果就会截断成一个完全不同的值。例如，(byte)300的实际值为44。
>* C++注释：不要在boolean类型与任何数值类型之间进行强制类型转换，这样可以防止发生错误。只有极少数情况才需要将布尔类型转换为数值类型，这时可以使用条件表达式`b ? 1 : 0`

&&和||运算符是按照“短路”方式来求值的：

如果地一个操作书已经能够确定表达式的值，第二个操作数就不必计算了。

+ exp1 && exp2 

    when exp1 is false,  return false.won't execute exp2.

+ exp2 || exp2

    when exp1 is true, return true.won't execute exp2.

### 移位运算符<<、>>、>>>

* 注意：不存在`<<<`运算符

`<<`向左移位，用0填充

`>>`向右移位，当数字为正数时用0填充，当数字为负数时用1填充

`>>>`逻辑向右移位，用0填充

> + 警告：以为运算符的右操作数要完成模32的运算（除非左操作数是long类型，在这种情况下需要对右操作书模64）
>
>     ```JAVA
>     public static void main(String[] args) {
>         System.out.println(2 << 35); // 16
>         System.out.println(2L << 35); // 68719476736
>     }
>     ```
>
>     懂？

### 枚举类型

简单举例

```JAVA
public class MainApp {
    enum Size{SMALL, MEDIUM, LARGE, EXTRA_LARGE};
    public static void main(String[] args) {
        Size s1 = Size.SMALL;
        Size s2 = null;
        System.out.println(s1); // SMALL
        System.out.println(s2); // null
    }
}
```

### 字符串

#### 子串

> `public String substring(int beginIndex, int endIndex);`

```JAVA
String greeting = "Hello";
String s = greeting.substring(0, 3); // "Hel"
```

#### 拼接

+ 用`+`拼接
+ `String.join(delimiter, elements)`

```JAVA
public static void main(String[] args) {
    String str1 = "Hello ";
    String str2 = "World";
    String hello = str1 + str2;
    System.out.println(hello); // "Hello World"
    String awsl = String.join(" ", "A", "W", "S", "L");
    System.out.println(awsl); // "A W S L"
}
```

> `+`拼接字符串跟底层有关
>
> `public static String join(CharSequence delimiter, CharSequence... elements)`
>
> join方法拼接字符串需要有分割符

#### 不可变字符串

String类没有提供用于修改字符串的方法。

在Java文档中将String类对象称为不可变字符串。

不可变字符串有一个有点：编译器可以让字符串共享。

#### 检测字符串是否相等

+ 区分大小写`“hello".equals("world");`
+ 不区分大小写`"hello".equalsIgnoreCase("hello");`

> C++注释：C++的string类重载了==运算符；Java不支持重载运算符。
>
> C程序员通过`strcmp`函数比较字符串，Java的`compareTo`方法与`strcmp`类似
>
> `if(greeting.compareTo("Hello") == 0)...`
>
> 但是`equals`更好看、更清晰

#### 空字符串与null

判断一个字符串是否为空：

```JAVA
if (str.length() == )
// 或者
if (str.equals(""))
```

null表示目前没有任何对象与该变量关联

检查一个字符串是否为null

```JAVA
if (str == null)
```

有时要检查一个字符串既不是null也不为空字符串，这种情况下需要使用一下条件

```JAVA
if (str != null && str.length() != 0)
```

#### 码点与代码单元

`char`数据类型是一个采用UTF-16编码表示Unicode码点的代码单元。

