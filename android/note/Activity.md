# Activity

## Layout

```xml
<?xml version="1.0" encoding="utf-8"?>

<!--
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_quiz"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="16dp"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:paddingTop="16dp"
    tools:context="com.example.myapplication.MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!" />

</RelativeLayout>
-->
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical" >

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="24dp"
        android:text="@string/question_text" />

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal" >

        <Button
            android:id="@+id/true_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/true_button" />

        <Button
            android:id="@+id/false_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/false_button" />

    </LinearLayout>

</LinearLayout>
```

## xxxxActivity

> Activity（Java代码）和布局文件关联

`setContentView(R.layout.activity_main);`

源码

```java
# AppCompatActiviay.java
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        getDelegate().setContentView(layoutResID);
    }
```

### 资源与资源ID

> 资源：图像文件、音频文件以及XML文件；Android中项目的所有资源文件都存放在目录`app/res`的子目录下

> 资源ID: Android Studio自动编译的`R.java`文件

### 设置Activity的标题

` public void setTitle(int titleId)`



```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.title);
    }
```

## 布局组件与Activity的关联

### find By View Id

#### 给组件添加id

> 在Button组件中添加id属性
>
> > `android:id="@+id/true_button" ` 
>

```xml
<!-- ... -->
<Button
    android:id="@+id/true_button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/true_button" />

<Button
    android:id="@+id/false_button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/false_button" />
<!-- ... -->
```



#### 在Activity类中添加Button对象 && 引用xml文件中的Button组件

> 导入Button类
>
> > import android.widget.Button;
>
> 添加Button成员
>
> > private Button mTrueButton;
> >
> > private Button mFalseButton;
>
> 引用xml文件中的组件
>
> > mTrueButton = findViewById(R.id.true_button);
> >
> > mFalseButton = finaViewById(R.id.false_button);
>
> 为Button设置监听器
> > ```java
> > mTrueButton.setOnClickListener(new View.OnClickListener(){
> >     @Override
> >     public void onClick(View view) {
> >         // do something
> >     }
> > });
> > # lambda
> > mTrueButton.setOnClickListener(view->{
> >   // do something  
> > });
> > ```

```java
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // do somethind
            }
        });
    }
}
```



